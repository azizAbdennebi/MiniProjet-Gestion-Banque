package application.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Compte extends CompteAbstraitee {
	

	public Compte(Client c, Agence a, int rib,double solde) {
		super(c, a, rib,solde);
		// TODO Auto-generated constructor stub
	}
	public Compte(String nom, String prenom, long cin, double salaire, int rib, Agence a,double solde) {
		super(nom, prenom, cin, salaire, rib, a,solde);
		// TODO Auto-generated constructor stub
	}
	//private long RIB;
	//Client client;
	
	//Agence agence;
	
	
	/*public Compte(long rIB,String nom_client , String prenom_client ,long cin_client ,double client_salaire, double solde,Agence a) {
		//super();
		this.RIB = rIB;
		this.agence=a;
		this.client =new Client(nom_client,prenom_client,cin_client,client_salaire);
		this.solde = solde;
	}
	*/
	
	






	@Override
	public String toString() {
		return "Compte [RIB=" + RIB + ", nom=" + client.getNom() +", prenom=" + client.getPrenom() + ", cin=" + client.getCin() +", salaire=" + client.getSalaire()+", solde" + solde + "]";
	}




	public long getRIB() {
		return RIB;
	}


	public void setRIB(int rIB) {
		RIB = rIB;
		this.update();
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
		this.update();
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
		this.update();
	}


	public Agence getAgence() {
		return agence;
	}


	public void setAgence(Agence agence) {
		this.agence = agence;
		this.update();
	}


	public boolean versement (double montant)
	{
		solde+=montant;
		agence.crediter(montant);
		this.update();
		return true;
	}
	
	public boolean retrait (double montant)
	{
		if(this.solde>=montant)
		{
			solde-=montant;
			agence.debiter(montant);
			this.update();
			return true;
		}
		return false;
	}
	
	public boolean virement (double montant,Compte C)
	{
		if(retrait(montant))
		{
			//this.retrait(montant);
			C.versement(montant);
			return true;
		}
		return false;
	}
	public void affiche_solde() {
		System.out.printf("solde du client %d est %.2f \n",this.getRIB(),this.getSolde());
	}
   public int compare_soldes(Compte c) {
	   if (this.getSolde()>c.getSolde()) {
			System.out.printf("le compte du rib %d poss�de plus d'argent que le compte du rib %d \n",this.getRIB(),c.getRIB());
			return 1;
		}
		else if (this.getSolde()<c.getSolde()) {
			System.out.printf("le compte du rib %d poss�de plus d'argent que le compte du rib %d\n",c.getRIB(),this.getRIB());
			return -1;
		}
		else {
			System.out.printf("le compte du rib %d poss�de le meme nombre  d'argente que le compte du rib %d\n",c.getRIB(),this.getRIB());
		return 0;
		}
	   
   }

public static 	int compare_soldes (Compte c1,Compte c2)
{
	if (c1.getSolde()>c2.getSolde()) {
		System.out.printf("le compte du rib %d poss�de plus d'argent que le compte du rib %d\n",c1.getRIB(),c2.getRIB());
		return 1;
	}
	else if (c1.getSolde()>c2.getSolde()) {
		System.out.printf("le compte du rib %d poss�de plus d'argent que le compte du rib %d\n",c2.getRIB(),c1.getRIB());
		return -1;
	}
	else {
		System.out.printf("le compte du rib %d poss�de le meme nombre  d'argente que le compte du rib %d\n",c1.getRIB(),c2.getRIB());
		return 0;
	}
}
@Override
boolean virement(CompteAbstraitee c, double montant) {
	if(this.retrait(montant))
	{
		//this.retrait(montant);
		c.versement(montant);
		return true;
	}
	return false;
}
	
@Override
public void addDB() {
	// TODO Auto-generated method stub
	this.client.addDB();
	this.agence.addDB();
	
	if (this.getCompteByRIB(this.RIB)!=null)
	{
		return;
	}
	
	MysqlCon req=new MysqlCon();
	String s="INSERT INTO `comptesalaire` (`rib`, `cin`, `idagence`, `solde`) VALUES ("+this.RIB+", "+this.client.cin+", "+this.agence.getID()+", "+this.solde+");";
	req.exec(s);
}




public  ArrayList<CompteAbstraitee> getAll() {
	// TODO Auto-generated method stub
	ArrayList<CompteAbstraitee> comptes=new ArrayList<CompteAbstraitee>();
	MysqlCon req=new MysqlCon();
	String s="select * from comptesalarie";
	ResultSet rs=req.request(s);
	//ArrayList<Client> listClient= new ArrayList<Client>();
	try {
	while(rs.next()) {
		
			Compte c=new Compte(Client.getDB(rs.getInt(2)),Agence.getById(rs.getInt(3)),rs.getInt(1),rs.getDouble(4));
			comptes.add(c);
		
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return comptes;
	
}
@Override
public void update() {
	// TODO Auto-generated method stub
	MysqlCon req=new MysqlCon();
	this.addDB();
	String s="UPDATE `comptesalaire` SET `rib` = '"+this.RIB+"', `cin` = '"+this.client.cin+"', `idagence` = '"+this.agence.getID()+"', `solde` = '"+this.solde+"' WHERE `comptesalaire`.`rib` ="+this.RIB+" ;";
	req.exec(s);
	
}
@Override
public CompteAbstraitee getCompteByRIB(int r) {
	
	MysqlCon req=new MysqlCon();
	String s="select * from comptesalarie where (rib="+this.RIB+")";
	ResultSet rs=req.request(s);
	//ArrayList<Client> listClient= new ArrayList<Client>();
	try {
	while(rs.next()) {
		
			Compte c=new Compte(Client.getDB(rs.getInt(2)),Agence.getById(rs.getInt(3)),rs.getInt(1),rs.getDouble(4));
			return c;
		
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	// TODO Auto-generated method stub
	return null;
}}

