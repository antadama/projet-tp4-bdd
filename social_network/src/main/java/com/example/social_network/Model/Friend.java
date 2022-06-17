package com.example.social_network.Model;

import org.springframework.data.annotation.Id;

public class Friend {
	
	@Id
	private long  user1_id;
	@Id
	private long  user2_id;
	
	/**
	 * @return the user1_id
	 */
	public long getUser1_id() {
		return user1_id;
	}
	/**
	 * @param user1_id the user1_id to set
	 */
	public void setUser1_id(long user1_id) {
		this.user1_id = user1_id;
	}
	/**
	 * @return the user2_id
	 */
	public long getUser2_id() {
		return user2_id;
	}
	/**
	 * @param user2_id the user2_id to set
	 */
	public void setUser2_id(long user2_id) {
		this.user2_id = user2_id;
	}
	
	
}
