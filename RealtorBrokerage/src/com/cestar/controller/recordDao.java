package com.cestar.controller;

import com.cestar.model.Property;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * recordDao program connects to database and handle the database operations
 * @author tanej
 * @author sanjay
 * @author tharun
 *
 */
public class recordDao {
	private java.sql.Date convertDate(java.util.Date d){
		return new Date(d.getTime());
	}
	/**
	 * getConnection connects to the database and returns the connection object
	 * @return java.sql object
	 */
	public Connection getConnection(){
        Connection con = null;
        String user = "root";
        String pwd = "";
        String url="jdbc:mysql://localhost:3306/Brokerage";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            con = DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }
	/**
	 * insertRecord takes record details and insert into the database
	 * @param deal - Property object which need to be inserted
	 * @return status - int
	 */
	public int insertRecord(Property deal){
        int status = 0;
        Connection con = getConnection();
        String sql = "Insert into Properties (PropertyId,AgentName,AskingPrice,Region,Type,ClosingDate) values(?,?,?,?,?,?) ";
        try {
            PreparedStatement pstmt =con.prepareStatement(sql);
            pstmt.setInt(1,deal.getPropertyId());
            pstmt.setString(2,deal.getAgentName());
            pstmt.setDouble(3,deal.getAskingPrice());
            pstmt.setString(4,deal.getRegion());
            pstmt.setString(5,deal.getType());
            pstmt.setDate(6,convertDate(deal.getClosingDate()));


            status = pstmt.executeUpdate();

            if(status>0){
                System.out.println("Record inserted");
                System.out.println();
            }
            else{
                System.out.println("Record not inserted");
            }
            return status;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * DisplayProperty takes Property object and displays the object in formatted way
	 * @param p - Property object
	 */
	public void DisplayProperty(Property p) {
		System.out.println("Property ID : "+ p.getPropertyId());
		System.out.println("Agent Name  : "+ p.getAgentName());
		System.out.println("Asking Price: "+ p.getAskingPrice());
		System.out.println("Region      : "+ p.getRegion());
		System.out.println("Type        : "+ p.getType());
		System.out.println("Closing Date: "+ p.getClosingDate());

	}
	/**
	 * displayRecords fetches all the records and prints to the console.
	 */
	public List<Property> displayRecords(){
        List<Property> deals = new ArrayList<>();
        Connection con =getConnection();
        String sql = "select * from Properties";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Property deal_record = new Property(rs.getInt("PropertyId"),rs.getString("AgentName"),rs.getDouble("AskingPrice"),
                		rs.getString("Region"),rs.getString("Type"),rs.getDate("ClosingDate"));
                deals.add(deal_record);
            }
            for(int i=0;i<deals.size();i++) {
            	DisplayProperty(deals.get(i));
            	System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deals;
    }

   /**
    * getRecordById fetches single record and prints to the console.
    * @param deal_id
    */
    public Property getRecordById(int deal_id){
        Property deal_record = null;
        Connection con = getConnection();
        String sql = "select * from Properties where PropertyId=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,deal_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
            	deal_record = new Property(rs.getInt("PropertyId"),rs.getString("AgentName"),rs.getDouble("AskingPrice"),
                		rs.getString("Region"),rs.getString("Type"),rs.getDate("ClosingDate"));
            }
            DisplayProperty(deal_record);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deal_record;
    }
    /**
     * updateRecordById takes the id and values to update the database object
     * @param deal_id
     * @param updated_deal
     */
    public void updateRecordById (int deal_id,Property updated_deal){
        Connection con = getConnection();
        String sql = "update Properties set ";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            if(updated_deal.getAgentName() != null) {
            	sql = pstmt.toString().split(":")[1] + "AgentName=?,";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, updated_deal.getAgentName());
            }
            if(updated_deal.getAskingPrice() != null) {
            	sql = pstmt.toString().split(":")[1] + "AskingPrice=?,";
                pstmt = con.prepareStatement(sql);
                pstmt.setDouble(1, updated_deal.getAskingPrice());
            }
            if(updated_deal.getRegion() != null) {
            	sql = pstmt.toString().split(":")[1] + "Region=?,";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, updated_deal.getRegion());
            }
            if(updated_deal.getType() != null) {
            	sql = pstmt.toString().split(":")[1] + "Type=?,";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, updated_deal.getType());
            }
            if(updated_deal.getClosingDate() != null) {
            	sql = pstmt.toString().split(":")[1] + "ClosingDate=?,";
                pstmt = con.prepareStatement(sql);
                pstmt.setDate(1, convertDate(updated_deal.getClosingDate()));
            }
            sql = pstmt.toString().split(":")[1];
            sql = sql.substring(0, sql.lastIndexOf(','));
            sql += " where PropertyId=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,deal_id);
            System.out.println(pstmt);
            System.out.println(sql);
            int status = pstmt.executeUpdate();
            if(status >0){
                System.out.println("Record updated");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * deleteRecordById takes property id and delete database object
     * @param deal_id
     */
    public void deleteRecordById(int deal_id) {
        Connection con = getConnection();
        String sql = "Delete from Properties where PropertyId=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,deal_id);
            pstmt.execute();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
