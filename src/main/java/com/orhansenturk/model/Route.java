package com.orhansenturk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "routes")
public class Route {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private long departureAirportId;

	@Column(nullable = false)
	private long destinationAirportId;

	@Column(nullable = false)
	private long airlineCompanyId;

	@Column
	@CreationTimestamp
	private Date createDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDepartureAirportId() {
		return departureAirportId;
	}

	public void setDepartureAirportId(long departureAirportId) {
		this.departureAirportId = departureAirportId;
	}

	public long getDestinationAirportId() {
		return destinationAirportId;
	}

	public void setDestinationAirportId(long destinationAirportId) {
		this.destinationAirportId = destinationAirportId;
	}

	public long getAirlineCompanyId() {
		return airlineCompanyId;
	}

	public void setAirlineCompanyId(long airlineCompanyId) {
		this.airlineCompanyId = airlineCompanyId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
