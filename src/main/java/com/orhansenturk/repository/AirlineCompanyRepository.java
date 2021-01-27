package com.orhansenturk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orhansenturk.model.AirlineCompany;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Long> {

	AirlineCompany findByName(String name);

}
