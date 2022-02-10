package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {
	 static Scanner scanner = new Scanner(System.in);
	 static User user;
	

		/*
		 * public static void main(String[] args) throws IOException { int opt=0;
		 * 
		 * //DatabaseConnection dbc = new DatabaseConnection(); //dbc.connect(); do{
		 * System.out.println("Login as\n1.Admin\n2.Voter\n"); opt = scanner.nextInt();
		 * 
		 * if(opt==1) { LoginAsAdmin(); }
		 * 
		 * else if(opt==2) { LoginAsVoter();
		 * 
		 * }
		 * 
		 * } while(opt!=1 || opt!=2);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 */
	public  void LoginAsAdmin(){
		user = new Admin();
		user.login("Admin");
		int opt1 = 0;

		do {
			user.Menu();
			opt1  = scanner.nextInt();
			if(opt1==1) {
				user.howtovote();
			}
			else if(opt1==2) {
				user.addnewparty();
			}
			else if(opt1==3) {
				user.addnewcandidate();

			}
			else if(opt1==4) {
				user.calculatevotespercentage();
			}
			else if(opt1==5) {
				user.displayresults();
			}
			else if(opt1==6) {
				System.exit(0);;
			}
			else System.out.println("Invalid operation!\n");
			}while(opt1!=1 || opt1!=2 ||opt1!=3 || opt1!=4 || opt1!=5);
		
	
	
	
	}
	
	public  void LoginAsVoter() throws IOException{
		
		
		
		user = new Voter();
		user.login("Voter");
		int opt1 = 0;
		do {
		user.Menu();
		opt1  = scanner.nextInt();
		if(opt1==1) {
			user.howtovote();
		}
		else if(opt1==2) {
		if(user.votecasted == false) {
			user.Castvote(user.getReg_no());
			}
		else {System.out.println("Vote already casted or vote not eligible\n");}
		}
		else if(opt1==3) {
			System.exit(0);;
		}
		else System.out.println("Invalid operation!\n");
		}while(opt1!=3);
		System.exit(0);
	}

	
	


}

