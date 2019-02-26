<?php
class DBController {
	private $host = "localhost";
	private $user = "root";
	private $password = "";
	private $database = "alume";
	private $conn = null;

	function __construct() {
		$this->conn = $this->connectDB();
	}

	function connectDB() {
		$conn = mysqli_connect($this->host,$this->user,$this->password,$this->database);
		return $conn;
	}

	function runQuery($query) {
		$result = mysqli_query($this->conn,$query);
		while($row=mysqli_fetch_assoc($result)) {
			$resultset[] = $row;
		}
		if(!empty($resultset))
		{	return $resultset;}
	}

	function numRows($query) {
		$result  = mysqli_query($this->conn,$query);
		$rowcount = mysqli_num_rows($result);
		return $rowcount;
	}

	function insertPanier ($panier, $id_client)
	{
		if ($this->conn !=null)
			{
			$query ="insert into commandec values (null, now(), ".$id_client.");"; 
			 
			$result  = mysqli_query($this->conn,$query);
			
		

			//requete pour connaitre l'id de la commande créee maintenant 

			
			$query ="select id_commandc  from commandec where id_cli  = ".$id_client." and date_commandc = curdate()"; 
			$result = mysqli_query($this->conn,$query);
			$row=mysqli_fetch_assoc($result);
			$id_commande  = $row['id_commandc'];
			//echo $id_commande;
				//insertion dans la ligne de commandes toutes les lignes du panier 
		foreach ($panier as $ligne) {
			
				$query ="insert into ligne_commande_client values (null,'".$ligne['code_art']."','".$ligne['nom_art']."', ".$ligne['quantité'].",".$id_commande.",".$ligne['prix_art'].") "; 
				
					$result  = mysqli_query($this->conn,$query);
				}
			echo 	"<center><a href='../index.php' style='text-decoration: none; padding: none; color: green; font-size: 150%;'>Votre commande est bien passée !</br>Votre agent préféré vous recontactera dés que possible. </br></br>______</a></center>"; 

		}
	}
}
?>
