package com.ssamz.jblogweb.controller;

import com.ssamz.jblogweb.domain.Post;
import com.ssamz.jblogweb.domain.User;
import com.ssamz.jblogweb.dto.ResponseDTO;
import com.ssamz.jblogweb.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @DeleteMapping("/post/{id}")
    public @ResponseBody ResponseDTO<?> deletePost(@PathVariable int id){
        postService.deletePost(id);
        return new ResponseDTO<>(HttpStatus.OK.value(), id + "번 포스트 삭제");
    }

    @PutMapping("/post")
    public @ResponseBody ResponseDTO<?> updatePost(@RequestBody Post post){
        postService.updatePost(post);
        return new ResponseDTO<>(HttpStatus.OK.value(), post.getId() + "번 수정완료");
    }

    @GetMapping("/post/updatePost/{id}")
    public String updatePost(@PathVariable int id, Model model){
        model.addAttribute("post", postService.getPost(id));
        return "post/updatePost";
    }

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable int id, Model model){
        model.addAttribute("post", postService.getPost(id));
        return "post/getPost";
    }

    /*
    @GetMapping({"", "/"})
    public String getPostList(){
        return "index";
    }
     */

    /*
    @GetMapping({"", "/"})
    public String getPostList(Model model){
        model.addAttribute("postList", postService.getPostList());
        return "index";
    }
     */

    @GetMapping({"", "/"})
    public String getPostList(Model model, @PageableDefault(size = 3, sort = "id",
    direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("postList", postService.getPostList(pageable));
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
