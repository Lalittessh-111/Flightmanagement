package com.JavaElite.Flightmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.JavaElite.Flightmanagement.bean.Flight;
import com.JavaElite.Flightmanagement.bean.Passenger;
import com.JavaElite.Flightmanagement.bean.Route;
import com.JavaElite.Flightmanagement.bean.Ticket;
import com.JavaElite.Flightmanagement.bean.TicketPassengerEmbed;
import com.JavaElite.Flightmanagement.dao.FlightDao;
import com.JavaElite.Flightmanagement.dao.PassengerDao;
import com.JavaElite.Flightmanagement.dao.RouteDao;
import com.JavaElite.Flightmanagement.dao.TicketDao;
import com.JavaElite.Flightmanagement.exception.SeatNotFoundException;
import com.JavaElite.Flightmanagement.service.TicketService;

@ControllerAdvice
@RestController
public class TicketController {
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private TicketService ticketService;
	@Autowired
	private PassengerDao passengerDao;
	
	@GetMapping("/ticket/{id}")
	public ModelAndView showTicketBookingPage(@PathVariable Long id) {
		Flight flight=flightDao.findFlightById(id);
		Route route=routeDao.findRouteById(flight.getRouteId());
		Long newTicketId=ticketDao.findLastTicketNumber();
		Ticket ticket=new Ticket();
		ticket.setTicketNumber(newTicketId);
		ticket.setFlightNumber(flight.getFlightNumber());
		ticket.setCarrierName(flight.getCarrierName());
		ticket.setRouteId(flight.getRouteId());
		ModelAndView mv=new ModelAndView("ticketBookingPage");
		mv.addObject("ticketRecord",ticket);
		mv.addObject("flight",flight);
		mv.addObject("route",route);
		return mv;
		}
	
	@PostMapping("/ticket")
	public ModelAndView openshowTicketPage(@ModelAttribute("ticketRecord")Ticket ticket,HttpServletRequest request) {
		List<Passenger> passengerList=new ArrayList<>();
		String fromCity=request.getParameter("fromLocation");
		String toCity=request.getParameter("toLocation");
		Double Fair=Double.parseDouble(request.getParameter("fair"));
		String pname="";
		String dob="";
		for(int i=1;i<=6;i++){
		pname=request.getParameter("name"+i);
		if(!pname.equals("--")){
		dob=request.getParameter("dob"+i);
		TicketPassengerEmbed embed=new TicketPassengerEmbed(ticket.getTicketNumber(),i);
		Passenger passenger=new Passenger(embed,pname,dob,Fair);
		Double pfair=ticketService.discountFairCalculation(passenger);
		passenger.setFare(pfair);
		passengerList.add(passenger);
		}
		else {
			break;
		}
		}//end of loop
		int size=passengerList.size();
		if(ticketService.capacityCalculation(size,ticket.getFlightNumber())) {
			ticketDao.save(ticket);
			for(Passenger passenger:passengerList) {
				passengerDao.save(passenger);
				}
		}
		
		else {
			throw new SeatNotFoundException();
		}
		
		Double totalAmount=ticketService.totalBillCalculation(passengerList);
		ticket.setTotalAmount(totalAmount);
		ticketDao.save(ticket);
		ModelAndView mv=new ModelAndView("showTicketPage");
		mv.addObject("ticket",ticket);
		mv.addObject("fromCity",fromCity);
		mv.addObject("toCity",toCity);
		mv.addObject("passengerList",passengerList);
		mv.addObject("fare",Fair);
		return mv;
	

}
}