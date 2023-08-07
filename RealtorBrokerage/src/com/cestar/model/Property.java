package com.cestar.model;

import java.util.Date;

/**
 * Property class holds the attributes and getter and setter functions for the database schema
 * @author tanej
 * @author sanjay
 * @author tharun
 *
 */
public class Property {
	private int PropertyId;
	private String AgentName;
	private Double AskingPrice;
	private String Region;
	private String Type;
	private Date ClosingDate;
	
	public Property() {
		this.PropertyId = -1;
		this.AgentName = "";
		this.AskingPrice = 0.0;
		this.Region = "";
		this.Type = "";
		this.ClosingDate = new Date();
	}
	
	public Property(int propertyId, String agentName, Double askingPrice, String region, String type,
			Date closingDate) {
		this.PropertyId = propertyId;
		this.AgentName = agentName;
		this.AskingPrice = askingPrice;
		this.Region = region;
		this.Type = type;
		this.ClosingDate = closingDate;
	}

	public int getPropertyId() {
		return PropertyId;
	}

	public void setPropertyId(int propertyId) {
		PropertyId = propertyId;
	}

	public String getAgentName() {
		return AgentName;
	}

	public void setAgentName(String agentName) {
		AgentName = agentName;
	}

	public Double getAskingPrice() {
		return AskingPrice;
	}

	public void setAskingPrice(Double askingPrice) {
		AskingPrice = askingPrice;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Date getClosingDate() {
		return ClosingDate;
	}

	public void setClosingDate(Date closingDate) {
		ClosingDate = closingDate;
	}
	
	
}
