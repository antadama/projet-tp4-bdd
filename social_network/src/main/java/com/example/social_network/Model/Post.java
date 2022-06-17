package com.example.social_network.Model;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class Post {
	
	 @Id
	    
	    private long id;
	    private User user;
	    private String content;
	    

	    public Post() {
	    }

		public long getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		
}

