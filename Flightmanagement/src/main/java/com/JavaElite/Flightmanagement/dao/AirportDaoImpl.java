package com.JavaElite.Flightmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.JavaElite.Flightmanagement.bean.Airport;

@Repository
@Service
public class AirportDaoImpl implements AirportDao {
	@Autowired
	private AirportRepository repository;

	@Override
	public void addAirport(Airport airport) {
		repository.save(airport);
		// TODO Auto-generated method stub

	}
	@Override
	public List<Airport> findAllAirports() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Airport findAirportById(String id) {
		return repository.findById(id).get();
	}
	
	@Override
	public List<String> findAllAirportCodes(){
		return repository.FindAllAirportCodes();
	}
	@Override
	public String findAirportCodeByLocation(Object getSourceAirportCode) {
		// TODO Auto-generated method stub
		return null;
	}


}