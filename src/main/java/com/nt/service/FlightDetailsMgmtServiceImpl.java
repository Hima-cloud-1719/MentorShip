package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.FlightMasterNotFoundException;
import com.nt.model.FlightDetails;
import com.nt.repository.IFlightDetailsRepository;

@Service("flightDetailsService")
public class FlightDetailsMgmtServiceImpl implements IFlightDetailsMgmtService {

	@Autowired
	private IFlightDetailsRepository detailsrepo;
	
	@Override
	public List<FlightDetails> fetchAllFlightDeatils() {
		List<FlightDetails> list1=detailsrepo.findAll();
		list1.sort((d1,d2)->d1.getRouteId().compareTo(d2.getRouteId()));
		return list1;
	}

	@Override
	public FlightDetails fetchFlightDetailsById(Integer routeId) throws FlightMasterNotFoundException {
		return detailsrepo.findById(routeId).orElseThrow(()->new FlightMasterNotFoundException(routeId+"flight not found"));
	}

	@Override
	public String registerFlightDetails(FlightDetails flightDetails) {
		int idval=detailsrepo.save(flightDetails).getRouteId();
		return "FilghtDetails is registered having the id value::"+idval;
	}

	@Override
	public String UpdateFlightDetailsChanges(FlightDetails flightDetails) throws FlightMasterNotFoundException {
		Optional<FlightDetails> option=detailsrepo.findById(flightDetails.getRouteId());
		if(option.isPresent()) {
			detailsrepo.save(flightDetails);
			return flightDetails.getRouteId()+"Changes are updated";
		}
		else {
			throw new FlightMasterNotFoundException(flightDetails.getRouteId()+"Flight not found");
		}
	}

	@Override
	public String removeFlightDetailsById(Integer id) throws FlightMasterNotFoundException {
		Optional<FlightDetails> opt=detailsrepo.findById(id);
		if(opt.isPresent()) {
			detailsrepo.deleteById(id);
			return id+"RouteID Details Delted";
		}
		else {
			throw new FlightMasterNotFoundException(id+" Details not found for deletion");
		}
	}

}





