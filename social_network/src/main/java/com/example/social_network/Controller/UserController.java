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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.social_network.Model.User;
import com.example.social_network.Repository.UserRepository;
import com.example.social_network.exception.ResourceNotFoundException;



/**
 * @author UserPC
 *
 */

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
    private static Logger logger = LoggerFactory.getLogger(UserController.class);   

    
    @Resource
    private UserRepository UserRepository;  
    
    
    
    /**
     * @param
     * @return List of user
     */
    @SuppressWarnings("unchecked")
	@GetMapping("/users")
    public List<User> getAllUsers() {
        logger.info("Find all Users");
        return UserRepository.findAll();
    }

    /**
     * @param id
     * @return user
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long id){
        User user = UserRepository.findById(id);
        logger.info("Find User with ID :  {}", id);
        return ResponseEntity.ok().body(user);
    }


    /**
     * @param user
     * @return user, HttpStatus
     */ 
    @PostMapping(path="/users")
    public ResponseEntity<User> createUser(@RequestBody User user) throws ResourceNotFoundException {
        @SuppressWarnings("unchecked")
		User newUser = (User) UserRepository.save(user);
        logger.info("Create User with ID : {}", newUser.getId());
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
    /**
     * @param id, user
     * @return user, HttpStatus
     */ 
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user ) throws ResourceNotFoundException {

        User userData = UserRepository.findById(id);
        
        //set data before update
        userData.setName(user.getName());
        
        
        @SuppressWarnings("unchecked")
		User updatedUser = (User) UserRepository.save(userData);
        
        logger.info("Update User with ID :  {}", id);
        
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * @param id
     * @return Map<String,Boolean>
     */ 
    @SuppressWarnings("unchecked")
	@DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable("id") long id)  {
        User user = UserRepository.findById(id);

        UserRepository.delete(user);

        logger.info("Delete User with ID :  {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("User has been deleted!", Boolean.TRUE);
        
        return response;

    }    
    
    
    
    
    
    
    
	

}

