package com.ssamz.jblogweb.controller;

import com.ssamz.jblogweb.domain.User;
import com.ssamz.jblogweb.dto.ResponseDTO;
import com.ssamz.jblogweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController_backup {
    @Autowired
//    private UserRepository userRepository;
    private UserService userService;

    // User 등록
/*
    @PostMapping("/user")
    public @ResponseBody String insertUser(@RequestBody User user) {
        user.setRole(RoleType.USER);
        userRepository.save(user);
        System.out.println("\t"+"#############");
        return user.getUsername() + " 회원가입 성공";
    }
 */
/*
    @GetMapping("/auth/insertUser")
    public String insertUser() {
        return "user/insertUser";
    }

    @PostMapping("/auth/insertUser")
    public @ResponseBody ResponseDTO<?> insertUser(@RequestBody User user){
        userService.insertUser(user);
        return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원가입 성공");
    }
*/



    /*
    // User 조회
    @GetMapping("/user/get/{id}")
    public @ResponseBody User getUser(@PathVariable int id){
        User findUser = userRepository.findById(id).get();
        return findUser;
    }
    */
    /*
    // User 조회
    @GetMapping("/user/get/{id}")
    public @ResponseBody User getUser(@PathVariable int id){

        User findUser = userRepository.findById(id).orElseThrow(new Supplier<JBlogException>() {
            @Override
            public JBlogException get() {
                return new JBlogException(id + "번 회원이 없습니다.");
            }
        });
        return findUser;
    }
    */
/*
    //람다식
    @GetMapping("/user/get/{id}")
    public @ResponseBody User getUser(@PathVariable int id){

        User findUser = userRepository.findById(id).orElseThrow(() -> {
            return new JBlogException(id + "번 회원이 없습니다.");
        });
        return findUser;
    }

    //user 수정
    @PutMapping("/user")
    public @ResponseBody String updateUser(@RequestBody User user){
        User findUser = userRepository.findById(user.getId()).orElseThrow(() -> {
            return new JBlogException(user.getId() + "번 회원이 없습니다.");
        });
        findUser.setUsername(user.getUsername());
        findUser.setPassword(user.getPassword());
        findUser.setEmail(user.getEmail());

        userRepository.save(findUser);
        return "수정 완료";
    }

    // user 삭제
    @DeleteMapping("/user/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "user 삭제 완료";
    }

    // user list
    @GetMapping("/user/list")
    public @ResponseBody List<User> getUserList(){
        return userRepository.findAll();
    }

    // page 처리
    @GetMapping("user/page/{page}")
    public @ResponseBody Page<User> getUserListPaging(@PathVariable int page) {
        Pageable pageable = PageRequest.of(page, 2, Sort.Direction.DESC, "id", "username");

        return userRepository.findAll(pageable);
    }

    // page 처리, 더 간편하게..., 동적으로 처리 가능
    @GetMapping("user/pageeasy")
    public @ResponseBody Page<User> getUserListPagingEasy(@PageableDefault(page = 0, size = 2, direction = Sort.Direction.DESC, sort = {"id", "username"}) Pageable pageable) {
        return userRepository.findAll(pageable);
    }
 */
}

