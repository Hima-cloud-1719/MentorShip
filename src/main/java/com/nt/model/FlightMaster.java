package com.nt.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "flight_master")
public class FlightMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer flightId;
	
	@Column(length = 20)
	@NonNull
	private String flightNumber;
	@Column(length = 20)
	@NonNull
	private String flightName;
	
	
}
