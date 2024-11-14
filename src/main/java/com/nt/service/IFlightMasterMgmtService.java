package com.nt.service;

import java.util.List;

import com.nt.exception.FlightMasterNotFoundException;
import com.nt.model.FlightMaster;

public interface IFlightMasterMgmtService {
	public String registerFlight(FlightMaster flightMaster);
	public List<FlightMaster> fetchAllFlights();
	public FlightMaster fetchFlightbyId(Integer flightId) throws FlightMasterNotFoundException;
	public String UpdateFlightDetails(FlightMaster flightMaster) throws FlightMasterNotFoundException;
	public String removeFlightById(Integer id) throws FlightMasterNotFoundException;
}
