 package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Main;

public class VueGenerale extends JFrame implements ActionListener 
{
	private JButton btQuitter = new JButton("Quitter");
	private JPanel plMenu = new JPanel(); 
	private JButton btClients = new JButton("Clients"); 
	private JButton btStocks = new JButton("Articles");
	private JButton btChauffeurs = new JButton("Chauffeurs");
	//private JButton btCommandes = new JButton("Commandes");
	// Creation des trois panels 
	private VueClients uneVueClients = new VueClients(); 
	private VueArticles uneVueArticles = new VueArticles(); 
	private VueChauffeurs uneVueChauffeurs = new VueChauffeurs();
	//private VueCommandes uneVueCommandes = new VueCommandes();
	
	public VueGenerale() {
		this.setTitle("Logiciel de gestion des Stocks");
		this.setLayout(null);
		this.setBounds(200, 200, 750, 450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.gray); 

		//placer le bouton quitter 
		this.btQuitter.setBounds(300, 380, 100, 20);
		this.add(this.btQuitter);
		this.btQuitter.addActionListener(this);
		
		//construction du Panel Menu 
		this.plMenu.setBounds(0, 20, 750, 30);
		this.plMenu.setLayout(new GridLayout(1, 4));
		this.plMenu.add(btClients);
		this.plMenu.add(btStocks);
		this.plMenu.add(btChauffeurs);
		//this.plMenu.add(btCommandes);
		this.add(this.plMenu);
		
		//rendre les trois boutons cliquables 
		this.btClients.addActionListener(this);
		this.btStocks.addActionListener(this);
		this.btChauffeurs.addActionListener(this);
		//this.btCommandes.addActionListener(this);
		
		//ajout des trois panels à la vue 
		this.add(this.uneVueClients);
		this.add(this.uneVueArticles);
		this.add(this.uneVueChauffeurs);
	//	this.add(this.uneVueCommandes);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Quitter" : this.dispose();
						Main.rendreVisible(true);
						break;
		case "Clients" : 
					this.uneVueClients.setVisible(true);
					this.uneVueArticles.setVisible(false);
					this.uneVueChauffeurs.setVisible(false);
			//		this.uneVueCommandes.setVisible(false);
					break;
		case "Articles" : 
			this.uneVueClients.setVisible(false);
			this.uneVueArticles.setVisible(true);
			this.uneVueChauffeurs.setVisible(false);
		//	this.uneVueCommandes.setVisible(false);
			break;
		
		case "Chauffeurs" : 
		this.uneVueClients.setVisible(false);
		this.uneVueArticles.setVisible(false);
		this.uneVueChauffeurs.setVisible(true);
	//	this.uneVueCommandes.setVisible(false);
			break;
		
		case "Commandes" : 
			this.uneVueClients.setVisible(false);
			this.uneVueArticles.setVisible(false);
			this.uneVueChauffeurs.setVisible(false);
			//this.uneVueCommandes.setVisible(true);
				break;
		}
	
		
	}

}

