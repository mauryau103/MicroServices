package com.lcwd.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@PostMapping("/saveRating")
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
		
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Rating>> getAllRating(){
		
		List<Rating> rating = ratingService.getALl();
		
		return ResponseEntity.ok(rating);
		
	}
	
	@GetMapping("/getByRatingId/{ratingId}")
	public ResponseEntity<Rating> getRatingByRatingId(@PathVariable String ratingId){
		return ResponseEntity.ok(ratingService.getByRatingId(ratingId));
	}
	
	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
		
	}
	
	@GetMapping("/getByHotelId/{hotelId}")
	public ResponseEntity<Rating> getRatingByHotelId(@PathVariable String hotelId){
		Rating rating = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(rating);
	}
	
}
