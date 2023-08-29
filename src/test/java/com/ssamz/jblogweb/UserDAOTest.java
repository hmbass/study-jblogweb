package com.ssamz.jblogweb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ssamz.jblogweb.domain.User;
import com.ssamz.jblogweb.persistence.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    void getUserListTest(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("sadfsadfsa");
        user.setEmail("sdfsaf@asfdsad.com");

        int before = userDAO.getUserList().size();
        userDAO.insertUser(user);
        int after = userDAO.getUserList().size();
        System.out.println("================================");
        assertEquals(before+1, after);
    }
}
