package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Article;
import controleur.Chauffeur;
import controleur.Client;
//import controleur.Commande;


public class Modele    
{
	
	public static String verifConnexion (String login, String mdp)
	{
		String requete ="Select count(*) as nb, droits " + 
						" from user where login ='"+ login 
						+"' and mdp ='" + mdp +"' ;";
		BDD uneBdd = new BDD("localhost","alumeprorwbts", "root", "root");
		String droits =""; 
				
		try
		{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int nb = unRes.getInt("nb"); 
				if(nb != 0) droits = unRes.getString("droits");  
			}
			uneBdd.seDeConnecter();
			unStat.close();
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
		return droits;
	}
	
	public static void insertClient (Client unClient)
	{
		String requete = "insert into client values (null, '" + unClient.getMail()+"' , '" + unClient.getMdp() + "', '" +
						unClient.getNom() +"', '" + unClient.getPrenom() +"',null, '" +
						unClient.getTelcli() +"', '" + unClient.getAdresse() +"', '" + unClient.getCpcli() +"',null);";
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
  		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static void insertArticle (Article unArticle)
	{
		String requete = "insert into article values ('" + unArticle.getCode_art() + "', '" + unArticle.getNoma()+"' , null, '" + unArticle.getPrixa() +"', '" + unArticle.getQte() + "',null);";
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
  		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	
	
	public static void insertChauffeur (Chauffeur unChauffeur)
	{
		String requete = "insert into chauffeur values (null, '" + unChauffeur.getNomchauf()+"' , '" + unChauffeur.getPrenomchauf() + "', '" +
					unChauffeur.getTelchauf() + "', '" + unChauffeur.getLibre() +"');";
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
  		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	
	public static ArrayList<Client> selectAllClients ()
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();
		
		String requete = "select id_cli, mail_cli, mdp_cli, nom_cli, prenom_cli, tel_cli, adress_cli, cp_cli from client ;" ;
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next())
			{
				int idclient = unRes.getInt("id_cli"); 
				String mail = unRes.getString("mail_cli");
				String mdp = unRes.getString("mdp_cli");
				String nom = unRes.getString("nom_cli"); 
				String prenom = unRes.getString("prenom_cli");
				String telcli = unRes.getString("tel_cli");
				String adresse = unRes.getString("adress_cli");
				String cpcli = unRes.getString("cp_cli");
				Client unClient = new Client(idclient, mail, mdp, nom, prenom, telcli, adresse, cpcli); 
				lesClients.add(unClient);
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete );
		}
		return lesClients; 
	}

	public static ArrayList<Article> selectAllArticle ()
	{
		ArrayList<Article> lesArticles = new ArrayList<Article>();
		
		String requete = "select code_art, nom_art, prix_art, qte from article ;" ;
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next())
			{
				String code_art = unRes.getString("code_art");
				String noma = unRes.getString("nom_art");
				String prixa = unRes.getString("prix_art");
				String qte = unRes.getString("qte");
				Article unArticle = new Article(code_art, noma, prixa, qte); 
				lesArticles.add(unArticle);
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete );
		}
		return lesArticles; 
	}
	

	public static ArrayList<Chauffeur> selectAllChauffeur ()
	{
		ArrayList<Chauffeur> lesChauffeurs = new ArrayList<Chauffeur>();
		
		String requete = "select id_chauf, nom_chauf, prenom_chauf, tel_chauf, libre from chauffeur ;" ;
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next())
			{
				int idchauf = unRes.getInt("id_chauf");
				String nomchauf = unRes.getString("nom_chauf");
				String prenomchauf = unRes.getString("prenom_chauf");
				String telchauf = unRes.getString("tel_chauf");
				String libre = unRes.getString("libre");
				Chauffeur unChauffeur = new Chauffeur(idchauf, nomchauf, prenomchauf, telchauf, libre); 
				lesChauffeurs.add(unChauffeur);
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete );
		}
		return lesChauffeurs; 
	}
	
	/*public static ArrayList<Commande> selectAllCommande ()
	{
		ArrayList<Commande> lesCommandes = new ArrayList<Commande>();
		
		String requete = "select id_commandc, date_commandc, id_cli from commandec;" ;
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next())
			{
				int id_commandc = unRes.getInt("id_commandc");
				String date_commandc = unRes.getString("date_commandec");
				int id_cli = unRes.getInt("id_cli"); 
				
				Commande uneCommande = new Commande(id_commandc,date_commandc,id_cli); 
				lesCommandes.add(uneCommande);
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete );
		}
		return lesCommandes; 
	}*/

	
	
	public static void deleteClient (Client unClient)
	{
		String requete = "delete from client where id_cli =" 
					+ unClient.getIdclient() +";";
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static void deleteArticle (Article unArticle)
	{
		String requete = "delete from article where code_art ="
					+ "'" + unArticle.getCode_art() +"';";
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	
	public static void deleteChauffeur (Chauffeur unChauffeur)
	{
		String requete = "delete from chauffeur where id_chauf =" 
				+ unChauffeur.getIdchauf() +";";
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static void updateClient (Client unClient)
	{
		String requete = "update client set nom_cli ='"+unClient.getNom()
					+ "', adress_cli='"+unClient.getAdresse() 
					+ "', mail_cli = '"+unClient.getMail()
				    + "', mdp_cli = '" +unClient.getMdp()
				    + "', nom_cli = '"+unClient.getNom()
				    + "', prenom_cli = '"+unClient.getPrenom()
				    + "', tel_cli = '"+unClient.getTelcli()
				    + "', adress_cli = '" + unClient.getAdresse()
					+ "', cp_cli = '" + unClient.getCpcli()
					+"' where id_cli = " + unClient.getIdclient() 
					+ ";" ;
		
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
						
	}
	public static void updateChauffeur (Chauffeur unChauffeur)
	{
		String requete = "update chauffeur set nom_chauf ='"+unChauffeur.getNomchauf()
					+ "', prenom_chauf ='"+unChauffeur.getPrenomchauf() 
					+ "', tel_chauf = '"+unChauffeur.getTelchauf()
					+ "', libre = '"+unChauffeur.getLibre()
					+"' where id_chauf = " + unChauffeur.getIdchauf()
					+ ";" ; 
					
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
						
 	}
	
	
	public static void updateArticle (Article unArticle)
	{
		String requete = "update article set code_art ='"+unArticle.getCode_art()
					+ "', nom_art ='"+unArticle.getNoma() 
					+ "', prix_art = '"+unArticle.getPrixa()
					+ "', qte = '"+unArticle.getQte()
					+ "' where code_art = '" + unArticle.getCode_art()
					+ "'"
					+ ";" ;
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
						
	}
	
	public static Client selectWhere (Client unClient)
	{
		String requete = "select id_cli, mail_cli,mdp_cli,nom_cli,prenom_cli,tel_cli,adress_cli,cp_cli from client where "
				+ " mail_cli = '"+unClient.getMail()
				+ "' and mdp_cli = '" +unClient.getMdp()
				+ "' and nom_cli = '"+unClient.getNom()
				+ "' and prenom_cli = '"+unClient.getPrenom()
				+ "' and tel_cli = '"+unClient.getTelcli()
				+ "' and adress_cli = '" + unClient.getAdresse()
				+ "' and cp_cli = '" + unClient.getCpcli()
				+ "' ; ";
		Client leClient = null;
		BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int idclient = unRes.getInt("id_cli");
				leClient = new Client(idclient, unClient.getMail(), unClient.getMdp(), unClient.getNom(), unClient.getPrenom(), unClient.getTelcli(), unClient.getAdresse(), unClient.getCpcli());
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return leClient;
	}


public static Chauffeur selectWhereC (Chauffeur unChauffeur)
{
	String requete = "select * from chauffeur  where "
			+ " nom_chauf = '"+unChauffeur.getNomchauf()
			+ "' and prenom_chauf = '" +unChauffeur.getPrenomchauf()
			+ "' and tel_chauf = '"+unChauffeur.getTelchauf()
			+ "' and libre = '"+unChauffeur.getLibre()
			+"' ; ";
	System.out.println(requete);
	Chauffeur leChauffeur = null;
	BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
	try
	{
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unRes = unStat.executeQuery(requete);
		if (unRes.next())
		{
			int idchauf = unRes.getInt("id_chauf");
			leChauffeur = new Chauffeur(idchauf,unChauffeur.getNomchauf(), unChauffeur.getPrenomchauf(), unChauffeur.getTelchauf(),unChauffeur.getLibre());
		}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp)
	{
		System.out.println("Erreur : " + requete);
	}
	return leChauffeur;
}


public static Article selectWhereA (Article unArticle)
{
	String requete = "select * from article where "
			+ " code_art = '" +unArticle.getCode_art()
			+ "' and  nom_art = '"+unArticle.getNoma()
			+ "' and prix_art = '"+unArticle.getPrixa()
			+ "' and qte = '"+unArticle.getQte()
			+"' ; ";
	Article lArticle = null;
	BDD uneBdd = new BDD("localhost", "alumeprorwbts", "root", "root");
	try
	{
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unRes = unStat.executeQuery(requete);
		if (unRes.next())
		{
			String code_art = unRes.getString("code_art");
			lArticle = new Article(code_art, unArticle.getNoma(),  unArticle.getPrixa(), unArticle.getQte());
		}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp)
	{
		System.out.println("Erreur : " + requete);
	}
	return lArticle;
}
}













