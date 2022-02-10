package application;

import java.sql.*;

public class Admin extends User{

	void Menu() {
		
		System.out.println("Select the operation you want to perform\n"
				+ "1. See How to Vote (Full Description)\n"
				+ "2. Add New Party\n"
				+ "3. Add new Candidate\n"
				+ "4. See Votes Percentage\n"
				+ "5. Display Results\n"
				+ "6. Exit\n");
		
		
	} 
	
	
	
	void addnewparty(){
		System.out.println("Enter the party name: ");
		String partyname  = scanner.next();
		System.out.println("Enter the Leader's name: ");
		String leadername  = scanner.next();
		parties.add(new Party(partyname,leadername));
		
		addtopartydatabase(partyname,leadername);
		
	}
	public  void addtopartydatabase(String partyname, String leadername) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver loaded");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
			System.out.println("Connection Established!");
			
			  String sql = "INSERT INTO PARTY " +
			  "(name,leader) " +
			  "VALUES" + "(?,?)"; PreparedStatement stmt = con.prepareStatement(sql); 
			  stmt.setString(1, partyname.toUpperCase());
			  stmt.setString(2, leadername);
			 int rowsinserted = stmt.executeUpdate();
			  if(rowsinserted>0)System.out.println("\nParty Added Successfully");
		
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver Not loaded"+e);
		}
		catch(SQLException e) {
			System.out.println("Connection not established"+e);

		}		
	}



	public void addnewcandidate(){
		System.out.println("Enter the candidate's name: ");
		String name  = scanner.next();
		System.out.println("Enter the party's name: ");
		String party  = scanner.next();
		
		for(int i=0;i<parties.size();i++) {
			 if(parties.get(i).getPartyname().toLowerCase() == party.toLowerCase()) {
					parties.get(i).candidates.add(new Candidate(name,party));

				 } 
			 }
		
		addtocandidatedatabase(name,party);
		
		
		
	}
	public void addtocandidatedatabase(String name, String party) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("Driver loaded");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
		System.out.println("Connection Established!");
		
		  String sql = "INSERT INTO CANDIDATE " +
		  "(name,party) " +
		  "VALUES" + "(?,?)"; PreparedStatement stmt = con.prepareStatement(sql); 
		  stmt.setString(1, name);
		  stmt.setString(2, party.toUpperCase());
		 int rowsinserted = stmt.executeUpdate();
		  if(rowsinserted>0)System.out.println("\nCandidate Added Successfully");
	
		con.close();
	}
	catch(ClassNotFoundException e) {
		System.out.println("Driver Not loaded"+e);
	}
	catch(SQLException e) {
		System.out.println("Connection not established"+e);

	}
	}



	public void calculatevotespercentage(){
		int total=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver loaded");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
			System.out.println("Connection Established!");
			
			 String sql0 = "select * from VOTES "; 
			  Statement stmt0 = con.createStatement();
			
			  ResultSet rs0 = stmt0.executeQuery(sql0);
			  while(rs0.next()) {
				   total+= rs0.getInt("votes");
			}
			  
			 String sql = "select * from VOTES"; 
			  Statement stmt = con.createStatement();
			
			  ResultSet rs = stmt.executeQuery(sql);
			  while(rs.next()) {
				System.out.println(rs.getString("party")+" has "+((rs.getInt("VOTES")*100)/total)
							+"% votes\n");
				 
			  }
				  

			
			 
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver Not loaded"+e);
		}
		catch(SQLException e) {
			System.out.println("Connection not established "+e);

		}
		
		
		
		
		
		
		
	}
	void displayresults() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver loaded");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
			System.out.println("Connection Established!");
			
			
			  String sql = "select * from VOTES"; 
			  Statement stmt = con.createStatement();
			
			  ResultSet rs = stmt.executeQuery(sql);
			
			  while(rs.next()) {
				  String party = rs.getString("PARTY");
				  int votes = rs.getInt("VOTES");
				System.out.println(party+" has "+votes+" votes\n");

			  }
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver Not loaded"+e);
		}
		catch(SQLException e) {
			System.out.println("Connection not established"+e);

		}
		
		
		
	}
	
	/*
	 * { for(int i=0;i<parties.size();i++) {
	 * if(parties.get(i).getPartyname().toLowerCase() == party.toLowerCase()) {
	 * for(int j=0;j<parties.get(i).candidates.size();j++) {
	 * if(parties.get(i).candidates.get(j).getName().toLowerCase() ==
	 * name.toLowerCase()) { parties.get(i).candidates.get(j).votecount.addcount();
	 * } } } } }
	 */


}
