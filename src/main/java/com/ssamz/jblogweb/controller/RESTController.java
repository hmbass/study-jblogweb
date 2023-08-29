package com.ssamz.jblogweb.controller;

import com.ssamz.jblogweb.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {

    @GetMapping("/jblog")
    public User httpGet(){
        System.out.println("asdfasfas");
        User findUser = User.builder()
                .id(1)
                .username("hmbass")
                .password("password")
                .email("ddddd@dddd.com")
                .build();

        return findUser;
    }

    @PostMapping("/jblog")
    public String httpPost(User user){
        return "POST 요청 처리" + user.toString();
    }

    @PutMapping("/jblog")
    public String httpPut(@RequestBody User user){
        return "PUT 요청 처리 : " + user.toString() ;
    }

    @DeleteMapping("/jblog")
    public String httpDelete(@RequestParam int id){

        return "DELETE 요청 처리 : " + id;
    }
}
