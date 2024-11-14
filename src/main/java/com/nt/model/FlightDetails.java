package com.nt.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flight_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer routeId;
	
	@ManyToOne
	@JoinColumn(name = "flight_id",nullable = false)
	private FlightMaster flightMaster;
	
	@Column(length = 20, nullable = false)
	private String routeSource;
	
	@Column(length = 20, nullable = false)
	private String routeDestination;
	
	@Column(length = 5, nullable = false)
	private String timing;
	
	@Column(nullable = false, precision = 10,scale = 2)
	private BigDecimal amount;
	
	private LocalDate createdOn;
	private LocalDate modifiedOn;
	
	@Column(length = 20)
	private String createdBy;
	
	@Column(length = 20)
	private String modifiedBy;	
}
