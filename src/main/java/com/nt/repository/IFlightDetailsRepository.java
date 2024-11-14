package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.FlightDetails;

public interface IFlightDetailsRepository extends JpaRepository<FlightDetails, Integer>{

}
