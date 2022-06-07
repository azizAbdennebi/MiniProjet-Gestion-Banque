package application.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Agence {
	public String nom,adresse;
	public static double credit_global_banque,debit_global_banque;
	public double credit_global_agence,debit_global_agence ;
	
	public Agence(String nom, String adresse, double credit_global_agence, double debit_global_agence) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.credit_global_agence = credit_global_agence;
		this.debit_global_agence = debit_global_agence;
	}
	public void update() {
		// TODO Auto-generated method stub
		MysqlCon req=new MysqlCon();
		this.addDB();
		String s="UPDATE `agence` SET `nom` = '"+this.nom+"', `adresse` = '"+this.adresse+"', `credit` = '"+this.credit_global_agence+"', `debit` = '"+this.debit_global_agence+"' WHERE (idagence ="+this.getID()+") ;";
		req.exec(s);
		
	}

//////////ajout a la base de donnee
	public void addDB()
	{
		if (this.getID()==0)
		{
			MysqlCon req=new MysqlCon();
			//String s1="insert into Client values (NULL,"+this.nom+","+this.prenom+",""";
			String s="INSERT INTO `agence` (`idagence`, `nom`, `adresse`, `credit`, `debit`) VALUES (NULL, '"+this.nom+"', '"+this.adresse+"', '"+this.credit_global_agence+"', '"+this.debit_global_agence+"');";
			System.out.println(s);
			req.exec(s);
			return;
		}
		System.out.println("existe deja!!");
		
	}
	////retourne l'ID de l agence
	public int getID()
	{
		int id=0;
		MysqlCon req=new MysqlCon();
		String s="select idagence from agence where (nom='"+this.nom+"') ;";
		ResultSet rs=req.request(s);
		
		try {
		while(rs.next()) {
			id=rs.getInt(1);
			return id;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(id);
	}
	
	
	////////recuperer une agence a partir de son id
	public static Agence getById(int id){
		Agence a=null;
		MysqlCon req=new MysqlCon();
		String s="select * from agence where (idagence="+id+") ;";
		ResultSet rs=req.request(s);
		
		try {
		while(rs.next()) {
			a=new Agence(rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5));
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
/////lecture de tout les agences de la base
	public static ArrayList<Agence> getAll()
	{
		MysqlCon req=new MysqlCon();
		String s="select * from agence;";
		ResultSet rs=req.request(s);
		ArrayList<Agence> listagence= new ArrayList<Agence>();
		try {
		while(rs.next()) {
			
				Agence c=new Agence(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				listagence.add(c);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (listagence);
		
	}
	
	
	
	/////lecture de tout les agences de la base

	
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public static double getCredit_global_banque() {
		return credit_global_banque;
	}

	public static void setCredit_global_banque(double credit_global_banque) {
		Agence.credit_global_banque = credit_global_banque;
	}

	public static double getDebit_global_banque() {
		return debit_global_banque;
	}

	public static void setDebit_global_banque(double debit_global_banque) {
		Agence.debit_global_banque = debit_global_banque;
	}

	public double getCredit_global_agence() {
		return credit_global_agence;
	}

	public void setCredit_global_agence(double credit_global_agence) {
		this.credit_global_agence = credit_global_agence;
	}

	public double getDebit_global_agence() {
		return debit_global_agence;
	}

	public void setDebit_global_agence(double debit_global_agence) {
		this.debit_global_agence = debit_global_agence;
	}
	
	
	public boolean crediter(double montant)
	{
		credit_global_agence+=montant;
		credit_global_banque+=montant;
		return true;
		
	}
	
	public boolean debiter(double montant)
	{
		
		debit_global_agence-=montant;
		debit_global_banque-=montant;
		return true;
	}
	

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Nom agence: "+this.nom+"Adresse de l'agence: "+this.adresse);
	}
	

}
