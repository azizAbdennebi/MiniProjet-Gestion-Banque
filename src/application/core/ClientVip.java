package application.core;

public class ClientVip extends Client {
	String nom_entreprise;
	double chiffre_affaire;
	int nbre_employes;
	
	public ClientVip(String nom, String prenom, long cin, double salaire, String nom_entreprise, double chiffre_affaire,
			int nbre_employes) {
		super(nom, prenom, cin, salaire);
		this.nom_entreprise = nom_entreprise;
		this.chiffre_affaire = chiffre_affaire;
		this.nbre_employes = nbre_employes;
	}
	public void addDB() {
		
		Client c;
		c=(Client)this;
		c.addDB();
		MysqlCon req=new MysqlCon();
		
		
		
		//String s1="insert into Client values (NULL,"+this.nom+","+this.prenom+",""";
		String s="INSERT INTO `clientvip` (`cin`, `nomentreprise`, `chiffre_affaire`, `nbr_emp`) VALUES ("+this.cin+", '"+this.nom_entreprise+"', '"+this.chiffre_affaire+"', '"+this.nbre_employes+"');";
		System.out.println(s);
		req.exec(s);
	}
	
	public String getNom_entreprise() {
		return nom_entreprise;
	}
	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}
	public double getChiffre_affaire() {
		return chiffre_affaire;
	}
	public void setChiffre_affaire(double chiffre_affaire) {
		this.chiffre_affaire = chiffre_affaire;
	}
	public int getNbre_employes() {
		return nbre_employes;
	}
	public void setNbre_employes(int nbre_employes) {
		this.nbre_employes = nbre_employes;
	}
	@Override
	public String toString() {
		return "ClientVip [nom_entreprise=" + nom_entreprise + ", chiffre_affaire=" + chiffre_affaire
				+ ", nbre_employes=" + nbre_employes + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin
				+ ", salaire=" + salaire + "]";
	}
	
	

	
	

}

