package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class BDD 
{
	private String serveur, bdd, user,mdp; 
	private Connection maConnexion; 
	
	public BDD (String serveur, String bdd, String user, String mdp) // on définie la bdd
	{
		this.serveur = serveur;
		this.bdd = bdd; 
		this.user = user; 
		this.mdp = mdp;
		this.maConnexion = null;
	}
	
	public void chargerPilote ()  
	{
		//verification de la presence du pilote JDBC : (le plugin pour connecter mysql avec notre client lourd
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException exp)
		{
			System.out.println("Absence de pilote JDBC");
		}
	}
	
	public void seConnecter (){
		//methode de connexion au serveur et la bdd
		String url ="jdbc:mysql://" + this.serveur+"/"+this.bdd;
		try
		{
			this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur de connexion a : " + url);
		}
	}
	public void seDeConnecter (){
		//methode de deconnexion de la BDD
		try{
			if (this.maConnexion != null)
			{
				this.maConnexion.close();
			}
		}catch (SQLException exp)
		{
			System.out.println("Erreur de fermeture de la connexion");
		}
	}
	
	public Connection getMaConnexion ()
	{
		//getter sur la variable connection 
		return this.maConnexion; 
	}
}
