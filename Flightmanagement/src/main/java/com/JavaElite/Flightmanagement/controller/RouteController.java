package com.JavaElite.Flightmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.JavaElite.Flightmanagement.service.FlightService;
import com.JavaElite.Flightmanagement.service.RouteService;


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
 	public ModelAndView saveRoutes(@ModelAttribute("RouteRecord") Route route1) {
 		 String source=route1.getSourceAirportCode().toUpperCase();
 		 String destination=route1.getDestinationAirportCode().toUpperCase();
 		 route1.setSourceAirportCode(source);
 		 route1.setDestinationAirportCode(destination);
 		 String sourceCode=airportDao.findAirportCodeByLocation(route1.getSourceAirportCode());
 		 String destinationCode=airportDao.findAirportCodeByLocation(route1.getDestinationAirportCode());
 		 route1.setSourceAirportCode(sourceCode);
 		 route1.setDestinationAirportCode(destinationCode);
 		 Route route2=routeService.createReturnRoute(route1);
 		 routeDao.save(route1);
 		 routeDao.save(route2);
 		 return new ModelAndView("/index");
 	 }
 	@GetMapping("/Routes")
 	public ModelAndView showRouteRecordPage() {
 		Long newRouteId=routeDao.generateRouteId();
 		Route route=new Route();
 		route.setRouteId(newRouteId);
 		ModelAndView mv=new ModelAndView("RouteRecordPage");
 		mv.addObject("RouteRecord",route);
 		return mv;
}
 	@PostMapping("/Routes")
    public ModelAndView saveRoutes(@ModelAttribute("RouteRecords") List<Route> routes) {
        for (Route route : routes) {
            String source = route.getSourceAirportCode().toUpperCase();
            String destination = route.getDestinationAirportCode().toUpperCase();
            route.setSourceAirportCode(source);
            route.setDestinationAirportCode(destination);
            String sourceCode = airportDao.findAirportCodeByLocation(route.getSourceAirportCode());
            String destinationCode = airportDao.findAirportCodeByLocation(route.getDestinationAirportCode());
            route.setSourceAirportCode(sourceCode);
            route.setDestinationAirportCode(destinationCode);
            Route returnRoute = routeService.createReturnRoute(route);
            routeDao.save(route);
            routeDao.save(returnRoute);
        }
        return new ModelAndView("/index");
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
         mv.addObject("Flight List", flightList);
         return mv;

     }
}
