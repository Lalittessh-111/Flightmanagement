package com.JavaElite.Flightmanagement.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaElite.Flightmanagement.bean.Flight;
import com.JavaElite.Flightmanagement.bean.Passenger;
import com.JavaElite.Flightmanagement.dao.FlightDao;

@Service

public class TicketService {
	@Autowired
	private FlightDao flightDao;
	
	    private int ageCalculation(String dob) {
	    	LocalDate today=LocalDate.now();
	    	String dataArr[]=dob.split("-");
	    	LocalDate birthDay=LocalDate.of(Integer.parseInt(dataArr[0]),Integer.parseInt(dataArr[1]),Integer.parseInt(dataArr[2]));
	    	Period period=Period.between(birthDay, today);
	    	int age=period.getYears();
	    	return age;
	    }
	    
	    
	    public Double discountFairCalculation(Passenger passenger) {
	       int age=ageCalculation(passenger.getPassengerDOB());
	       double finalFair=0.0;
	       if(age<=14) {
	    	   finalFair=passenger.getFare()/2;
	        } else if (age >= 65) {
	            finalFair=passenger.getFare()-passenger.getFare()*0.30;
	        } else {
	           finalFair=passenger.getFare();
	        }
	       return finalFair;
	    }
	    
	public boolean capacityCalculation(int numberOfSeatBooking,Long flightNumber) {
		Flight flight=flightDao.findFlightById(flightNumber);
		int bookedSeat=flight.getSeatBooked()+ numberOfSeatBooking;
		int balance=flight.getSeatCapacity()-bookedSeat;
		if(balance<0)
			return false;
		else {
			flight.setSeatBooked(bookedSeat);
			flightDao.save(flight);
			return true;
		}
	}
	    	public Double totalBillCalculation(List<Passenger> passengerList) {
	    		double totalValue=0.0;
	    		for(Passenger passenger:passengerList) {
	    			totalValue=totalValue+passenger.getFare();
	    		}
	    		return totalValue;
	    	}
	
}