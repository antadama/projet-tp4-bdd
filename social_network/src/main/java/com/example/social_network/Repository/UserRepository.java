package com.example.social_network.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.social_network.Model.User;

@Repository
public interface UserRepository extends MongoRepository {
	User findById(long id);
}