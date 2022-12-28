package com.lcwd.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.external.HotelService;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;

import lombok.RequiredArgsConstructor;


@Service

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;  //now we are going to use feign client on the place of restTemplate
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		//for creating unique userId in the form of string
		
		String randomUserId= UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		
		//implementing rating service call for all user
		
		List<User> users = userRepo.findAll();
		List<User> getall= new ArrayList<>();
		for(int i=0;i<users.size();i++) {
			User user= users.get(i);
			ArrayList<Rating> ratingsofUser = restTemplate.getForObject("http://localhost:8080/rating/getByUserId/"+user.getUserId(), ArrayList.class);
			user.setRatings(ratingsofUser);
			getall.add(user);
		}
		
		return getall;
	}

	@Override
	public User getUser(String userID) {
		// TODO Auto-generated method stub
		//getting the data of the user from the userRepository
		User user= userRepo.findById(userID).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server !! :"+userID));
		//here we have to fetch the data of above user from the Rating_Service
		//localhost:8080/rating/getByUserId/umeshid
		
		
		//inside diamond operator we used the class which is available in userMicroServices
		//we use getforobject because we are getting many objects
		Rating[] ratingsofUser = restTemplate.getForObject("http://RATING-SERVICE/rating/getByUserId/"+user.getUserId(), Rating[].class);
		
		List<Rating> ratings = Arrays.stream(ratingsofUser).toList();
		
		//now here we are trying ti communicate with other microservice like user->Rating->Hotel
		//hame ek - ek rating nikalni hai so hum map use karenge
		List<Rating> ratingList= ratings.stream().map(rating ->{
			
			//now we are calling a api of HotelService to get the hotels
			
			//localhost:8082/hotels/HotelById/ad7af599-884a-4b04-9312-596b1c100988
			//here we use getFor Entity so only one data is returned
			//hum log niche ki line use karke hotel ko nikalte the aur usko apne duplicate hotel me store karte the 
	//		ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/HotelById/"+rating.getHotelId(),Hotel.class);
			//now we are using here feign client so no need of up-down line
	//		Hotel hotel= forEntity.getBody();
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId()); //here we used our fiegn client
			
			//and set the hotel to rating 
			rating.setHotel(hotel);
			//and then return the rating
			
			return rating;
			
		}).collect(Collectors.toList());
		
		//we can use logger to print this 
		user.setRatings(ratingList);
		
		//System.out.println(ratingsofUser);
		
		return user;
	}

}
