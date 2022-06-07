package application.GestionComptes;

import application.core.Agence;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AgenceControllers {
	@FXML TextField name;
	@FXML TextArea adress;
	@FXML TextField credit;
	@FXML TextField debit;
	
	@FXML Button addAgence;
	
	boolean add() {
		if(name==null||adress==null||credit==null||debit==null)
			return false;
		
		Agence a;
		String nom,adresse;
		double credi,deb;
		nom=name.getText();
		
		adresse=adress.getText();
		credi=Double.parseDouble(credit.getText());
		deb=Double.parseDouble(debit.getText());
		a=new Agence(nom,adresse,credi,deb);
		a.addDB();
		return true;
	}
	
	
	@FXML protected void AddAgence(ActionEvent event) {
		if (add())
		{
			// get a handle to the stage
		    Stage stage = (Stage) addAgence.getScene().getWindow();
		    // do what you have to do
		    stage.close();
		}
	}
}
