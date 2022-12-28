package com.lcwd.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entites.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.services.HotelService;

//by this we have created a bean so spring will handle the object of this
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;
	
	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomHotelId = UUID.randomUUID().toString();
		hotel.setId(randomHotelId);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getById(String id) {
		// TODO Auto-generated method stub
		
		//here we throw an exception which is customized exception.
		//we can handle that exception on controller level\
		//also we can handle that exception by global exception handling .
		return hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel given Id not Found"));
	}

}
