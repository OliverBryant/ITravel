package com.example.itravel;

import com.example.itravel.entity.Director;
import com.example.itravel.service.DirectorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ITravelApplicationTests {

    @Autowired
    private DirectorService directorService;

    @Test
    void contextLoads() {
        Director director = new Director();
        director.setAccount("2019214266");
        director.setPassword("miaoyifan");
        directorService.login(director.getAccount(),director.getPassword());
    }

}
