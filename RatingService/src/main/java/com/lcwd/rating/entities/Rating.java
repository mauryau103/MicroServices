package com.lcwd.rating.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import lombok.Setter;
@Data
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="user_ratings")
public class Rating {
	
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
