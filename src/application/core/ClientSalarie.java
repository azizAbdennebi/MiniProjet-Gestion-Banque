package application.core;

public class ClientSalarie extends Client{
	public String profession;

	public ClientSalarie(String nom, String prenom, long cin, double salaire, String profession) {
		super(nom, prenom, cin, salaire);
		this.profession = profession;
	}
	
	public void addDB()
	{
		Client c=(Client)this;
		c.addDB();
		MysqlCon req=new MysqlCon();
		//String s1="insert into Client values (NULL,"+this.nom+","+this.prenom+",""";
		String s="INSERT INTO ClientSalarie  VALUES ("+this.cin+","+this.profession+");";
		//System.out.println(s);
		req.exec(s);
		
	}
	
	
	

}
