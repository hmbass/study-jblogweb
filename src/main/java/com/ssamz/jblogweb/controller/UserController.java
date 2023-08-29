package com.ssamz.jblogweb.controller;

import com.ssamz.jblogweb.domain.RoleType;
import com.ssamz.jblogweb.domain.User;
import com.ssamz.jblogweb.dto.ResponseDTO;
import com.ssamz.jblogweb.exception.JBlogException;
import com.ssamz.jblogweb.persistence.UserRepository;
import com.ssamz.jblogweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // User 등록
    @GetMapping("/auth/insertUser")
    public String insertUser() {
        return "user/insertUser";
    }
/*
    @PostMapping("/auth/insertUser")
    public @ResponseBody ResponseDTO<?> insertUser(@RequestBody User user){
        userService.insertUser(user);
        return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원가입 성공");
    }
 */
    @PostMapping("/auth/insertUser")
    public @ResponseBody ResponseDTO<?> insertUser(@RequestBody User user) {
        User findUser = userService.getUser(user.getUsername());

        if(findUser.getUsername() == null) {
            userService.insertUser(user);
            return new ResponseDTO<>(HttpStatus.OK.value(),
                    user.getUsername() + "가입 성공");
        } else {
            return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),
                    user.getUsername() + "님은 이미 회원");
        }
    }
}

