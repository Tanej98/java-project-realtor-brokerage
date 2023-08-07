package com.cestar.controller;

import com.cestar.model.Property;

import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
* <h1>Controller class</h1>
* <p>
* The controller program implements database operations like insert, get, update, delete .
* </p>
* @author Tanej
* @author Sanjay
* @author Tharun
*/

public class controller {
	Scanner sc = new Scanner(System.in);
	recordDao dealDao = new recordDao();
	
	/**
	 * insertController program insert the data in the database. It takes input data from the user.
	 */
	public void insertController() {
		// taking user inputs
		System.out.println("Insert record:");
		System.out.println("Enter the ID of the property: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the name of the agent: ");
		String agentName = sc.nextLine();
		System.out.println("Enter the asking price of the property: ");
		Double askingPrice = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the region of the property: ");
		String region = sc.nextLine();
		System.out.println("Enter the type of the property: ");
		String type = sc.nextLine();
		System.out.println("Enter the closing date for the property(dd-mm-yyyy): ");
		String dateStr = sc.nextLine();
		Date closingDate = null;

		try {
			closingDate = new SimpleDateFormat("dd-mm-yyyy").parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Property deal_record = new Property(id, agentName, askingPrice, region, type, closingDate);
		// inserting the data
		dealDao.insertRecord(deal_record);
	}
	
	/**
	 * displayController takes input from user to fetch single record or all the records
	 */
	public void displayController() {
		System.out.println("Display records:");
		System.out.println("Enter an id to see the record or leave empty to see all records:");
		String id = sc.nextLine();
		if(id.isEmpty()) {
			dealDao.displayRecords();
		}else {
			int property_id = Integer.parseInt(id);
			dealDao.getRecordById(property_id);
		}
	}
	
	/**
	 * updateController takes the values from user which need to be updated
	 */
	public void updateController() {
		System.out.println("Update record");
		System.out.println("Enter the id of the property: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the name of the agent: ");
		String agentName = sc.nextLine();
		if(agentName.isEmpty()) {
			agentName = null;
		}
		System.out.println("Enter the asking price of the property or -1 to not update the value: ");
		Double askingPrice = sc.nextDouble();
		if(askingPrice == -1) {
			askingPrice = null;
		}
		sc.nextLine();
		System.out.println("Enter the region of the property: ");
		String region = sc.nextLine();
		if(region.isEmpty()) {
			region = null;
		}
		System.out.println("Enter the type of the property: ");
		String type = sc.nextLine();
		if(type.isEmpty()) {
			type = null;
		}
		System.out.println("Enter the closing date for the property(dd-mm-yyyy): ");
		String dateStr = sc.nextLine();
		
		Date closingDate = null;
		if(dateStr.isEmpty()) {
			dateStr = null;
		}else {
			try {
				closingDate = new SimpleDateFormat("dd-mm-yyyy").parse(dateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// updating the record
		
		Property deal_record = new Property(id, agentName, askingPrice, region, type, closingDate);
		dealDao.updateRecordById(id, deal_record);
	}
	
	/**
	 * deleteController takes id from the user and it deletes the record from the database
	 */
	public void deleteController() {
		System.out.println("Delete record::");
		System.out.println("Enter the id of the property: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		dealDao.deleteRecordById(id);
	}
}
