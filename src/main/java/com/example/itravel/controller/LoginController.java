package com.example.itravel.controller;

import com.example.itravel.entity.Director;
import com.example.itravel.entity.Tourist;
import com.example.itravel.service.DirectorService;
import com.example.itravel.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private TouristService touristService;

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String getLoginPage(){
        return "/site/login";
    }

    @RequestMapping(path = "login",method = RequestMethod.POST)
    public String login(String account, String password, Model model, HttpSession session){
        System.out.println(account+"!!!!!"+password);
        Map<String,Object> map = directorService.login(account,password);
        if(map.containsKey("success")){
            session.setAttribute("loginUser",account);
            return "redirect:/index";
        } else {
            System.out.println(map.get("passwordMsg"));
            model.addAttribute("usernameMsg",map.get("usernameMsg"));
            model.addAttribute("passwordMsg",map.get("passwordMsg"));
            return "/site/login";
        }
    }

    @RequestMapping(path = "jump",method = RequestMethod.POST)
    public String jump(){
            return "/site/login";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/login";
    }

    @RequestMapping(path = "/setting",method = RequestMethod.GET)
    public String getSetting(HttpSession session,Model model){

        String account = (String) session.getAttribute("loginUser");

        Director director = directorService.selectByAccount(account);
        session.setAttribute("loginUser",account);
        model.addAttribute("director",director);
        return "/site/directorReverse";
    }

    @RequestMapping(path = "setting",method = RequestMethod.POST)
    public String setting(String name,String phone,String email,HttpSession session){

        String account = (String) session.getAttribute("loginUser");
        directorService.updateInfo(account,name,phone,email);
        return "redirect:/index";
    }
    @RequestMapping(path = "/updatePassword",method = RequestMethod.GET)
    public String getUpdatePassword(HttpSession session,Model model){

        return "site/pwd_reverse";
    }
    @RequestMapping(path = "updatePassword",method = RequestMethod.POST)
    public String updatePassword(String password,HttpSession session,String old_password,Model model,String new_password){
        String account = (String) session.getAttribute("loginUser");
        Map<String,Object> map = directorService.login(account,old_password);
        if(!password.equals(new_password)){
            model.addAttribute("oldPasswordMsg","两次密码不一致");
            return "/site/pwd_reverse";
        }
        if(map.containsKey("success")){
            session.setAttribute("loginUser",account);
        } else {
            System.out.println(map.get("passwordMsg"));
            model.addAttribute("passwordMsg",map.get("passwordMsg"));
            return "/site/pwd_reverse";
        }
        directorService.updatePassword(account,password);
        return "redirect:/index";
    }

    @RequestMapping(path = "/please",method = RequestMethod.GET)
    public String getPleasePage(){
        return "/site/please";
    }

}
