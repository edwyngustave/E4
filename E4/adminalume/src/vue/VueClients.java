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

import controleur.Client;
import controleur.Tableau;
import modele.Modele;

public class VueClients extends JPanel implements ActionListener
{
	private JButton btAjouter = new JButton("Ajouter"); 
	private JButton btSupprimer= new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	private JTextField txtNom = new JTextField(); 
	private JTextField txtAdresse = new JTextField(); 
	private JTextField txtIdclient = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtMail = new JTextField(); 
	private JTextField txtTelcli = new JTextField(); 
	private JTextField txtCpcli = new JTextField(); 
	private JTextField txtMdp = new JTextField(); 
	
	private JTable tableClients  ; 
	private Tableau unTableau ; //modele de tableau pour gerer la Jtable.
	
	public VueClients()
	{
		this.setBounds(20, 70 , 780 , 380);
		this.setBackground(Color.blue);
		this.setLayout(null);
		
		JPanel unPanel = new JPanel(); 
		unPanel.setBounds(20, 200, 680 , 100);
		unPanel.setLayout(new GridLayout(3, 8, 5, 5));

		
		unPanel.add(new JLabel("Id Client :")); 
		unPanel.add(txtIdclient);
		this.txtIdclient.setEditable(false);
		//////////////////////////////////////////////////////////
		unPanel.add(new JLabel("Mail : ")); 
		unPanel.add(this.txtMail);
		unPanel.add(new JLabel("Mdp : ")); 
		unPanel.add(this.txtMdp);
		unPanel.add(new JLabel("Nom : ")); 
		unPanel.add(this.txtNom);  
		unPanel.add(new JLabel ("Prenom : "));
		unPanel.add(this.txtPrenom);  
		unPanel.add(new JLabel("Tel : ")); 
		unPanel.add(this.txtTelcli);
		unPanel.add(new JLabel("Adresse : "));
		unPanel.add(this.txtAdresse);
		unPanel.add(new JLabel("CP : ")); 
		unPanel.add(this.txtCpcli);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(""));
		unPanel.add(this.btAjouter);
		unPanel.add(this.btSupprimer);
		unPanel.add(this.btEditer);
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(""));

				
		unPanel.setVisible(true);
		this.add(unPanel); 
		//rendre les boutons cliquables 
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btEditer.addActionListener(this);
		//construction de la Jtable 
		String entete [] = {"ID Client","Mail du client", "Mdp du client", "Nom du client", "Prenom du client ", "Tel du client", "Adresse Client", "CP client"};
		Object [][] lesDonnees = remplirDonnees ();
		
		//gestion de la Jtable avec le Tableau.
		unTableau = new Tableau(lesDonnees, entete);
 		this.tableClients = new JTable (unTableau);
 		
 		
 		//ajouter l'evenement clic sur la table MouseListener 
 		this.tableClients.addMouseListener(new MouseListener() {
			
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
				 int ligne = tableClients.getSelectedRow(); 
				 txtIdclient.setText(tableClients.getValueAt(ligne, 0).toString());
				 txtMail.setText(tableClients.getValueAt(ligne, 1).toString());
				 txtMdp.setText(tableClients.getValueAt(ligne, 2).toString());
				 txtNom.setText(tableClients.getValueAt(ligne, 3).toString());
				 txtPrenom.setText(tableClients.getValueAt(ligne, 4).toString());
				 txtTelcli.setText(tableClients.getValueAt(ligne, 5).toString());
				 txtAdresse.setText(tableClients.getValueAt(ligne, 6).toString());
				 txtCpcli.setText(tableClients.getValueAt(ligne, 7).toString());
				 
				 
			}
		});
 		
 		
 		JScrollPane uneScroll = new JScrollPane(tableClients); 
 		uneScroll.setBounds(20, 20, 680, 150);
 		this.add(uneScroll);
 		
		this.setVisible(false);
	}


	private Object[][] remplirDonnees() {
			ArrayList<Client> lesClients = Modele.selectAllClients();
			Object [][] lesDonnees = new Object[lesClients.size()][8];
			int i = 0 ;
			for (Client unClient : lesClients)
			{
				lesDonnees[i][0] = unClient.getIdclient() + ""; 
				lesDonnees[i][1] = unClient.getMail(); 
				lesDonnees[i][2] = unClient.getMdp();
				lesDonnees[i][3] = unClient.getNom();
				lesDonnees[i][4] = unClient.getPrenom();
				lesDonnees[i][5] = unClient.getTelcli();
				lesDonnees[i][6] = unClient.getAdresse();
				lesDonnees[i][7] = unClient.getCpcli();
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
			 String mail= this.txtMail.getText();
			 String mdp = this.txtMdp.getText();
			 String nom = this.txtNom.getText();
			 String prenom = this.txtPrenom.getText();
			 String telcli= this.txtTelcli.getText();
			 String adresse = this.txtAdresse.getText(); 
			 String cpcli= this.txtCpcli.getText();
			 //insertion dans la base de données table client. 18h15.
			 //on cree une instance de la classe Client 
			 if (nom.equals("") || adresse.equals(""))
			 {
				 JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
			 }
			 else{
				 Client unClient = new Client (mail, mdp, nom, prenom, telcli, adresse, cpcli); 
				 Modele.insertClient(unClient);
				 JOptionPane.showMessageDialog(this, "Client inséré avec succès !");
				 //mise a jour de la Jtable 
				 unClient = Modele.selectWhere(unClient);
				 
				 Object ligne [] = {unClient.getIdclient(),unClient.getMail(), unClient.getMdp(),
						 unClient.getNom(),unClient.getPrenom(),unClient.getTelcli(), unClient.getAdresse(), 
						 unClient.getCpcli()
						 };

				 //appel de la méthode pour ajouter cette ligne dans la table. 
				 unTableau.add(ligne);
				 
				 
				 this.txtAdresse.setText("");
				 
			 }
		 }
			 break;
		 case "Supprimer" :
		 {  
			 String mail=txtMail.getText();
			 String mdp=txtMdp.getText();
			 String nom = txtNom.getText(); 
			 String prenom = txtPrenom.getText(); 
			 String telcli = txtTelcli.getText(); 
			 String adresse = txtAdresse.getText();
			 String cpcli= txtCpcli.getText(); 
			 
			 if (txtIdclient.getText().equals("") || nom.equals("") || adresse.equals(""))
			 {
				 JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
			 }
			 else{
				 int idclient  = Integer.parseInt(txtIdclient.getText());
				 Client unClient = new Client(idclient, mail, mdp, nom, prenom, telcli, adresse, cpcli); 
				 Modele.deleteClient(unClient);
				 JOptionPane.showMessageDialog(this, "Suppression réussie");
				
				 int rowIndex = this.tableClients.getSelectedRow();
				 unTableau.delete(rowIndex);
				 
				 txtIdclient.setText("");
				 txtMail.setText("");
				 txtMdp.setText("");
				 txtPrenom.setText("");
				 txtNom.setText("");
				 txtTelcli.setText("");
				 txtAdresse.setText("");
				 txtCpcli.setText("");
			 }
		 }
		 break; 
		 case "Editer" : 
		 {
			 String mail= txtMail.getText();
			 String mdp= txtMdp.getText();
			 String nom = txtNom.getText(); 
			 String prenom = txtPrenom.getText();
			 String telcli = txtTelcli.getText();
			 String adresse = txtAdresse.getText();
			 String cpcli = txtCpcli.getText();
			 if (txtIdclient.getText().equals("") || nom.equals("") || adresse.equals("") || prenom.equals("") || mail.equals("") || mdp.equals("") || telcli.equals("") || cpcli.equals("")    )
			 {
				 JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
			 }
			 else{
				 int idclient  = Integer.parseInt(txtIdclient.getText()); 
				 Client unClient = new Client(idclient, mail, mdp, nom, prenom, telcli, adresse, cpcli); 
				 Modele.updateClient(unClient);
				 JOptionPane.showMessageDialog(this, "Mise à jour réussie");
				 
				 Object ligne [] = {unClient.getIdclient(),unClient.getMail(), unClient.getMdp(),
						 unClient.getNom(),unClient.getPrenom(),unClient.getTelcli(), unClient.getAdresse(), 
						 unClient.getCpcli()
						 };

				 int rowIndex = this.tableClients.getSelectedRow();
				 unTableau.update(rowIndex, ligne);
				 
				 txtIdclient.setText("");
				 txtNom.setText("");
				 txtAdresse.setText("");
			 }
		 }
		 break;
		 }
		
	}


	public JTextField getTxtPrenom() {
		return txtPrenom;
	}


	public void setTxtPrenom(JTextField txtPrenom) {
		this.txtPrenom = txtPrenom;
	}


	public JTextField getTxtMail() {
		return txtMail;
	}


	public void setTxtMail(JTextField txtMail) {
		this.txtMail = txtMail;
	}


	public JTextField getTxtTelcli() {
		return txtTelcli;
	}


	public void setTxtTelcli(JTextField txtTelcli) {
		this.txtTelcli = txtTelcli;
	}


	public JTextField getTxtCpcli() {
		return txtCpcli;
	}


	public void setTxtCpcli(JTextField txtCpcli) {
		this.txtCpcli = txtCpcli;
	}


	public JTextField getTxtMdp() {
		return txtMdp;
	}


	public void setTxtMdp(JTextField txtMdp) {
		this.txtMdp = txtMdp;
	}

}
