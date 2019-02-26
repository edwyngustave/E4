package controleur;

import javax.swing.table.AbstractTableModel; 

public class Tableau extends AbstractTableModel 
{
	private Object [][] donnees ; //matrice des données 
	private String [] entete ; //entete de la table
	
	//le constructeur 
	public Tableau (Object [][] donnees , String [] entete)
	{
		this.donnees =  donnees; 
		this.entete = entete ; 
	}
	
	public Object[][] getDonnees() {
		return donnees;
	}

	public void setDonnees(Object[][] donnees) {
		this.donnees = donnees;
	}

	public String[] getEntete() {
		return entete;
	}

	public void setEntete(String[] entete) {
		this.entete = entete;
	}

	@Override
	public int getColumnCount() {
		 // le nombre de colonnes du tableau entete
		return this.entete.length;
	}

	@Override
	public int getRowCount() {
		// le nombre de lignes : le nombre de lignes de la matrice donnees
		return this.donnees.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// prendre la valeur au croisement de la ligne / colonne 
		return this.donnees[rowIndex][columnIndex];
	}

	public void add(Object ligne[])
	{
		//cette methode recoit une ligne et l'ajoute a la matrice données
		Object newTable [][] = new Object [this.donnees.length + 1][this.entete.length];
		//on recopie la matrice donnees dans la nouvelle newTable
		for (int i = 0; i < this.donnees.length ; i++)
		{
			newTable[i]  = this.donnees[i];
		}
		//on ajoute la ligne dans la nouvelle matrice
		newTable[this.donnees.length] = ligne; 
		//on recopie la nouvelle matrice dans donnees 
		this.donnees = newTable ;
		//on confirme les changements 
		this.fireTableDataChanged();
		
	}
	public void delete (int rowIndex)
	{
		//cette methode supprime la ligne dont le numero est roxIndex
		Object newTable [][] = new Object [this.donnees.length - 1][this.entete.length];
		int j = 0; 
		for (int i = 0; i < this.donnees.length ; i++)
		{
			if(rowIndex != i){ 
					newTable[j]  = this.donnees[i];
					j++;
				}
		}
		//on recopie la nouvelle matrice dans donnees 
		this.donnees = newTable ;
		//on confirme les changements 
		this.fireTableDataChanged();
	}
	
	public void update (int rowIndex, Object ligne[])
	{
		//cette methode met a jour une ligne du tableau.
		Object newTable [][] = new Object [this.donnees.length][this.entete.length];
		 
		for (int i =0 ;i< this.donnees.length ; i++)
		{
			if( rowIndex == i)
			{
				newTable[i] = ligne; 
			}else  {
				newTable[i] = this.donnees[i];
			}
		}
		//on recopie la nouvelle matrice dans donnees 
		this.donnees = newTable ;
		//on confirme les changements 
		this.fireTableDataChanged();
		
	}
	public String getColumnName(int column )
	{
		return this.entete[column];
	}
}












