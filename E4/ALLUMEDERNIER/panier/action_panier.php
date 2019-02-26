<?php
if(!empty($_GET["action"])) {
switch($_GET["action"]) {
	//AJOUTER
	case "add":
		if(!empty($_POST["quantité"])) {
			$productBycode_art = $db_handle->runQuery("SELECT * FROM article WHERE code_art='" . $_GET["code_art"] . "'");
			$itemArray = array($productBycode_art[0]["code_art"]=>array('nom_art'=>$productBycode_art[0]["nom_art"],
			'code_art'=>$productBycode_art[0]["code_art"], 'quantité'=>$_POST["quantité"], 'prix_art'=>$productBycode_art[0]["prix_art"]));
			
			if(!empty($_SESSION["cart_item"])) {
				if(in_array($productBycode_art[0]["code_art"],array_keys($_SESSION["cart_item"]))) {
					foreach($_SESSION["cart_item"] as $k => $v) {
							if($productBycode_art[0]["code_art"] == $k) {
								if(empty($_SESSION["cart_item"][$k]["quantité"])) {
									$_SESSION["cart_item"][$k]["quantité"] = 0;
								}
								$_SESSION["cart_item"][$k]["quantité"] += $_POST["quantité"];
							}
					}
				} else {
					$_SESSION["cart_item"] = array_merge($_SESSION["cart_item"],$itemArray);
				}
			} else {
				$_SESSION["cart_item"] = $itemArray;
			}
		}
	break;
	//SUPPRIMER
	case "remove":
		if(!empty($_SESSION["cart_item"])) {
			foreach($_SESSION["cart_item"] as $k => $v) {
					if($_GET["code_art"] == $k)
						unset($_SESSION["cart_item"][$k]);				
					if(empty($_SESSION["cart_item"]))
						unset($_SESSION["cart_item"]);
			}
		}
	break;
	//REINITIALISER	
	case "empty":
		unset($_SESSION["cart_item"]);
	break;	
		
}
}

/*Quand il se connecte 
	Si le panier (cart_item ) non vide
		Alors Récupérer le panier du client (panier_id)
		Lire le panier de la session (cart_item)
			Pour chaque item dans le panier faire un insert dans la table Panier_article avec comme clée le panier_id et l'article_id
	Sinon 
		1. Videz la table panier_article du panier_id du client_id
		2. Récupérer le panier du client */
?>


