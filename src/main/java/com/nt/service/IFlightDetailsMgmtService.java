package com.nt.service;

import java.util.List;

import com.nt.exception.FlightMasterNotFoundException;
import com.nt.model.FlightDetails;

public interface IFlightDetailsMgmtService {
	public String registerFlightDetails(FlightDetails flightDetails);
	public List<FlightDetails> fetchAllFlightDeatils();
	public FlightDetails fetchFlightDetailsById(Integer routeId) throws FlightMasterNotFoundException;
	public String UpdateFlightDetailsChanges(FlightDetails flightDetails) throws FlightMasterNotFoundException;
	public String removeFlightDetailsById(Integer id) throws FlightMasterNotFoundException;
}
