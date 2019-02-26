<?php
session_start();
require_once("dbcontroller.php");
$db_handle = new DBController();
require_once('action_panier.php');
?>

<?php
	include '../menu_panier.php';
 ?>


<HTML>
<HEAD>
<TITLE>Panier</TITLE>
<link href="../default.css" type="text/css" rel="stylesheet" />
</HEAD>
<BODY>
<!-- STRUCTURE DU PANIER -->
<div id="shopping-cart">
<div class="txt-heading">Mon Panier <a id="btnEmpty" href="index.php?action=empty">Vider le panier</a></div>
<center><a href="../article.php" style="margin: 100px 100px; color: black; font-size: 125%;">Continuer mes achats</a></center>
	<?php include('panier.php');?>
</div>



<form method = "post" action="">
<input type="submit" name="cmd" value="Je commande ! "> 
</form>

<?php 

if (isset($_POST['cmd']))
{
	//var_dump($_SESSION);
	
if (isset($_SESSION['id_cli']))
{
	//print_r($_SESSION['cart_item']);

	$id_client = $_SESSION['id_cli'];
	    
	if (isset($_SESSION["cart_item"]))
	{
		$unDBC = new DBController();
		$unDBC->connectDB();
		$unDBC->insertPanier($_SESSION["cart_item"], $id_client);
	}
}else {
	echo 	"<center><a href='../espace_membre/connexion.php' style='padding: 10px 10px; color: red; font-size: 150%;'>Veuillez vous connecter svp !</a></center>"; 
				
			
}
}
?>
<!-- FIN DE LA STRUCTURE DU PANIER -->
<?php
 include '../footer_panier.php';
 ?>

</BODY>
</HTML>
