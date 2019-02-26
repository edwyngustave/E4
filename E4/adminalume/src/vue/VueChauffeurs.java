package vue;

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

import controleur.Chauffeur;
import controleur.Client;
import controleur.Tableau;
import modele.Modele;



public class VueChauffeurs extends JPanel implements ActionListener
{
	private JButton btAjouter = new JButton("Ajouter"); 
	private JButton btSupprimer= new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	private JTextField txtidChauff = new JTextField();
	private JTextField txtNomchau = new JTextField(); 
	private JTextField txtPrenomchau = new JTextField();
	private JTextField txtTelchau = new JTextField();
	private JTextField txtLibre= new JTextField();
	private JTable tableChauffeurs  ; 
	private Tableau unTableau ; //modele de tableau pour gerer la Jtable.

	
	public VueChauffeurs()
	{
		this.setBounds(20, 70 , 780 , 380);
		this.setBackground(Color.red);
		this.setLayout(null);
		
		JPanel unPanel = new JPanel(); 
		unPanel.setBounds(20, 200, 680, 100);
		unPanel.setLayout(new GridLayout(3, 4));

		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel("Id Chauffeur :")); 
		unPanel.add(txtidChauff);
		unPanel.add(new JLabel(""));
		this.txtidChauff.setEditable(false);
		//////////////////////////////////////////////////////////
		unPanel.add(new JLabel("Nom : ")); 
		unPanel.add(this.txtNomchau);
		unPanel.add(new JLabel("Prenom : ")); 
		unPanel.add(this.txtPrenomchau);
		unPanel.add(new JLabel("Tel : ")); 
		unPanel.add(this.txtTelchau);  
		unPanel.add(new JLabel ("Libre : "));
		unPanel.add(this.txtLibre);  
		
		
		unPanel.add(this.btAjouter);
		unPanel.add(this.btSupprimer);
		unPanel.add(this.btEditer);
		unPanel.add(new JLabel(""));
				
		unPanel.setVisible(true);
		this.add(unPanel); 
		//rendre les boutons cliquables 
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btEditer.addActionListener(this);
		//construction de la Jtable 
		String entete [] = {"ID chauffeur","Nom du chauffeur", "Prenom du chauffeur", "Téléphone du chauffeur", "Libre ?"};
		Object [][] lesDonnees = remplirDonnees ();
		
		//gestion de la Jtable avec le Tableau.
		unTableau = new Tableau(lesDonnees, entete);
 		this.tableChauffeurs = new JTable (unTableau);
 		
 		
 		//ajouter l'evenement clic sur la table MouseListener 
 		this.tableChauffeurs.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 int ligne = tableChauffeurs.getSelectedRow(); 
				 txtidChauff.setText(tableChauffeurs.getValueAt(ligne, 0).toString());
				 txtNomchau.setText(tableChauffeurs.getValueAt(ligne, 1).toString());
				 txtPrenomchau.setText(tableChauffeurs.getValueAt(ligne, 2).toString());
				 txtTelchau.setText(tableChauffeurs.getValueAt(ligne, 3).toString());
				 txtLibre.setText(tableChauffeurs.getValueAt(ligne, 4).toString());
				 
			}
		});
 		
 		
 		JScrollPane uneScroll = new JScrollPane(tableChauffeurs); 
 		uneScroll.setBounds(20, 20, 680, 150);
 		this.add(uneScroll);
 		
		this.setVisible(false);
	}

	private Object[][] remplirDonnees() {
		ArrayList<Chauffeur> lesChauffeurs = Modele.selectAllChauffeur();
		Object [][] lesDonnees = new Object[lesChauffeurs.size()][5];
		int i = 0 ;
		for (Chauffeur unChauffeur : lesChauffeurs)
		{
			lesDonnees[i][0] = unChauffeur.getIdchauf() + ""; 
			lesDonnees[i][1] = unChauffeur.getNomchauf(); 
			lesDonnees[i][2] = unChauffeur.getPrenomchauf();
			lesDonnees[i][3] = unChauffeur.getTelchauf();
			lesDonnees[i][4] = unChauffeur.getLibre();
			i++;
		}
	return lesDonnees; 
}

@Override
public void actionPerformed(ActionEvent e) {
	 switch (e.getActionCommand())
	 {
	 case "Ajouter" :
	 {
		 String Nomchau= this.txtNomchau.getText();
		 String Prenomchau = this.txtPrenomchau.getText();
		 String Telchau = this.txtTelchau.getText();
		 String Libre = this.txtLibre.getText();
		 //insertion dans la base de données table client. 18h15.
		 //on cree une instance de la classe Client 
		 if (Nomchau.equals("") || Telchau.equals(""))
		 {
			 JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
		 }
		 else{
			 Chauffeur unChauffeur = new Chauffeur (Nomchau,Prenomchau,Telchau,Libre); 
			 Modele.insertChauffeur(unChauffeur);
			 JOptionPane.showMessageDialog(this, "Chauffeur inséré avec succès !");
			 //mise a jour de la Jtable 
			 Chauffeur leChauffeur = Modele.selectWhereC(unChauffeur);
			 
			 Object ligne [] = {leChauffeur.getIdchauf(), 
					 leChauffeur.getNomchauf(), leChauffeur.getPrenomchauf(),leChauffeur.getTelchauf(), leChauffeur.getLibre()};
			 
			 //appel de la méthode pour ajouter cette ligne dans la table. 
			 unTableau.add(ligne);
			 
			 
			 this.txtTelchau.setText("");
			 
		 }
	 }
		 break;
	 case "Supprimer" :
	 {  
		 String nomchau=txtNomchau.getText();
		 String prenomchau=txtPrenomchau.getText();
		 String telchau = txtTelchau.getText(); 
		 String libre = txtLibre.getText(); 
		  
		
		 if (txtidChauff.getText().equals("") || nomchau.equals("") || telchau.equals(""))
		 {
			 JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
		 }
		 else{
			 int idChauff  = Integer.parseInt(txtidChauff.getText());
			 Chauffeur unChauffeur = new Chauffeur(idChauff, nomchau, prenomchau, telchau, libre); 
			 Modele.deleteChauffeur(unChauffeur);
			 JOptionPane.showMessageDialog(this, "Suppression réussie");
			
			 int rowIndex = this.tableChauffeurs.getSelectedRow();
			 unTableau.delete(rowIndex);
			 
			 txtidChauff.setText("");
			 txtNomchau.setText("");
			 txtPrenomchau.setText("");
			 txtTelchau.setText("");
			 txtLibre.setText("");
		 }
	 }
	 break; 
	 case "Editer" : 
	 {
		 String nomchau= txtNomchau.getText();
		 String prenomchau= txtPrenomchau.getText();
		 String telchau = txtTelchau.getText(); 
		 String libre = txtLibre.getText();
		 if (txtidChauff.getText().equals("") || nomchau.equals("") || prenomchau.equals("") || telchau.equals("") || libre.equals(""))
		 {
			 JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
		 }
		 else{
			 int idChauff = Integer.parseInt(txtidChauff.getText()); 
			 Chauffeur leChauffeur = new Chauffeur(idChauff, nomchau, prenomchau, telchau, libre); 
			 Modele.updateChauffeur(leChauffeur);
			 JOptionPane.showMessageDialog(this, "Mise à jour réussie");
			 
			 Object ligne [] = {leChauffeur.getIdchauf(), 
					 leChauffeur.getNomchauf(), leChauffeur.getPrenomchauf(),leChauffeur.getTelchauf(), leChauffeur.getLibre()};
			 int rowIndex = this.tableChauffeurs.getSelectedRow();
			 unTableau.update(rowIndex, ligne);
			 
			 txtidChauff.setText("");
			 txtNomchau.setText("");
			 txtTelchau.setText("");
			 txtLibre.setText("");
		 }
	 }
	 break;
	 }
	
}
	
	
	
	
	
	
	
	
	
	
	
	public JButton getBtAjouter() {
	return btAjouter;
}

public void setBtAjouter(JButton btAjouter) {
	this.btAjouter = btAjouter;
}

public JButton getBtSupprimer() {
	return btSupprimer;
}

public void setBtSupprimer(JButton btSupprimer) {
	this.btSupprimer = btSupprimer;
}

public JButton getBtEditer() {
	return btEditer;
}

public void setBtEditer(JButton btEditer) {
	this.btEditer = btEditer;
}

public JTextField getTxtidChauff() {
	return txtidChauff;
}

public void setTxtidChauff(JTextField txtidChauff) {
	this.txtidChauff = txtidChauff;
}

public JTextField getTxtNomchau() {
	return txtNomchau;
}

public void setTxtNomchau(JTextField txtNomchau) {
	this.txtNomchau = txtNomchau;
}

public JTextField getTxtPrenomchau() {
	return txtPrenomchau;
}

public void setTxtPrenomchau(JTextField txtPrenomchau) {
	this.txtPrenomchau = txtPrenomchau;
}

public JTextField getTxtTelchau() {
	return txtTelchau;
}

public void setTxtTelchau(JTextField txtTelchau) {
	this.txtTelchau = txtTelchau;
}

public JTextField getTxtLibre() {
	return txtLibre;
}

public void setTxtLibre(JTextField txtLibre) {
	this.txtLibre = txtLibre;
}

public JTable getTableChauffeurs() {
	return tableChauffeurs;
}

public void setTableChauffeurs(JTable tableChauffeurs) {
	this.tableChauffeurs = tableChauffeurs;
}

public Tableau getUnTableau() {
	return unTableau;
}

public void setUnTableau(Tableau unTableau) {
	this.unTableau = unTableau;
}

}