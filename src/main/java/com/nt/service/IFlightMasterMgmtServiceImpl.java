package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.FlightMasterNotFoundException;
import com.nt.model.FlightMaster;
import com.nt.repository.IFlightMasterRepository;

@Service("flightService")
public class IFlightMasterMgmtServiceImpl implements IFlightMasterMgmtService {
	@Autowired
	private  IFlightMasterRepository flightmasterRepo;
	
	@Override
	public String registerFlight(FlightMaster flightMaster) {
		int idval=flightmasterRepo.save(flightMaster).getFlightId();
		return "Filght is register having the id value::"+idval;
	}

	@Override
	public List<FlightMaster> fetchAllFlights() {
		List<FlightMaster> list=flightmasterRepo.findAll();
		list.sort((f1,f2)->f1.getFlightId().compareTo(f2.getFlightId()));
		return list;
	}

	@Override
	public FlightMaster fetchFlightbyId(Integer flightId) throws FlightMasterNotFoundException {
		return flightmasterRepo.findById(flightId).orElseThrow(()->new FlightMasterNotFoundException(flightId+"flight not found"));
	}

	@Override
	public String UpdateFlightDetails(FlightMaster flightMaster) throws FlightMasterNotFoundException {
		Optional<FlightMaster> optional=flightmasterRepo.findById(flightMaster.getFlightId());
		if(optional.isPresent()) {
			flightmasterRepo.save(flightMaster);//save(-) to perform either save obj or updatae obj operation
			return flightMaster.getFlightId()+"Flight is updated";
		}
		else {
			throw new FlightMasterNotFoundException(flightMaster.getFlightId()+"Flight not found");
		}
	}

	@Override
	public String removeFlightById(Integer id) throws FlightMasterNotFoundException {
		 //get the flight by id
		Optional<FlightMaster> opt=flightmasterRepo.findById(id);
		if(opt.isPresent()) {
			//use repo
			flightmasterRepo.deleteById(id);
			return id+"FligtId Flight found and deleted";
		}
		else {
			throw new FlightMasterNotFoundException(id+"Flight not found for deletion");
		}
	}
	
	

}
