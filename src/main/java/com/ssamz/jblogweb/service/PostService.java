package com.ssamz.jblogweb.service;

import com.ssamz.jblogweb.domain.Post;
import com.ssamz.jblogweb.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public void deletePost(int id){
        postRepository.deleteById(id);
    }

    @Transactional
    public void updatePost(Post post){
        Post findPost = postRepository.findById(post.getId()).get();
        findPost.setTitle(post.getTitle());
        findPost.setContent(post.getContent());
    }

    @Transactional(readOnly = true)
    public Post getPost(int id){
        return postRepository.findById(id).get();
    }


    @Transactional
    public void insertPost(Post post){
        post.setCnt(0);
        postRepository.save(post);
    }

    /*
    @Transactional(readOnly = true)
    public List<Post> getPostList(){
        return postRepository.findAll();
    }
     */
    @Transactional(readOnly = true)
    public Page<Post> getPostList(Pageable pageable){
        return postRepository.findAll(pageable);
    }
}
