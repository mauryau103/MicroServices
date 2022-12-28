package com.lcwd.hotel.services;

import java.util.List;

import com.lcwd.hotel.entites.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel getById(String id);
	
}
