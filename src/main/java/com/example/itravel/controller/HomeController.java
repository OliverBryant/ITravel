package com.example.itravel.controller;

import com.example.itravel.entity.Page;
import com.example.itravel.entity.Ticket;
import com.example.itravel.entity.Tourist;
import com.example.itravel.service.TicketService;
import com.example.itravel.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private TouristService touristService;
    @Autowired
    private TicketService ticketService;

    @RequestMapping(path = "index", method = RequestMethod.GET)
    public String getIndex(Model model) {
        List<Tourist> list = touristService.selectTourist(0,0);
        // System.out.println(list);
        List<Map<String, Object>> maps = new ArrayList<>();
        if (list != null) {
            for (Tourist t : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("tourist", t);
                maps.add(map);
            }
        }
        model.addAttribute("tourist1", maps);
        return "index";
    }
//  用于测试 无用
//    @RequestMapping(path = "/ticket", method = RequestMethod.GET)
//    public String getTicket(Model model) {
//        List<Ticket> list = ticketService.selectTicket();
//        List<Map<String, Object>> maps = new ArrayList<>();
//        if (list != null) {
//            for (Ticket t : list) {
//                Map<String, Object> map = new HashMap<>();
//                map.put("ticket", t);
//                maps.add(map);
//            }
//        }
//        model.addAttribute("ticket", maps);
//        return "ticket";
//    }

    @RequestMapping(path = "/index/{searchId}", method = RequestMethod.GET)
    public String getSearch(@PathVariable("searchId") String searchId, Model model, String name, String area) {
        List<Tourist> list;
        if (searchId.equals("search1")) {
            list = touristService.selectTouristByArea(area);
        } else {
            list = touristService.selectTouristByName(name);
        }
        List<Map<String, Object>> maps = new ArrayList<>();
        if (list != null) {
            for (Tourist t : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("tourist", t);
                maps.add(map);
            }
        }
        model.addAttribute("tourist1", maps);
        return "index";
    }

    @RequestMapping(path = "/control", method = RequestMethod.GET)
    public String getControl(Model model, Page page) {
//        分页 enity/Page control.html
        page.setLimit(10);
        page.setPath("/control");
        page.setRows(touristService.slectNum());
        List<Tourist> touristList = touristService.selectTourist(page.getOffset(), page.getLimit());
        List<Ticket> ticketList = ticketService.selectTicket();
//        将取到的数据存入map 将map每行对应的数据对象存到list集合 便于把数据传到前端
        List<Map<String, Object>> maps = new ArrayList<>();
//        map maps存旅游景点
        List<Map<String, Object>> maps1 = new ArrayList<>();
//        map1 maps1存票

        if (touristList != null) {
            for (Tourist tourist : touristList) {
                //System.out.println(tourist);
                for (Ticket ticket : ticketList) {
                    if (tourist.getTouristattractionid().equals(ticket.getTouristAttractionID())) {
                        if (ticket.getType().equals("001")) {
                            tourist.setAdultnum(ticket.getMaxnums());
                            tourist.setAdultprice(ticket.getTicketprice());
                        }
                        if (ticket.getType().equals("002")) {
                            tourist.setStudentnum(ticket.getMaxnums());
                            tourist.setStudentprice(ticket.getTicketprice());
                        }
                        if (ticket.getType().equals("003")) {
                            tourist.setChildnum(ticket.getMaxnums());
                            tourist.setChildprice(ticket.getTicketprice());
                        }
                        if (ticket.getType().equals("004")) {
                            tourist.setOldnum(ticket.getMaxnums());
                            tourist.setOldprice(ticket.getTicketprice());
                        }
                    }
                }
                Map<String, Object> map = new HashMap<>();
                map.put("tourist", tourist);
                maps.add(map);
            }
        }
        System.out.println(touristList);
        if (ticketList != null) {
            for (Ticket ticket : ticketList) {
                Map<String, Object> map1 = new HashMap<>();
                map1.put("ticket", ticket);
                maps1.add(map1);
//                maps1 map1用来存票的信息
            }
        }
        model.addAttribute("tourist1", maps);
        model.addAttribute("ticket", maps1);
        model.addAttribute("page",page);
//        model.addattribute(K,V)往前台传数据，可以传对象，可以传List
//        通过el表达式 ${}可以获取到
//        类似于request.setAttribute(“sts”,sts)效果一样。
        return "control";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String delete(String id) {
        System.out.println(id);
        //ticketService.Update(id);
        touristService.deletaTourist(id);

        return "redirect:control";
//        删除完返回control界面
    }

    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

//    get告诉服务器需要哪些信息 post是将信息提交给服务器去处理
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(String touristname, String touristaddress,
               String opentime, String closetime, String introduction, String region,
               int adultticket, int adultnum,
               int childtiket, int childnum,
               int oldticket, int oldnum,
               int studentticket, int studentnum) throws ParseException {
        System.out.printf(touristname + " " + touristaddress + " " +
                opentime + " " + closetime + " " + introduction + " " + region + " " +
                adultticket + " " + adultnum + " " + childtiket + " " + childnum + " " + oldticket + " " + oldnum + " " + studentticket + " " + studentnum);
//        uuid用于随机生成旅游景点和票的id 提高安全性
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
//时间的强制类型转换
        SimpleDateFormat OPT = new SimpleDateFormat("HH:mm");
        SimpleDateFormat COT = new SimpleDateFormat("HH:mm");
        Date open = OPT.parse(opentime);
        Date close = COT.parse(closetime);

//        从controller到service到dao到mapper存数据
        String id1 = shortBuffer.toString();
        Tourist tourist = new Tourist(id1, touristname, touristaddress, open, close, introduction, region);
        touristService.insert(tourist);

        if (adultnum != 0) {
            StringBuffer shortBuffer1 = new StringBuffer();
            String uuid1 = UUID.randomUUID().toString().replace("-", "");
            for (int i = 0; i < 8; i++) {
                String str = uuid1.substring(i * 4, i * 4 + 4);
                int x = Integer.parseInt(str, 16);
                shortBuffer1.append(chars[x % 0x3E]);
            }

//            uuid,旅游景点id,票价,票数,类型编号
            Ticket ticketAdult = new Ticket(shortBuffer1.toString(), id1, adultticket, adultnum, "001");
            ticketService.insert(ticketAdult);
        }

        if (studentnum != 0) {
//            如果数量不为零就存票的信息 同样生成uuid
            StringBuffer shortBuffer2 = new StringBuffer();
            String uuid2 = UUID.randomUUID().toString().replace("-", "");
            for (int i = 0; i < 8; i++) {
                String str = uuid2.substring(i * 4, i * 4 + 4);
                int x = Integer.parseInt(str, 16);
                shortBuffer2.append(chars[x % 0x3E]);
            }
//            真无语了学生票居然是004
            Ticket ticketStu = new Ticket(shortBuffer2.toString(), id1, studentticket, studentnum, "004");
            ticketService.insert(ticketStu);
        }

        if (childnum != 0) {
            StringBuffer shortBuffer3 = new StringBuffer();
            String uuid3 = UUID.randomUUID().toString().replace("-", "");
            for (int i = 0; i < 8; i++) {
                String str = uuid3.substring(i * 4, i * 4 + 4);
                int x = Integer.parseInt(str, 16);
                shortBuffer3.append(chars[x % 0x3E]);
            }

            Ticket ticketCh = new Ticket(shortBuffer3.toString(), id1, childtiket, childnum, "002");
            ticketService.insert(ticketCh);
        }

        if (oldnum != 0) {
            StringBuffer shortBuffer4 = new StringBuffer();
            String uuid4 = UUID.randomUUID().toString().replace("-", "");
            for (int i = 0; i < 8; i++) {
                String str = uuid4.substring(i * 4, i * 4 + 4);
                int x = Integer.parseInt(str, 16);
                shortBuffer4.append(chars[x % 0x3E]);
            }
            Ticket ticketOld = new Ticket(shortBuffer4.toString(), id1, oldticket, oldnum, "003");
            ticketService.insert(ticketOld);
        }
        return "redirect:control";
//        增加结束后回到control
    }


    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(String id, String name, String address, String openTime, String closeTime, String intro,
                         String Region, String ticketid, Integer num111, Float price11, Integer num222,
                         Float price22, Integer num333, Float price33, Integer num444, Float price44) throws ParseException {
        System.out.println(id + " " + ticketid + " " + name + " " + address + " " + openTime + " " + closeTime + " " + intro + " " + Region + " "
                + num111 + " " + price11 + " " + num222 + " " + price22 + " " + num333 + " " + price33 + " " + num444 + " " + price44 + " ");
//      字符串转换为java.util.Date 我从网页获取到的是string
//      通过改变格式变为特定格式的date型 改完之后的填入数据库
        SimpleDateFormat OPT = new SimpleDateFormat("HH:mm");
        SimpleDateFormat COT = new SimpleDateFormat("HH:mm");
        Date open1 = OPT.parse(openTime);
        Date close1 = COT.parse(closeTime);
//        填入数据库
        touristService.updateTourist(id, name, address, open1, close1, intro, Region);
//
        List<Ticket> list = ticketService.selectTicket();
        if (num111 > 0) {
//            如果这个票的数量的输入框(输入框111)大于零 才能进行修改 即如果数量为0 价格不为0 点击修改 价格也不会有变化
            boolean flag = false;
            for (Ticket t : list) {
//                遍历所有票 如果该票是属于该景点 且 该票的类型是成人票(满足这两个条件的票应是唯一的)
                if (id.equals(t.getTouristAttractionID()) && t.getType().equals("001")) {
                    ticketService.update111(t.getTicketid(), num111, price11, "001");
                    flag = true;
                }
            }
//            false说明以前这个景点没有这个票种 应该执行insert操作
            if (flag == false) {
//                给新票种分配uuid
                StringBuffer shortBuffer1 = new StringBuffer();
                String uuid1 = UUID.randomUUID().toString().replace("-", "");
                for (int i = 0; i < 8; i++) {
                    String str = uuid1.substring(i * 4, i * 4 + 4);
                    int x = Integer.parseInt(str, 16);
                    shortBuffer1.append(chars[x % 0x3E]);
                }
//                uuid,景点id,价格,数量,票种成人票
                Ticket ticketAdu = new Ticket(shortBuffer1.toString(), id, price11, num111, "001");
                ticketService.insert(ticketAdu);
            }
        } else {

        }
        if (num222 > 0) {
            boolean flag = false;
            for (Ticket t : list) {
                if (id.equals(t.getTouristAttractionID()) && t.getType().equals("002")) {
                    ticketService.update111(t.getTicketid(), num222, price22, "002");
                    flag = true;
                }
            }
            if (flag == false) {
                StringBuffer shortBuffer2 = new StringBuffer();
                String uuid2 = UUID.randomUUID().toString().replace("-", "");
                for (int i = 0; i < 8; i++) {
                    String str = uuid2.substring(i * 4, i * 4 + 4);
                    int x = Integer.parseInt(str, 16);
                    shortBuffer2.append(chars[x % 0x3E]);
                }
                Ticket ticketStu = new Ticket(shortBuffer2.toString(), id, price22, num222, "002");
                ticketService.insert(ticketStu);
            }
        }
        if (num333 > 0) {
            boolean flag = false;
            for (Ticket t : list) {
                if (id.equals(t.getTouristAttractionID()) && t.getType().equals("003")) {
                    ticketService.update111(t.getTicketid(), num333, price33, "003");
                    flag = true;
                }
            }
            if (flag == false) {
                StringBuffer shortBuffer3 = new StringBuffer();
                String uuid3 = UUID.randomUUID().toString().replace("-", "");
                for (int i = 0; i < 8; i++) {
                    String str = uuid3.substring(i * 4, i * 4 + 4);
                    int x = Integer.parseInt(str, 16);
                    shortBuffer3.append(chars[x % 0x3E]);
                }
                Ticket ticketCh = new Ticket(shortBuffer3.toString(), id, price33, num333, "003");
                ticketService.insert(ticketCh);
            }
        }
        if (num444 > 0) {
            boolean flag = false;
            for (Ticket t : list) {
                if (id.equals(t.getTouristAttractionID()) && t.getType().equals("004")) {
                    ticketService.update111(t.getTicketid(), num444, price44, "004");
                    flag = true;
                }
            }
            if (flag == false) {
                StringBuffer shortBuffer4 = new StringBuffer();
                String uuid4 = UUID.randomUUID().toString().replace("-", "");
                for (int i = 0; i < 8; i++) {
                    String str = uuid4.substring(i * 4, i * 4 + 4);
                    int x = Integer.parseInt(str, 16);
                    shortBuffer4.append(chars[x % 0x3E]);
                }
                Ticket ticketOld = new Ticket(shortBuffer4.toString(), id, price44, num444, "004");
                ticketService.insert(ticketOld);
            }
        }
//        删除票种  没有必要
//        for (Ticket t : list) {
//            if (id.equals(t.getTouristAttractionID())) {
//                if ("001".equals(t.getType()) && num111 <= 0) {
//                    ticketService.deleteById(id, "成人票");
//                }
//                if ("002".equals(t.getType()) && num222 <= 0) {
//                    ticketService.deleteById(id, "学生票");
//                }
//                if ("003".equals(t.getType()) && num333 <= 0) {
//                    ticketService.deleteById(id, "儿童票");
//                }
//                if ("004".equals(t.getType()) && num444 <= 0) {
//                    ticketService.deleteById(id, "老年票");
//                }
//            }
//        }
        return "redirect:control";
    }


}
