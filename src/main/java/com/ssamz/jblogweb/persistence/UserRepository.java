package com.ssamz.jblogweb.persistence;

import com.ssamz.jblogweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // select * from users where username = ?;
    Optional<User> findByUsername(String username);
}
