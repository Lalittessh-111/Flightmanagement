package com.JavaElite.Flightmanagement.dao;

import java.util.List;

import com.JavaElite.Flightmanagement.bean.Flight;

public interface FlightDao {
	public void save(Flight flight);
	public static List<Flight> findAllFlights() {
		return null;
	}
}


