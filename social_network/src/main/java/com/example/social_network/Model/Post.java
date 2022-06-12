package com.example.social_network.Model;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class Post {
	
	 @Id
	    
	    private Integer id;
	    private User user;
	    private String content;
	    private Date createdDate;

	    public Post() {
	    }

		public Integer getId() {
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

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
	
}
