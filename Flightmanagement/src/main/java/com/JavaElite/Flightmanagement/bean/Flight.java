package com.JavaElite.Flightmanagement.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	private Long flightNumber;
	private String airline;
	private Long routeId;
	private Integer seatCapacity;
	private String departure;
	private String arrival;
	public Long getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public Integer getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(Integer seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
}
	