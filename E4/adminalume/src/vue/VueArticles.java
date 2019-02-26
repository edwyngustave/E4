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

import controleur.Article;
import controleur.Tableau;
import modele.Modele;

public class VueArticles extends JPanel implements ActionListener {

	private JButton btAjouter = new JButton("Ajouter");   // ON DECLARE LES BUTTONS
	private JButton btSupprimer= new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	
	private JTextField txtcode_art = new JTextField();  // on declare les zone de txt
	private JTextField txtnoma = new JTextField(); 
	private JTextField txtprixa = new JTextField(); 
	private JTextField txtqte = new JTextField(); 
	
	private JTable tableArticles;
	private Tableau unTableau; 
	
	public VueArticles()   // le design
	{
		this.setBounds(20, 70 , 780 , 380);
		this.setBackground(Color.green);
		this.setLayout(null);
		
		JPanel unPanel = new JPanel(); 
		unPanel.setBounds(20, 200, 680, 100);
		unPanel.setLayout(new GridLayout(3, 4, 10, 10));

		
		unPanel.add(new JLabel("Code_article :")); 
		unPanel.add(txtcode_art);
		//unPanel.add(new JLabel(""));
		unPanel.add(new JLabel("Nom : ")); 
		unPanel.add(this.txtnoma);
		unPanel.add(new JLabel("Prix : ")); 
		unPanel.add(this.txtprixa);
		unPanel.add(new JLabel("Quantite : ")); 
		unPanel.add(this.txtqte);
		
		unPanel.add(new JLabel(""));
		unPanel.add(this.btAjouter);
		unPanel.add(this.btSupprimer);
		unPanel.add(this.btEditer);
		
		
		unPanel.setVisible(true);
		this.add(unPanel); 
		//rendre les boutons cliquables 
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btEditer.addActionListener(this);
		//construction de la Jtable 
		String entete [] = {"Code de l'article","Nom de l'article", "Prix de l'article", "Quantite"};
		Object [][] lesDonnees = remplirDonnees ();
		
		//gestion de la Jtable avec le Tableau.
		unTableau = new Tableau(lesDonnees, entete);
 		this.tableArticles = new JTable (unTableau);
 		
 		
 		//ajouter l'evenement clic sur la table MouseListener 
 		this.tableArticles.addMouseListener(new MouseListener() {
			
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
				 int ligne = tableArticles.getSelectedRow(); 
				 txtcode_art.setText(tableArticles.getValueAt(ligne, 0).toString());
				 txtnoma.setText(tableArticles.getValueAt(ligne, 1).toString());
				 txtprixa.setText(tableArticles.getValueAt(ligne, 2).toString());
				 txtqte.setText(tableArticles.getValueAt(ligne, 3).toString());
			}
		});
 		JScrollPane uneScroll = new JScrollPane(tableArticles); 
 		uneScroll.setBounds(20, 20, 680, 150);
 		this.add(uneScroll);
 		
		this.setVisible(false);
	}
	
	private Object[][] remplirDonnees() {
		ArrayList<Article> lesArticles = Modele.selectAllArticle();
		Object [][] lesDonnees = new Object[lesArticles.size()][4];
		int i = 0 ;
		for (Article unArticle : lesArticles)
		{
			lesDonnees[i][0] = unArticle.getCode_art(); 
			lesDonnees[i][1] = unArticle.getNoma(); 
			lesDonnees[i][2] = unArticle.getPrixa();
			lesDonnees[i][3] = unArticle.getQte();
			i++;
		}
	return lesDonnees; }

	@Override
	public void actionPerformed(ActionEvent e) {
		 switch (e.getActionCommand())
		 {
		 case "Ajouter" :
		 {
			 String codea = this.txtcode_art.getText();
			 String noma= this.txtnoma.getText();
			 String prixa = this.txtprixa.getText();
			 String qte = this.txtqte.getText();
			 //insertion dans la base de données table client. 
			 //on cree une instance de la classe Client 
			 if (noma.equals("") || prixa.equals(""))
			 {
				 JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
			 }
			 else{
				 Article unArticle = new Article (codea,noma, prixa, qte); 
				 Modele.insertArticle(unArticle);
				 JOptionPane.showMessageDialog(this, "Article inséré avec succès !");
				 //mise a jour de la Jtable 
				 Article lArticle = Modele.selectWhereA(unArticle);
				 
				 Object ligne [] = {lArticle.getCode_art(), 
						 lArticle.getNoma(), lArticle.getPrixa(), lArticle.getQte()};
				 
				 //appel de la méthode pour ajouter cette ligne dans la table. 
				unTableau.add(ligne);
				 
				 this.txtcode_art.setText("");	 
			 }
		 }
		 break;
		 case "Supprimer" :
		 {  
			 String code_art=txtcode_art.getText();
			 String noma=txtnoma.getText();
			 String prixa = txtprixa.getText(); 
			 String qte = txtqte.getText();
			 
			 
			 if (txtcode_art.getText().equals("") || noma.equals("") || prixa.equals("") || qte.equals(""))
			 {
				 JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
			 }
			 else{
				 
				 Article unArticle = new Article(code_art, noma,  prixa, qte); 
				 Modele.deleteArticle(unArticle);
				 JOptionPane.showMessageDialog(this, "Suppression réussie");
				
				 int rowIndex = this.tableArticles.getSelectedRow();
				 unTableau.delete(rowIndex);
				 
				 txtcode_art.setText("");
				 txtnoma.setText("");
				 txtprixa.setText("");
				 txtqte.setText("");
		
			 }
		 }
		 break; 
		 case "Editer" : 
		 {
			 String code_art= txtcode_art.getText();
			 String noma= txtnoma.getText();
			 String prixa = txtprixa.getText(); 
			 String qte = txtqte.getText(); 
			 if (txtcode_art.getText().equals("") || noma.equals("") || prixa.equals("") || qte.equals(""))
			 {
				 JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
			 }
			 else{
				 
				 Article unArticle = new Article(code_art, noma, prixa, qte); 
				 Modele.updateArticle(unArticle);
				 JOptionPane.showMessageDialog(this, "Mise à jour réussie");
				 
				 Object ligne[] = {unArticle.getCode_art(), unArticle.getNoma(), 
						 unArticle.getPrixa(), unArticle.getQte()};
				 int rowIndex = this.tableArticles.getSelectedRow();
				 unTableau.update(rowIndex, ligne);
				 
				 txtcode_art.setText("");
				 txtnoma.setText("");
				 
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


	public JTextField getTxtcode_art() {
		return txtcode_art;
	}
	public void setTxtcode_art(JTextField txtcode_art) {
		this.txtcode_art = txtcode_art;
	}

	public JTextField getTxtnoma() {
		return txtnoma;
	}

	public void setTxtnoma(JTextField txtnoma) {
		this.txtnoma = txtnoma;
	}


	public JTextField getTxtprixa() {
		return txtprixa;
	}

	public void setTxtprixa(JTextField txtprixa) {
		this.txtprixa = txtprixa;
	}

	public JTable getTableArticles() {
		return tableArticles;
	}

	public void setTableArticles(JTable tableArticles) {
		this.tableArticles = tableArticles;
	}

	public Tableau getUnTableau() {
		return unTableau;
	}

	public void setUnTableau(Tableau unTableau) {
		this.unTableau = unTableau;
	}

	public JTextField getTxtqte() {
		return txtqte;
	}

	public void setTxtqte(JTextField txtqte) {
		this.txtqte = txtqte;
	}
	
	
}