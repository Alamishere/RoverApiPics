package com.marsrover.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.marsrover.response.MarsRoverApiResponse;

@Service
public class MarsRoverApiService {
	private static  final String API_KEY="N9qEdPu2snecBd7tG9gJc4IDsZNYtLNQ5ihlZgKJ";
	public MarsRoverApiResponse getRoverData(String roverType) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MarsRoverApiResponse> response = restTemplate.getForEntity(
				"https://api.nasa.gov/mars-photos/api/v1/rovers/"+roverType+"/photos?sol=2&api_key="+ API_KEY,
				MarsRoverApiResponse.class);
		
		return response.getBody();
	}

}
