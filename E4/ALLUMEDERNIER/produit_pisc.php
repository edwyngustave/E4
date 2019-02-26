<?php

	$db_handle = new DBController();
?>

<div id="product-grid">
	<div class="txt-heading">
	<a href=?piscines=piscines style='text-decoration: none; padding: 30px;'> Piscines </a>	
	<a href=?fenetres=fenetres style='text-decoration: none; padding: 30px;'> Fenêtres </a>
	<a href=?portes=portes style='text-decoration: none; padding: 30px;'> Portes </a>

	</div>
<!-- FILTRE TYPE DARTICLE -->
	<?php
	if (isset($_GET['piscines']))
	{
		$chaine = " where code_art like 'pisc_%' " ;
	}
	elseif (isset($_GET['fenetres']))
	{
		$chaine = " where code_art like 'fen_%' " ;
	}
	elseif (isset($_GET['portes']))
	{
		$chaine = " where code_art like 'port_%' " ;
	}
	else 
	{
		$chaine ="";
	}

	$req = "SELECT * FROM article ". $chaine ." ORDER BY code_art ASC"; 

	$product_array = $db_handle->runQuery($req);
	if (!empty($product_array)) {
		foreach($product_array as $key=>$value){
	?>
<!-- FIN FILTRE TYPE DARTICLE -->

<!-- AFFICHAGE DES ARTICLES -->
		<div class="product-item">
			<form method="post" action="panier/index.php?action=add&code_art=<?php echo $product_array[$key]["code_art"]; ?>">
			<div class="product-image">
				<img src="<?php echo $product_array[$key]["img_art"]; ?>">
			</div>
			<div>
				<strong><?php echo $product_array[$key]["nom_art"]; ?></strong>
			</div>
			<div class="product-price">
				<?php echo "€".$product_array[$key]["prix_art"]; ?>
			</div>
			<div>
				<input type="text" name="quantité" value="1" size="2" />
				<input type="submit" value="Ajouter au panier" class="btnAddAction" />
			</div>
			</form>
		</div>
	<?php
			}
	}else{
	?>	
		<div class="product-grid">aucun article</div>
	<?php
	}
	?>
<!-- FIN AFFICHAGE DES ARTICLES -->	
</div>
