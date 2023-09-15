package com.ssamz.jblogweb.persistence;

import com.ssamz.jblogweb.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
