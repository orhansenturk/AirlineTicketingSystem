package com.orhansenturk.service.intf;

import java.util.List;

import com.orhansenturk.model.Route;

public interface IRouteService {
	Route createRoute(Route route);

	List<Route> getAllRoutes();

	Route getRouteById(long id);

	Route getRouteByName(String name);
}
