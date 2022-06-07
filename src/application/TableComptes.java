package application;

import java.util.ArrayList;

import application.core.Agence;
import application.core.Client;
import application.core.Compte;
import application.core.CompteAbstraitee;
import application.core.CompteEpargne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//import javafx.scene.control.TableColumn;

public class TableComptes{
	int rib;
	String nom,prenom;
	ObservableList<CompteAbstraitee> Table;
	
	//int rib;
	public void TableCompte()
	{
		ArrayList<CompteAbstraitee> listeComptes=new ArrayList<CompteAbstraitee>();
		Compte c1=new Compte(null, null, 0, 0, 0, null, 0);
		CompteEpargne c2=new CompteEpargne(null, 0, null, 0, 0);
		listeComptes.addAll(c1.getAll());
		listeComptes.addAll(c2.getAll());
		ObservableList<CompteAbstraitee> List = FXCollections.observableArrayList(listeComptes);
		this.Table=List;
		//return(List);
		// Create column UserName (Data type of String).
	   /* TableColumn<TableComptes, String> userNameCol //
	            = new TableColumn<TableComptes, String>("User Name");*/
	}
	public void add(Client c) {
		c.addDB();
		
	}
	public void add(CompteAbstraitee c) {
		c.addDB();
	}
	public void add(Agence a) {
		a.addDB();
		
	}
	
	public ObservableList<CompteAbstraitee> liste()
	{
		return(this.Table);
	}
	
}
