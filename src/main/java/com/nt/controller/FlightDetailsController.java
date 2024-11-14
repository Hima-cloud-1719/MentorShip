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

import com.nt.model.FlightDetails;
import com.nt.service.IFlightDetailsMgmtService;

@RestController
@RequestMapping("/flightDetails")
public class FlightDetailsController {
	@Autowired
	private IFlightDetailsMgmtService service;
	
	@GetMapping("/findAll")
	public ResponseEntity<?> getAllFlightsDetails(){
		try {
			List<FlightDetails> list=service.fetchAllFlightDeatils();
			return new ResponseEntity<List<FlightDetails>>(list,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Flights",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getFlightDetailsById(@PathVariable("id") Integer id){
		try {
			FlightDetails flightDetails=service.fetchFlightDetailsById(id);
			return new ResponseEntity<FlightDetails>(flightDetails,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/register")
	public ResponseEntity<String> registerFlightDetails(@RequestBody FlightDetails flightDetails){
		try {
			String resultMsg=service.registerFlightDetails(flightDetails);
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("problem in registering FlightDetails",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/modify")
	public ResponseEntity<String> updateFlightDetailsChanges(@RequestBody FlightDetails flightDetails){
		try {
			String msg=service.UpdateFlightDetailsChanges(flightDetails);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> DeleteDetailsById(@PathVariable ("id") Integer id){
		try {
			String msg=service.removeFlightDetailsById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}










