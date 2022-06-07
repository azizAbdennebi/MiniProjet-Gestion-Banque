package application;

import java.io.IOException;
//import application.GestionComptes.addCompteEpargne;
import application.core.CompteAbstraitee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller {
	
	
	
	
	
	@FXML public TableView<CompteAbstraitee> Table_Comptes;
	@FXML public TableColumn<CompteAbstraitee,String> rib;
	@FXML public TableColumn<CompteAbstraitee,String> solde;
	@FXML public TableColumn<CompteAbstraitee,String> nom;
	@FXML public TableColumn<CompteAbstraitee,String> prenom;
	@FXML public TableColumn<CompteAbstraitee,String> agenceNom;
	@FXML public TableColumn<CompteAbstraitee,String> agenceAdresse;
	
	
	//@FXML public TableView<TableComptes> Table_Cotes;
	void initialize() {
		Table_Comptes=new TableView<CompteAbstraitee>();
		rib=new TableColumn<CompteAbstraitee,String>("rib");
		solde=new TableColumn<CompteAbstraitee,String>("solde");
		nom=new TableColumn<CompteAbstraitee,String>("nom");
		prenom=new TableColumn<CompteAbstraitee,String>("prenom");
		////////////////
		
		rib.setCellValueFactory(new PropertyValueFactory<>("rib"));
		solde.setCellValueFactory(new PropertyValueFactory<>("solde"));
		nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		agenceNom.setCellValueFactory(new PropertyValueFactory<>("agenceNom"));
		agenceAdresse.setCellValueFactory(new PropertyValueFactory<>("agenceAdresse"));
		
		
	}
	
	
	@FXML protected void AddCepargne(ActionEvent event) {
		 try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("GestionComptes/AddCompteEpargne.fxml"));
		        /* 
		         * if "fx:controller" is not set in fxml
		         * fxmlLoader.setController(NewWindowController);
		         */
		        Scene scene = new Scene(fxmlLoader.load());
		        Stage stage = new Stage();
		        stage.setTitle("Ajout d'un compte epargne:");
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		        System.out.println(e);
		    }
		
		
		return;
		
	}
	@FXML protected void AddClient(ActionEvent event) {
		 try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("GestionComptes/AddCompteEpargne.fxml"));
		        /* 
		         * if "fx:controller" is not set in fxml
		         * fxmlLoader.setController(NewWindowController);
		         */
		        Scene scene = new Scene(fxmlLoader.load());
		        Stage stage = new Stage();
		        stage.setTitle("Ajout d'un compte epargne:");
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		        System.out.println(e);
		    }
		
		
		return;
		
	}
	@FXML protected void AddClientVIP(ActionEvent event) {
		 try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("GestionComptes/AddCompteEpargne.fxml"));
		        /* 
		         * if "fx:controller" is not set in fxml
		         * fxmlLoader.setController(NewWindowController);
		         */
		        Scene scene = new Scene(fxmlLoader.load());
		        Stage stage = new Stage();
		        stage.setTitle("Ajout d'un compte epargne:");
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		        System.out.println(e);
		    }
		
		
		return;
		
	}
	
	@FXML protected void AddAgence(ActionEvent event) {
		 try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("GestionComptes/AddAgence.fxml"));
		        /* 
		         * if "fx:controller" is not set in fxml
		         * fxmlLoader.setController(NewWindowController);
		         */
		        Scene scene = new Scene(fxmlLoader.load());
		        Stage stage = new Stage();
		        stage.setTitle("Ajout d'une agence:");
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		        System.out.println(e);
		    }
		
		
		return;
		
	}
	
	
	@FXML protected void AddCcourant(ActionEvent event) {
		 try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("GestionComptes/AddCompte.fxml"));
		        /* 
		         * if "fx:controller" is not set in fxml
		         * fxmlLoader.setController(NewWindowController);
		         */
		        Scene scene = new Scene(fxmlLoader.load());
		        Stage stage = new Stage();
		        stage.setTitle("Ajout d'un compte epargne:");
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		        System.out.println(e);
		    }
		
		
		return;
		
	}
	
	
	void initData(CompteAbstraitee c) {
	   // nom.setText();
	    //prenom.setText(c.prenom);
	    //solde.setText());
	    
	  }
}
