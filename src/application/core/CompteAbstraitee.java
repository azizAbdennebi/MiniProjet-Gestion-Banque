package application.core;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class CompteAbstraitee {
	public Client client;
	public Agence agence;
	public int RIB;
	double solde;
	///// retourne un compte par son rib
	public abstract CompteAbstraitee getCompteByRIB(int rib);
	private static int nb_clients=0;
	
	abstract boolean versement(double montant);
	abstract boolean virement(CompteAbstraitee c,double montant);
	abstract boolean retrait(double montant);
	public abstract void addDB();
	public abstract void update();
	/////////retourne la liste de tout les comptes
	public abstract ArrayList<CompteAbstraitee> getAll();
	
	/*public static ObservableList<CompteAbstraitee> getObservableList1(){
		
		Compte c=new Compte(null, null, 0, 0);
		CompteEpargne c2=new CompteEpargne(null, 0, null, 0, 0);
		ObservableList<CompteAbstraitee> l = FXCollections.observableArrayList(c.getAll());
		@SuppressWarnings("unchecked")
		ObservableList<CompteAbstraitee> E = FXCollections.concat(l, FXCollections.observableArrayList(c2.getAll()));
		
		return (E);
		
		
	}*/
	public static ArrayList<CompteAbstraitee> GetEveryCompte(){
		Compte c=new Compte(null, null, 0, 0);
		ArrayList<CompteAbstraitee> l=c.getAll();
		
		CompteEpargne c2=new CompteEpargne(null, 0, null, 0, 0);
		l.addAll(c2.getAll());
		return(l);
	}
public static ObservableList<CompteAbstraitee> getObservableList(){
		
		Compte c=new Compte(null, null, 0, 0);
		ArrayList<CompteAbstraitee> l=c.getAll();
		
		CompteEpargne c2=new CompteEpargne(null, 0, null, 0, 0);
		l.addAll(c2.getAll());
		ObservableList<CompteAbstraitee> E = FXCollections.observableArrayList(l);
		
		
		return (E);
		
		
	}
	//public abstract ArrayList<Com>  getAll();
	//public abstract static ArrayList<CompteAbstraitee> getAll();
	public CompteAbstraitee(String nom, String prenom, long cin, double salaire,int rib,Agence a,double solde) {
		this.client=new Client(nom,prenom,cin,salaire);
		this.agence=a;
		this.RIB=rib;
		this.solde=solde;
		
	}
	public CompteAbstraitee(Client c,Agence a,int rib,double solde)
	{
		this.client=c;
		this.agence=a;
		this.RIB=rib;
		this.solde=solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public static int getNb_clients() {
		return nb_clients;
	}
	public static void setNb_clients(int nb_clients) {
		CompteAbstraitee.nb_clients = nb_clients;
	}
	
}
