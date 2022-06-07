package application.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Client {
	
	public String nom,prenom;
	public long cin;
	public double salaire ;
	public static int nb_clients;
		
	public Client(String nom, String prenom, long cin, double salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.salaire = salaire;
		nb_clients++;
	}
	public boolean exist()
	{
		MysqlCon req=new MysqlCon();
		String s="select cin from client "
				+ "where (cin="+this.cin+")";
		ResultSet rs=req.request(s);
		
		try {
		while(rs.next()) {
			return true;
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	public void addDB() {
		if (this.exist())
			return;
		MysqlCon req=new MysqlCon();
		//String s1="insert into Client values (NULL,"+this.nom+","+this.prenom+",""";
		String s="INSERT INTO Client  VALUES (NULL, '"+this.nom+"', '"+this.prenom+"', "+this.cin+", "+this.salaire+");";
		System.out.println(s);
		req.exec(s);
		
	}
	public static Client getDB(int cinn) {
		MysqlCon req=new MysqlCon();
		String s="select * from CLient (where cin="+cinn+")";
		ResultSet rs=req.request(s);
		Client c=null;
		try {
		while(rs.next()) {
			
				c=new Client(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				return(c);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (c);
	}
	
	public static ArrayList<Client> getAll()
	{
		MysqlCon req=new MysqlCon();
		String s="select * from CLient";
		ResultSet rs=req.request(s);
		ArrayList<Client> listClient= new ArrayList<Client>();
		try {
		while(rs.next()) {
			
				Client c=new Client(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				listClient.add(c);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (listClient);
		
	}
	
	
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", salaire=" + salaire + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public static int getNb_clients() {
		return nb_clients;
	}

	public static void setNb_clients(int nb_clients) {
		Client.nb_clients = nb_clients;
	}
	
}
