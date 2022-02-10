package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	 Scanner scanner = new Scanner(System.in);
		public boolean votecasted = false;

	ArrayList<Party> parties = new ArrayList<Party>();

	private int reg_no;
	private String name;
	private String pwd;
	
	void login(String userr) {
		boolean bol0=false;
		do {
		System.out.println("Enter the Registration no.: ");
		int reg_noo  = scanner.nextInt();
		System.out.println("Enter the password: ");
		String pwdd  = scanner.next();
	
		setReg_no(reg_noo);
		setPwd(pwdd);
		if(checkdatabse(reg_noo,pwdd,userr)) {
			System.out.println("Logged In Successfully\n ");
			bol0=true;
			break;
		}
		else {
			System.out.println("Invalid Credentials\n ");

		}
		
		}while(!bol0);	
		
	}

	public boolean checkdatabse(int reg_noo, String pwdd,String userr) {
		try {boolean  bol=false,bol2=false;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//System.out.println("Driver loaded");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
		//	System.out.println("Connection Established!");
			
			 String sql0 = "select * from USERS where TYPE='"+userr+"'"; 
			  Statement stmt0 = con.createStatement();
			
			  ResultSet rs0 = stmt0.executeQuery(sql0);
			
			  while(rs0.next()) {
				  if(reg_noo == rs0.getInt("registration_no")) {
					   bol=true;
					   break;
				   }
			}
			  if(bol) { 
				  String sql = "select password from USERS where registration_no="+reg_noo; 
			  Statement stmt = con.createStatement();
			
			  ResultSet rs = stmt.executeQuery(sql);
			  while(rs.next()) {
					System.out.println(rs.getString("password"));

				  if(pwdd.equals(rs.getString("password")) ) {
					  
					   bol2=true;
					   break;
				   }
				 
			  }
			  }
				  
if(bol2) { return true;}
			
			 
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver Not loaded"+e);
		}
		catch(SQLException e) {
			System.out.println("Connection not established "+e);

		}
		return false;
		
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReg_no() {
		return reg_no;
	}

	public void setReg_no(int reg_no) {
		this.reg_no = reg_no;
	}
	
	void howtovote() {
		System.out.println("You have names of canidates infront of you and "
				+ "against each candidate there is a button. Upon entering the"
				+ " button adjacent to your desired candidate, your vote would be casted"
				+ "and vote count for that candidate will increase by one.");
		
	}
	void Castvote(int i) {}
	
	
	void calculatevotespercentage() {}
	void displayresults() {}
	void addnewparty() {}
	void addnewcandidate() {}

	void Menu() {}

	public void addtopartydatabase(String text, String text2) {}

	public void addtocandidatedatabase(String text, String text2) {
		// TODO Auto-generated method stub
		
	}

	public void updatevotecount(int parseInt, String text) {
		// TODO Auto-generated method stub
		
	}
	
}
