package com.example.social_network.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.social_network.Model.Post;
import com.example.social_network.Model.User;

import com.example.social_network.Repository.PostRepository;
import com.example.social_network.exception.ResourceNotFoundException;


public class PostController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);   

    
    @Resource
    private PostRepository PostRepository;  
	
	@GetMapping("/post/{id}")
    public ResponseEntity<Post> getPstById(@PathVariable(value = "id") long id){
        Post post = PostRepository.findById(id);
        logger.info("Find User with ID :  {}", id);
        return ResponseEntity.ok().body(post);
    }
	
	
	/**
     * @param
     * @return List of posts
     */
    @SuppressWarnings("unchecked")
	@GetMapping("/posts")
    public List<Post> getAllPosts() {
        logger.info("Find all Posts");
        return PostRepository.findAll();
    }
    
    /**
     * @param id
     * @return post
     */
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable(value = "id") long id){
    	Post post = PostRepository.findById(id);
        logger.info("Find Post with ID :  {}", id);
        return ResponseEntity.ok().body(post);
    }
   
    /**
     * @param id, user
     * @return user, HttpStatus
     */ 
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post ){

    	Post postData = PostRepository.findById(id);
        
        //set data before update
    	postData.setContent(post.getContent());
        
        
        @SuppressWarnings("unchecked")
        Post updatedPost = (Post) PostRepository.save(postData);
        
        logger.info("Update Post with ID :  {}", id);
        
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }
    
	/**
     * @param id
     * @return Map<String,Boolean>
     */ 
    @SuppressWarnings("unchecked")
	@DeleteMapping("/posts/{id}")
    public Map<String, Boolean> deletePost(@PathVariable("id") long id)  {
        Post post = PostRepository.findById(id);

        PostRepository.delete(post);

        logger.info("Delete User with ID :  {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("User has been deleted!", Boolean.TRUE);
        
        return response;

    }
	 
}