package com.lcwd.user.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.user.service.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	//get
	
	
	
	//Post
		@PostMapping("/rating/saveRating")
		Rating createRating(Rating values);
	//yaha pe hum log Rating createRating(Map<String,Object> values)
	//aise diye gaye method jaisa bhi kar sakte the means taking the Rating class variable name as a String and saving the value inside object and passing that whole data to a Rating microService
		//but yaha pe ye sab automatic hoga yani ki maapping betwwen real microservice and this service will be done automatically
		//so don't use Map just use (Rating values);
	//Put
		
		@PutMapping("/rating/{ratingId}")
		Rating updateRating(@PathVariable String ratingId,Rating rating);
		
		@DeleteMapping("/rating/{ratingId}")
		void deleteRating(@PathVariable String ratingId);
}
