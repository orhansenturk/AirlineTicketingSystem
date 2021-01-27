package com.orhansenturk.service.intf;

import java.util.List;

import com.orhansenturk.model.AirlineCompany;

public interface IAirlineCompanyService {
	AirlineCompany createAirlineCompany(AirlineCompany airlineCompany);

	List<AirlineCompany> getAllAirlineCompanies();

	AirlineCompany getAirlineCompanyById(long id);

	AirlineCompany getAirlineCompanyByName(String name);
}
