package com.example.demo.service;

import com.example.demo.dto.PostDTO;
import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public void fetchAndSavePost() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        PostDTO postDTO = restTemplate.getForObject(url, PostDTO.class);

        if (postDTO != null) {
            Post post = convertToEntity(postDTO);
            postRepository.save(post);
        }
    }

    private Post convertToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setUserId(postDTO.getUserId());
        post.setBody(postDTO.getBody());
        post.setTitle(postDTO.getTitle());
        return post;
    }
}
