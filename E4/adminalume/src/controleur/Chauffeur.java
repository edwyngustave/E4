package controleur;

public class Chauffeur // OBJET CHAUFFEURS 3 DIFFERENTES FACON ECRITE POUR DIFFERENTES UTILISATIONS
{
private int idchauf;
private String nomchauf,prenomchauf,telchauf,libre ;


public Chauffeur ()
{
	this.idchauf = 0;
	this.nomchauf ="";
	this.prenomchauf="";
	this.telchauf="";
	this.libre=""; 
}

public Chauffeur (String nomchauf, String prenomchauf, String telchauf, String libre)
{
	this.idchauf = 0;
	this.nomchauf =nomchauf;
	this.prenomchauf=prenomchauf;
	this.telchauf=telchauf;
	this.libre=libre; 
}



public Chauffeur (int idchauf, String nomchauf, String prenomchauf, String telchauf, String libre)
{
	this.idchauf = idchauf;
	this.nomchauf =nomchauf;
	this.prenomchauf=prenomchauf;
	this.telchauf=telchauf;
	this.libre=libre; 
}


// GETTERS ET SETTERS : FONCTIONS POUR RECUPERER LES OBJETS DE CETTE PAGE VERS UNE AUTRE

public String getNomchauf() {
	return nomchauf;
}



public void setNomchauf(String nomchauf) {
	this.nomchauf = nomchauf;
}



public String getPrenomchauf() {
	return prenomchauf;
}



public void setPrenomchauf(String prenomchauf) {
	this.prenomchauf = prenomchauf;
}



public String getTelchauf() {
	return telchauf;
}



public void setTelchauf(String telchauf) {
	this.telchauf = telchauf;
}


public int getIdchauf() {
	return idchauf;
}



public void setIdchauf(int idchauf) {
	this.idchauf = idchauf;
}

public String getLibre() {
	return libre;
}



public void setLibre(String libre) {
	this.libre = libre;
}


}