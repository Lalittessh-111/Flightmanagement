package com.JavaElite.Flightmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaElite.Flightmanagement.bean.Flight;
import com.JavaElite.Flightmanagement.bean.Route;
import com.JavaElite.Flightmanagement.dao.RouteDao;

@Service
public class FlightService {

@Autowired
private RouteDao routeDao;

	public Flight createReturnFlight (Flight flight, String dtime, String atime) {
		Long newId = flight.getFlightNumber()+1;
		Route route = routeDao.findRouteById(flight.getRouteId());
		String sourceCode = route.getDestinationAirportCode();
		String destinationCode = route.getSourceAirportCode();
		Route newRouteId = routeDao.findRouteBySourceAndDestionation (sourceCode, destinationCode);
		return new Flight ();
	}
}