package application.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class CompteEpargne extends CompteAbstraitee {
	LocalDate date_creation;
	LocalDate date_dernierversement;
	double montant_c;
	
	//LocalDate date_jour=LocalDate.now();
	Period p ;//= Period.between(date_jour,date_dernierversement);
	
	
	


	


	public CompteEpargne(String nom, String prenom, long cin, double salaire, int rib, Agence a,
			 double montant_c, double solde) {
		super(nom, prenom, cin, salaire, rib, a,solde);
		
		this.montant_c = montant_c;
		//this.solde = solde;
		
		LocalDate date_jour=LocalDate.now();
		date_creation=date_jour;
		date_dernierversement=date_jour;
		p=Period.between(date_jour,date_dernierversement);
	}
	
	
	public CompteEpargne(String nom, String prenom, long cin, double salaire, int rib, Agence a,
			 double montant_c, double solde,LocalDate date_creation,LocalDate date_dernierversement) {
		super(nom, prenom, cin, salaire, rib, a,solde);
		
		this.montant_c = montant_c;
		//this.solde = solde;
		
		
		this.date_creation=date_creation;
		this.date_dernierversement=date_dernierversement;
		p=Period.between(LocalDate.now(),date_dernierversement);
	}
	
	public CompteEpargne(Client c, int rib, Agence a,
			 double montant_c, double solde) {
		super(c, a,rib,solde);
		
		this.montant_c = montant_c;
		//this.solde = solde;
		
		LocalDate date_jour=LocalDate.now();
		date_creation=date_jour;
		date_dernierversement=date_jour;
		p=Period.between(date_jour,date_dernierversement);
	}
	
	public CompteEpargne(Client c, int rib, Agence a,
			 double montant_c, double solde,LocalDate date_creation,LocalDate date_dernierversement) {
		super(c, a,rib,solde);
		
		this.montant_c = montant_c;
		//this.solde = solde;
		
		this.date_creation=date_creation;
		this.date_dernierversement=date_dernierversement;
		p=Period.between(LocalDate.now(),date_dernierversement);
	}



	@Override
	boolean versement(double montant) {
		// TODO Auto-generated method stub
		this.solde+=montant;
		this.update();
		
		return true;
	}


	@Override
	boolean virement(CompteAbstraitee c, double montant) {
		if (this.retrait(montant))
		{
			return(c.versement(montant));
		}
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	boolean retrait(double montant) {
		// TODO Auto-generated method stub
		if (this.solde>montant)
		{
			this.solde-=montant;
			this.update();
			return true;
		}
		return false;
	}
	public boolean Versement (double montant) {
		
		if( p.getYears() == 0 && p.getMonths() == 0) {
			solde+=montant;
			this.agence.crediter(montant);
			date_dernierversement = LocalDate.now();
			montant_c+=montant;
			this.update();
			return true;
		}
		else 
		if (p.getYears() == 0 && p.getMonths() == 1) {
			if(montant_c>=20) {
				montant_c = montant;
				solde+= montant;
				this.agence.crediter(montant);
				this.update();
				return true;
				
			}
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
		//String s1="insert into Client values (NULL,"+this.nom+","+this.prenom+",""";
		String s="INSERT INTO `compteepargne` (`rib`, `cin`, `idagence`, `solde`, `dateCreation`, `dateDVersement`) VALUES ("+this.RIB+", "+this.client.cin+","+this.agence.getID()+", "+this.solde+", '"+this.date_creation+"', '"+this.date_dernierversement+"');";
		//System.out.println(s);
		req.exec(s);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		MysqlCon req=new MysqlCon();
		String s="UPDATE `compteepargne` SET `rib` = '"+this.RIB+"', `cin` = '"+this.client.cin+"', `idagence` = '"+this.agence.getID()+"', `solde` = '"+this.solde+"', `dateCreation` = '"+this.date_creation+"', `dateDVersement` = '"+this.date_dernierversement+"' WHERE `compteepargne`.`rib` = "+this.RIB+";";
		req.exec(s);
		
		//return false;
	}

	@Override
	public CompteAbstraitee getCompteByRIB(int r) {
		// TODO Auto-generated method stub
		CompteAbstraitee c=null;
		MysqlCon req=new MysqlCon();
		String s="SELECT * FROM `compteepargne` where (rib="+r+")";
		ResultSet rs=req.request(s);
		//ArrayList<Client> listClient= new ArrayList<Client>();
		try {
		while(rs.next()) {
			
				c=new CompteEpargne(Client.getDB(rs.getInt(2)),rs.getInt(1),Agence.getById(rs.getInt(3)),rs.getDouble(4),rs.getDouble(5)/*,rs.getDate(6),rs.getDate(7)*/);
				return c;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public ArrayList<CompteAbstraitee> getAll() {
		ArrayList<CompteAbstraitee> comptes=new ArrayList<CompteAbstraitee>();
		MysqlCon req=new MysqlCon();
		String s="SELECT * FROM `compteepargne`";
		ResultSet rs=req.request(s);
		//ArrayList<Client> listClient= new ArrayList<Client>();
		try {
		while(rs.next()) {
			
				CompteEpargne c=new CompteEpargne(Client.getDB(rs.getInt(2)),rs.getInt(1),Agence.getById(rs.getInt(3)),rs.getDouble(4),rs.getDouble(5)/*,rs.getDate(6),rs.getDate(7)*/);
				comptes.add(c);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return comptes;
	}
}
