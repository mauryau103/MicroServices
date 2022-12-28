package com.lcwd.user.service.entities;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rating {
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	
	@Transient
	private Hotel hotel;
	

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
