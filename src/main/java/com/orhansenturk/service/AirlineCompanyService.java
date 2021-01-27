package com.orhansenturk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhansenturk.exception.ResourceNotFoundException;
import com.orhansenturk.model.AirlineCompany;
import com.orhansenturk.repository.AirlineCompanyRepository;
import com.orhansenturk.service.intf.IAirlineCompanyService;

@Service
@org.springframework.transaction.annotation.Transactional
public class AirlineCompanyService implements IAirlineCompanyService {

	@Autowired
	AirlineCompanyRepository airlineCompanyRepository;

	@Override
	public AirlineCompany createAirlineCompany(AirlineCompany airlineCompany) {
		return airlineCompanyRepository.save(airlineCompany);
	}

	@Override
	public List<AirlineCompany> getAllAirlineCompanies() {
		return this.airlineCompanyRepository.findAll();
	}

	@Override
	public AirlineCompany getAirlineCompanyById(long airlineCompanyId) {
		Optional<AirlineCompany> airlineCompany = this.airlineCompanyRepository.findById(airlineCompanyId);

		if (airlineCompany.isPresent()) {
			return airlineCompany.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id:" + airlineCompanyId);
		}
	}

	@Override
	public AirlineCompany getAirlineCompanyByName(String name) {
		AirlineCompany airlineCompany = this.airlineCompanyRepository.findByName(name);

		if (airlineCompany != null) {
			return airlineCompany;
		} else {
			throw new ResourceNotFoundException("Record not found with name:" + name);
		}

	}

}
