package com.lcwd.user.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.entities.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
	
	//now here we can call the service which is available in controller of Hotel 
	//Also we can use spring MVC annotation in this service interface.
	
	//the uri given in mapping should be same as given inside that microservice
	//Now we can inject feign client into our userServiceImpl
	//Also we are going to replace restTemplate with FeignClient
	
	//this is a interface ka method so iski implementation springboot ke through automatic provide ho jayegi ---> jo ki hotel Service ke andar pade hue  controller se le raha hai apna implementation
	
	@GetMapping("/hotels/HotelById/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);

}
