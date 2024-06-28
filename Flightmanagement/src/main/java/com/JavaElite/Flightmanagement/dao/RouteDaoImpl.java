package com.JavaElite.Flightmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.JavaElite.Flightmanagement.bean.Route;



@Service
@Repository
public class RouteDaoImpl implements RouteDao {
	@Autowired
	private RouteRepository repository;

	@Override
	public void save(Route route) {
		repository.save(route);
		
	}
	@Override
	public List<Route> findAllRoutes(){
		return repository.findAll();
	}
	@Override
	public Route findRouteById(Long id){
		return repository.findById(id).get();
	}
	public Long findRouteBySourceAndDestination(String source, String destination){
		return repository.findRouteBySourceAndDestination(source, destination);
	}
	@Override
	public Route findRouteBySourceAndDestionation(String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long generateRouteId() {
		Long Val=repository.findLastRouteId();
		if(Val==null)
			Val=101L;
		else
			Val=Val+1;
		
		return null;
	}
	@Override
	public List<Long> findAllRoutesId() {
		// TODO Auto-generated method stub
		return null;
	}
}
