package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Main;
import modele.Modele;

public class VueConnexion extends JFrame implements ActionListener, KeyListener 
{
	private JPanel unPanel = new JPanel(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btSeConnecter = new JButton("Se Connecter"); 
	private JTextField txtLogin = new JTextField(); //zone de saisie de texte
	private JPasswordField pwMdp = new JPasswordField(); //zone de saisie de MDP
	
	public VueConnexion() {
		this.setTitle("Logiciel de gestion des Stocks ");
		this.setBounds(200, 200, 500, 350);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.yellow);
		//construction du panel 
		this.unPanel.setBounds(50, 150, 400, 150);
		this.unPanel.setLayout(new GridLayout(3, 2));
		this.unPanel.setBackground(new Color(201,200,20));
	
		this.unPanel.add(new JLabel("Login  : "));
		this.unPanel.add(this.txtLogin); 
		this.unPanel.add(new JLabel("MDP : ")); 
		this.unPanel.add(this.pwMdp); 
		Font  f  = new Font(Font.DIALOG,  Font.BOLD, 20);
		this.btSeConnecter.setFont(f);
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btSeConnecter);
		
		this.unPanel.setVisible(true);
		this.add(this.unPanel);
		
		//ajout du logo 
		ImageIcon logo = new ImageIcon("src/images/piscine.jpg");
		JLabel lbLogo = new JLabel(logo); 
		lbLogo.setBounds(50, 20, 400, 120);
		this.add(lbLogo);
		//changer le logo de l'application
		ImageIcon logopetit = new ImageIcon("src/images/logopetit.png");
		this.setIconImage(logopetit.getImage());
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		//rendre les zones de texte ecoutables avec la touche entree 
		this.txtLogin.addKeyListener(this);
		this.pwMdp.addKeyListener(this);
		
		this.setVisible(true); //rendre visible la fenetre principale
	}
	
	public void traitement()
	{
		String login = this.txtLogin.getText(); 
		String mdp = new String (this.pwMdp.getPassword());
		if (login.equals("") || mdp.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Veuillez saisir vos identifiants");
		}else{
			//on verifie dans la BDD la connexion. 
			String droits = Modele.verifConnexion(login, mdp);
			if(droits.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Erreur de connexion",
						"Erreur", JOptionPane.ERROR_MESSAGE);
				this.txtLogin.setText("");
				this.pwMdp.setText("");
			}
			else {
				JOptionPane.showMessageDialog(this,"Bienvenue  !", 
						"Connexion réussie", JOptionPane.INFORMATION_MESSAGE);
				//lancement de la jframe principale 
				Main.rendreVisible(false);
				new VueGenerale();
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 switch (e.getActionCommand())
		 {
		 case "Annuler" : 
			 this.txtLogin.setText("");
			 this.pwMdp.setText("");
			 break; 
		
		 case "Se Connecter" :
			 traitement();
			 break;
		 }
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		 
		if (e.getKeyChar() == KeyEvent.VK_ENTER) //test de la touche entree
		{
			traitement();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		 
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

} 
