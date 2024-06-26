package com.JavaElite.Flightmanagement.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport {
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airport(String airportCode, String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportLocation = airportLocation;
	}
	@Id
	private String airportCode;
	private String airportLocation;
	
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
}