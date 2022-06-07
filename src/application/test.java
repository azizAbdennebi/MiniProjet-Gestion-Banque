package application;

import java.util.ArrayList;

import application.core.Agence;
import application.core.Client;
import application.core.CompteEpargne;
import javafx.collections.ObservableList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Client.getAll());
		Client c=new Client("aziiiiiizzz","abd",13020683,20);
		//c.addDB();
		ArrayList<Client> l=Client.getAll();
		System.out.println(l);
		Agence a=new Agence("bab jazir22a", "12 rue faza", 132452, 6576);
		a.addDB();
		System.out.println(Agence.getAll());
		CompteEpargne C=new CompteEpargne(c,0,a,3564,33456);
		C.addDB();
		TableComptes test =new TableComptes();
		System.out.println(test.liste());

	}

}
