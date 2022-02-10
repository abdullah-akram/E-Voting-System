package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



	public class first_screen_Controller implements Initializable {
	
		@FXML
		private Label labelk ;
		
		@FXML
		private Label labelkk = new Label();
		
		@FXML
		private AnchorPane parent ;
		
		@FXML
		private TextField regnoA;
		
		@FXML
		private TextField vote1;
		
		@FXML
		private TextField regnoV;
		
		@FXML
		private TextField part1;
		
		@FXML
		private TextField part2;
		
		@FXML
		private TextField cand;
		
		@FXML
		private TextField leader;
		
		@FXML
		private PasswordField pwdA;
		
		@FXML
		private PasswordField pwdV;
		
		public Controller c = new Controller();
		

        Stage anotherStage = new Stage();

		/*
		 * public void start(Stage primaryStage) { try { VBox root =
		 * (VBox)FXMLLoader.load(getClass().getResource("first_screen.fxml")); Scene
		 * scene = new Scene(root,400,500);
		 * scene.getStylesheets().add(getClass().getResource("application.css").
		 * toExternalForm()); primaryStage.setScene(scene); primaryStage.show(); }
		 * catch(Exception e) { e.printStackTrace(); } }
		 */

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
		
		
		@FXML
		public void LoginCredentialsAdmin(ActionEvent event) throws IOException 
		{
			FXMLLoader loader = new
			FXMLLoader(getClass().getResource("LoginCredentialsAdmin.fxml")); 
			Parent root = loader.load();
			
			//  labelk.setText("kjsd");

			Stage stage = new Stage(); 
			stage.setScene(new Scene(root,600,400));
			stage.setTitle("Admin Login"); stage.show();
		
		}
		
		@FXML
		public void LoginCredentialsVoter(ActionEvent event) throws IOException 
		{			 
			

			
			 FXMLLoader loader = new
			 FXMLLoader(getClass().getResource("LoginCredentialsVoter.fxml")); Parent root
			 = loader.load();
				/*
				 * String d = "swk"; labelkk.setText(d);
				 */
			  
			 Stage stage = new Stage(); stage.setScene(new Scene(root,600,400));
			 
			 stage.setTitle("Voter Login"); stage.show();
			 
			

		}
		
		
		
		
		@FXML
		public void LoginAsAdminn(ActionEvent event) throws IOException 
		{
		        System.out.println(regnoA.getText());
		        c.user = new Admin();
		     if(  c.user.checkdatabse(Integer.parseInt(regnoA.getText()), pwdA.getText(), "Admin")) {
		        
		        
			  FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
			  Parent root =  loader.load();
			  
			  Stage stage = new Stage(); stage.setScene(new Scene(root,600,400));
			  stage.setTitle("MENU"); stage.show();			 	           
		     }
		    else System.out.println("wrong voter");
		}
		
		@FXML
		public void LoginAsVoterr(ActionEvent event) throws IOException 
		{

        System.out.println(regnoV.getText());
        System.out.println(regnoV.getText());
        c.user = new Voter();
     if(  c.user.checkdatabse(Integer.parseInt(regnoV.getText()), pwdV.getText(), "Voter")) {
        
		  FXMLLoader loader = new
		  FXMLLoader(getClass().getResource("VoterMenu.fxml")); Parent root =
		  loader.load();
		  
		  Stage stage = new Stage(); stage.setScene(new Scene(root,600,400));
		  stage.setTitle("MENU"); stage.show();
     }
     else System.out.println("wrong voter");
     
		}
	
	
	
	@FXML
	public void CastVotee(ActionEvent event) throws IOException 
	{
		 FXMLLoader loader = new
				  FXMLLoader(getClass().getResource("castvotee.fxml")); Parent root =
				  loader.load();
				  
				  Stage stage = new Stage(); stage.setScene(new Scene(root,600,400));
				  stage.setTitle("Cast Vote"); stage.show();
		
	
	}
	@FXML
	public void HowToVote(ActionEvent event) throws IOException 
	{
		 FXMLLoader loader = new
				  FXMLLoader(getClass().getResource("howtovote.fxml")); Parent root =
				  loader.load();
				  
				  Stage stage = new Stage(); stage.setScene(new Scene(root,600,400));
				  stage.setTitle("HOWTOVOTE"); stage.show();

	}
	
	

	
	@FXML
	public void AddNewPartyy(ActionEvent event) throws IOException 
	{
		FXMLLoader loader = new
				  FXMLLoader(getClass().getResource("Addnewparty.fxml")); Parent root =
				  loader.load();
				  
				  Stage stage = new Stage(); stage.setScene(new Scene(root,600,400));
				  stage.setTitle("Add New Party"); stage.show();

				  
	}
	
	@FXML
	public void AddPartyToDB(ActionEvent event) throws IOException 
	{
		c.user.addtopartydatabase(part2.getText(),leader.getText());
	  
	}
	
	@FXML
	public void AddNewCandidatee(ActionEvent event) throws IOException 
	{
		FXMLLoader loader = new
				  FXMLLoader(getClass().getResource("Addnewcandidate.fxml")); Parent root =
				  loader.load();
				  
				  Stage stage = new Stage(); stage.setScene(new Scene(root,600,400));
				  stage.setTitle("Add New Candidate"); stage.show();
				  
				  

				  
	}
	
	@FXML
	public void AddCandidateToDB(ActionEvent event) throws IOException 
	{
		c.user.addtocandidatedatabase(cand.getText(),part1.getText());
	  
	}
	
	@FXML
	public void AddvotetoDB(ActionEvent event) throws IOException 
	{
		c.user.updatevotecount(Integer.parseInt(vote1.getText()),part1.getText());
	  
	}
	
	@FXML
	public void CheckResults(ActionEvent event) throws IOException 
	{
		System.out.println("CMONNNNNN");

	}
	
	@FXML
	public void CalculatePercentage(ActionEvent event) throws IOException 
	{
		System.out.println("CMONNNNNN");

	}
	
	@FXML
	public void exit(ActionEvent event) throws IOException 
	{
		System.exit(0);

	}
	
	
	}

