package com.lcwd.rating.service;

import java.util.List;

import com.lcwd.rating.entities.Rating;

public interface RatingService {

	Rating create(Rating rating);
	
	Rating getByRatingId(String ratingId);
	
	List<Rating> getRatingByUserId(String ratingId);
	
	Rating getRatingByHotelId(String hotelId);
	
	List<Rating> getALl();
	
}
