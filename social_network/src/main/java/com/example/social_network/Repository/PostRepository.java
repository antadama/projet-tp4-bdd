package com.example.social_network.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.social_network.Model.Post;


@Repository
public interface PostRepository extends MongoRepository{
	Post findById(long id);
}
