package com.monu.productions_ready_features.services;


import com.monu.productions_ready_features.dto.PostDTO;
import com.monu.productions_ready_features.entities.PostEntity;
import com.monu.productions_ready_features.exceptions.ResourceNotFoundException;
import com.monu.productions_ready_features.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImplementation implements  PostService{


    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepo
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepo.save(postEntity), PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity = postRepo
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id "+postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId) {
        PostEntity olderPost = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id "+postId));
        inputPost.setId(postId);
        modelMapper.map(inputPost, olderPost);
        PostEntity savedPostEntity = postRepo.save(olderPost);
        return modelMapper.map(savedPostEntity, PostDTO.class);
    }
}
