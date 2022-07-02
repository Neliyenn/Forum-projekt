package com.neliyenn.service.impl;

import com.neliyenn.model.Post;
import com.neliyenn.model.User;
import com.neliyenn.repository.PostRepository;
import com.neliyenn.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class PostServiceImp implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Collection<Post> findNLatestPosts(int n) {
        return nLatestPosts(n, postRepository.findAll());
    }

    @Override
    public Collection<Post> findNLatestPostsForUser(int n, User user) {
        return nLatestPosts(n, user.getPosts());
    }

    private Collection<Post> nLatestPosts(int n, Collection<Post> posts) {
        return posts
                .stream()
                .sorted((a, b) -> b.getCreateDate().compareTo(a.getCreateDate()))
                .limit(n)
                .collect(Collectors.toList());
    }

    @Override
    public Post findPostForId(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Page<Post> findAllPageable(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> findByUserOrderedByDatePageable(User user, Pageable pageable) {
        return postRepository.findByUserOrderByCreateDateDesc(user, pageable);
    }

    @Override
    public Page<Post> findAllOrderedByDatePageable(Pageable pageable) {
        return postRepository.findAllByOrderByCreateDateDesc(pageable);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

}
