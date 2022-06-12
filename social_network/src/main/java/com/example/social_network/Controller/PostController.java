package com.example.social_network.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.social_network.Model.Post;
import com.example.social_network.Model.User;
import com.example.social_network.config.securityService;

public class PostController {
	 @PostMapping("addpost")
	    public ResponseEntity<?> addPost(@RequestBody Post post) throws NullPointerException {
	        User user = securityService.getUser();
	        Post savedPost = postService.savePost(user,post.getContent());
	        return ResponseEntity.created(URI.create("/private/mypost")).body(savedPost);
	    }

	    @GetMapping("mypost")
	    public ResponseEntity<?> myPosts() throws NullPointerException {
	        User user=userService.getUser(securityService.getUser().getEmail());
	        List<Post> postList = postService.getPostsOfUser(user.getId());
	        return ResponseEntity.ok(postList);
	    }

	    @GetMapping("posts")
	    public ResponseEntity<List<Post>> getAllPosts(){
	        List<Post> postList = postService.getAllPost();
	        return ResponseEntity.ok(postList);
	    }

	    @GetMapping("/{userId}/posts")
	    public ResponseEntity<?> getPostofUser(@PathVariable Integer userId){
	        List<Post> postList = postService.getPostsOfUser(userId);
	        return ResponseEntity.ok(postList);
	    }
}
