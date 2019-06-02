package com.quebic.auth.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class SellerProfile {

	private String storeId;
	
	//temp fields
	private List<String> businessClariifications = new ArrayList<>();
	private List<String> deals = new ArrayList<>();
	
	private String legalBusinessName;
	private String businessAddress;
	private String physicalAddress;
	private String city;
	private String state;
	private String zipCode;
	private String businessLocatedCountry;
	private String businessPhone;
	private String businessWebsite;

	private String contactFirstName;
	private String contactLastName;
	private String contactBusinessAddress;
	private String contactPhysicalAddress;
	private String contactCity;
	private String contactState;
	private String contactZipCode;
	private String contactPhone;
	private String contactEmail;
}
