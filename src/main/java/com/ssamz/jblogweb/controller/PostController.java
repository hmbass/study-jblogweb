package com.ssamz.jblogweb.controller;

import com.ssamz.jblogweb.domain.Post;
import com.ssamz.jblogweb.domain.User;
import com.ssamz.jblogweb.dto.ResponseDTO;
import com.ssamz.jblogweb.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping({"", "/"})
    public String getPostList(){
        return "index";
    }

    @GetMapping("/post/insertPost")
    public String insertPost() {
        return "post/insertPost";
    }

    @PostMapping("/post")
    public @ResponseBody ResponseDTO<?> insertPost(@RequestBody Post post, HttpSession session) {
        // post 객체를 영속화하기 전 연관된 User 엔티티 설정
        User principal = (User) session.getAttribute("principal");
        post.setUser(principal);
        post.setCnt(0);

        postService.insertPost(post);

        return new ResponseDTO<>(HttpStatus.OK.value(), "새로운 포스트를 등록");
    }
}
