package com.JavaElite.Flightmanagement.service;

import org.springframework.stereotype.Service;

import com.JavaElite.Flightmanagement.bean.Route;
@Service
public class RouteService {

	public Route createReturnRoute(Route route) {
		Long newId=route.getRouteId()+1;
		String sourceCode=route.getDestinationAirportCode();
		String destinationCode=route.getSourceAirportCode();
		return new Route(newId,sourceCode,destinationCode);
	}

}
