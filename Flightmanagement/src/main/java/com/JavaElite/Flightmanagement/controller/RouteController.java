package com.JavaElite.Flightmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.JavaElite.Flightmanagement.bean.Airport;
import com.JavaElite.Flightmanagement.bean.Flight;
import com.JavaElite.Flightmanagement.bean.Route;
import com.JavaElite.Flightmanagement.dao.AirportDao;
import com.JavaElite.Flightmanagement.dao.FlightDao;
import com.JavaElite.Flightmanagement.dao.RouteDao;
import com.JavaElite.Flightmanagement.exception.RouteException;
import com.JavaElite.Flightmanagement.service.FlightService;
import com.JavaElite.Flightmanagement.service.RouteService;

@ControllerAdvice
@RestController
public class RouteController {
 @Autowired
 private RouteDao routeDao;
 @Autowired
 private RouteService routeService;
 @Autowired
 private AirportDao airportDao;
 @Autowired
 private FlightDao flightDao;
 @Autowired
 private FlightService flightService;
 
 	@GetMapping("/Route")
 	public ModelAndView showRouteEntryPage() {
 		Long newRouteId=routeDao.generateRouteId();
 		Route route=new Route();
 		route.setRouteId(newRouteId);
 		ModelAndView mv=new ModelAndView("RouteEntryPage");
 		mv.addObject("RouteRecord",route);
 		return mv;
 	}
 	 @PostMapping("/Route")
 	public ModelAndView saveRoutes(@ModelAttribute("RouteRecord") Route route1 ,Double Fair){
 		 String source=route1.getSourceAirportCode().toUpperCase();
 		 String destination=route1.getDestinationAirportCode().toUpperCase();
 		 route1.setSourceAirportCode(source);
 		 route1.setDestinationAirportCode(destination);
 		 String sourceCode=airportDao.findAirportCodeByLocation(route1.getSourceAirportCode());
 		 String destinationCode=airportDao.findAirportCodeByLocation(route1.getDestinationAirportCode());
 		 route1.setSourceAirportCode(sourceCode);
 		 route1.setDestinationAirportCode(destinationCode);
 		 Route route2=routeService.createReturnRoute(route1,Fair);
 		 routeDao.save(route1);
 		 routeDao.save(route2);
 		 return new ModelAndView("/index");
 	 }
 	@GetMapping("/Routes")
 	public ModelAndView showRouteRecordPage() {
 		List<Route> routeList=routeDao.findAllRoutes();
 		ModelAndView mv=new ModelAndView("RouteRecordPage");
 		mv.addObject("RouteRecord",routeList);
 		return mv;
}
 	 @GetMapping("/flight")
     public ModelAndView showFlightEntryPage() {
 		 List<Long> routeList=routeDao.findAllRoutesId();
 		 Flight flight=new Flight();
         ModelAndView mv = new ModelAndView("FlightEntryPage");
         mv.addObject("FlightRecord", flight);
         mv.addObject("routeList",routeList);
         return mv;
     }
 	    @PostMapping("/flight")
 	   public ModelAndView saveFlights(@ModelAttribute("FlightRecord")Flight flight1, @RequestParam("dtime") String dtime,@RequestParam("atime") String atime) {
 	    Flight flight2=(flightService).createReturnFlight(flight1,dtime,atime);
 	    flightDao.save(flight1);
 	    flightDao.save(flight2);
 	    return new ModelAndView("index");
 	    }

     @GetMapping("/flights")
     public ModelAndView showFlightRecordPage() {
     	List<Flight> flightList=FlightDao.findAllFlights();
         ModelAndView mv = new ModelAndView("FlightRecordPage");
         mv.addObject("flightList", flightList);
         return mv;
     }

     @GetMapping("/flights-search")
     public ModelAndView showFlightSelectPage() {
     	List<String> airportList=airportDao.findAllAirportLocations();
         ModelAndView mv = new ModelAndView("FlightSelectPage");
         mv.addObject("airportList", airportList);
         return mv;
     }
     
     @PostMapping("/flights-search")
     public ModelAndView showRouteFlightPage(@RequestParam("from_city") String fromCity, @RequestParam("to_city") String toCity, Object flightList) {
    	 String fromAirport=airportDao.findAirportCodeByLocation(fromCity);
    	 String toAirport=airportDao.findAirportCodeByLocation(toCity);
    	 if(fromAirport.equalsIgnoreCase(toAirport))
    		 throw new RouteException();
    	 Route route=routeDao.findRouteBySourceAndDestionation(fromAirport, toAirport);
    	 ModelAndView mv=new ModelAndView("routeFlightShowPage");
    	 mv.addObject("flightList",flightList);
    	 mv.addObject("fromAirport", fromCity);
    	 mv.addObject(toAirport, toCity);
    	 mv.addObject("fair", route.getFair());
    	 return mv;
     }
     
     @ExceptionHandler(value = RouteException.class)
      public ModelAndView handlingRouteException(RouteException exception) {
    	 String message="From-City & To-City cannot be the same ......";
    	 ModelAndView mv=new ModelAndView("routeErrorPage");
    	 mv.addObject("errormessage",message);
    	 return mv;
     }

}
