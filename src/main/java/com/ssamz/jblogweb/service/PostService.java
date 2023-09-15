package com.ssamz.jblogweb.service;

import com.ssamz.jblogweb.domain.Post;
import com.ssamz.jblogweb.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public void insertPost(Post post){
        post.setCnt(0);
        postRepository.save(post);
    }
}