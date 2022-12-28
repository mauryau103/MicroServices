package com.lcwd.hotel.controllers;

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

import com.lcwd.hotel.entites.Hotel;
import com.lcwd.hotel.services.HotelService;


@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	//By using response entity we handle status of our http request OR our Response.
	
	@PostMapping("/saveHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
		
	}
	
	//if we pass same parameter name,.. name as a getMapping have ....there is not need to use argument on path variable
	@GetMapping("/HotelById/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		Hotel hotel = hotelService.getById(hotelId);
		
		// this ok is a static method which returns the HTTP.OK .
		return ResponseEntity.ok(hotel);
		
	}
	
	@GetMapping("/getAllHotel")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		
		List<Hotel> allHotels = hotelService.getAll();
		
		return ResponseEntity.ok(allHotels);
	}
}
 