package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.FlightMaster;

public interface IFlightMasterRepository extends JpaRepository<FlightMaster, Integer> {

}
