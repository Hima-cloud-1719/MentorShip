package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.FlightMaster;
import com.nt.service.IFlightMasterMgmtService;

@RestController
@RequestMapping("/flightMaster")
public class FlightMAsterOperationContril {
	@Autowired
	private IFlightMasterMgmtService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollFlight(@RequestBody FlightMaster flightMaster){
		try {
			String resultMsg=service.registerFlight(flightMaster);
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("problem in Flight enrollment",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<?> displayFlights(){
		try {
			List<FlightMaster> list=service.fetchAllFlights();
			return new ResponseEntity<List<FlightMaster>>(list,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Flights",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayFlightById(@PathVariable("id")Integer id){
		try {
			FlightMaster flightmaster=service.fetchFlightbyId(id);
			return new ResponseEntity<FlightMaster>(flightmaster,HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/modify")
	public ResponseEntity<String> modifyFlightMaster(@RequestBody FlightMaster flightMaster){
		try {
			String msg=service.UpdateFlightDetails(flightMaster);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFlightById(@PathVariable("id") Integer id){
		try {
			String msgresult=service.removeFlightById(id);
			return new ResponseEntity<String>(msgresult,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
