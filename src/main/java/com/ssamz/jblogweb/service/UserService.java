package com.ssamz.jblogweb.service;

import com.ssamz.jblogweb.domain.RoleType;
import com.ssamz.jblogweb.domain.User;
import com.ssamz.jblogweb.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void insertUser(User user){
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    /*
    @Transactional(readOnly = true)
    public User getUser(String username){
        // 검색 결과가 없을 때 빈 User 객체 반환
        User findUser = userRepository.findByUsername(username).orElseGet(
                new Supplier<User>() {
                    @Override
                    public User get() {
                        return new User();
                    }
                });
        return findUser;
    */

    @Transactional(readOnly = true)
    public User getUser(String username){
        // 검색 결과가 없을 때 빈 객체 변환(람다식)
        User findUser = userRepository.findByUsername(username).orElseGet(
                ()-> {
                    return new User();
                });
        return findUser;
    }
}
