package application;

import application.core.CompteAbstraitee;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerTest {
	@FXML public TableView<CompteAbstraitee> Table_Comptes;
	//@FXML public TableView<CompteAbstraitee> Table_Comptes;
	@FXML public TableColumn<CompteAbstraitee,String> rib;
	@FXML public TableColumn<CompteAbstraitee,String> solde;
	@FXML public TableColumn<CompteAbstraitee,String> nom;
	@FXML public TableColumn<CompteAbstraitee,String> prenom;
	@FXML public TableColumn<CompteAbstraitee,String> agenceNom;
	@FXML public TableColumn<CompteAbstraitee,String> agenceAdresse;
	
	
	//@FXML public TableView<TableComptes> Table_Cotes;
	void initialize() {
		//ObservableList<CompteAbstraitee> data = CompteAbstraitee.getObservableList1();
		rib.getColumns();
		Table_Comptes=new TableView<CompteAbstraitee>();
		rib=new TableColumn<CompteAbstraitee,String>("rib");
		
		solde=new TableColumn<CompteAbstraitee,String>("solde");
		nom=new TableColumn<CompteAbstraitee,String>("nom");
		prenom=new TableColumn<CompteAbstraitee,String>("prenom");
		agenceNom= new TableColumn<CompteAbstraitee,String> ("agenceNom");
		agenceAdresse=new TableColumn<CompteAbstraitee,String>("agenceAdresse");
		////////////////
		//ObservableList<CompteAbstraitee> data = CompteAbstraitee.getObservableList1();
				 
		
		rib.setCellValueFactory(new PropertyValueFactory<>("rib"));
		solde.setCellValueFactory(new PropertyValueFactory<>("solde"));
		nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		agenceNom.setCellValueFactory(new PropertyValueFactory<>("agenceNom"));
		agenceAdresse.setCellValueFactory(new PropertyValueFactory<>("agenceAdresse"));
		for (CompteAbstraitee c: CompteAbstraitee.GetEveryCompte())
		{
			initData(c);
		}
		
	}
	void initData(CompteAbstraitee c) {
		rib.cellValueFactoryProperty().asString(Integer.toString(c.RIB));
		solde.cellValueFactoryProperty().asString(Double.toString(c.solde));
		nom.cellValueFactoryProperty().asString(c.client.nom);
		prenom.cellValueFactoryProperty().asString(c.client.prenom);
		agenceNom.cellValueFactoryProperty().asString(c.agence.nom);
		agenceAdresse.cellValueFactoryProperty().asString(c.agence.adresse);
		
	   // nom.setText();
	    //prenom.setText(c.prenom);
	    //solde.setText());
	    
	  }
}
	

