package com.lcwd.rating.service.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.Exception.ResourceNotFoundException;
import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repositories.RatingRepository;
import com.lcwd.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepository ratingRepo;
	
	
	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		
		String radomUUID = UUID.randomUUID().toString();
		rating.setRatingId(radomUUID);
		return ratingRepo.save(rating);
	}

	@Override
	public Rating getByRatingId(String RatingId) {
		// TODO Auto-generated method stub
		return ratingRepo.findById(RatingId).orElseThrow(()->new ResourceNotFoundException("Rating with the given id is not found: "+RatingId));
	}

	@Override
	public List<Rating> getALl() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public Rating getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(hotelId);
	}

}
