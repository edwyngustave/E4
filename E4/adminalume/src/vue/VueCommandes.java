package vue;
/*
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Commande;
import controleur.Tableau;
import modele.Modele;

public class VueCommandes extends JPanel implements ActionListener
{

	
	private JTable tableCommandes  ; 
	private Tableau unTableau ; //modele de tableau pour gerer la Jtable.
	
	public VueCommandes()
	{
		this.setBounds(20, 70 , 780 , 380);
		this.setBackground(Color.pink);
		this.setLayout(null);
		
		JPanel unPanel = new JPanel(); 
		unPanel.setBounds(20, 200, 680 , 100);
		unPanel.setLayout(new GridLayout(3, 8, 5, 5));

		
		unPanel.add(new JLabel("Id Commande :")); 
	
	
	
		//construction de la Jtable 
		String entete [] = {"Id_commandeC", "date_commandeC", "Id_Client"};
		Object [][] lesDonnees = remplirDonnees ();
		
		//gestion de la Jtable avec le Tableau.
		unTableau = new Tableau(lesDonnees, entete);
 		this.tableCommandes = new JTable (unTableau);
 		
 
 		
 		
 		JScrollPane uneScroll = new JScrollPane(tableCommandes); 
 		uneScroll.setBounds(20, 20, 680, 150);
 		this.add(uneScroll);
 		
		this.setVisible(false);
	}
	private Object[][] remplirDonnees() {
		ArrayList<Commande> lesCommandes = Modele.selectAllCommande();
		Object [][] lesDonnees = new Object[lesCommandes.size()][3];
		int i = 0 ;
		for (Commande uneCommande : lesCommandes)
		{
			lesDonnees[i][0] = uneCommande.getId_commandc() + ""; 
			lesDonnees[i][1] = uneCommande.getDate_commandc(); 
			lesDonnees[i][2] = uneCommande.getId_cli();
			
		}
	return lesDonnees; 
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

*/
	
