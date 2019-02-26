<?php
$bdd = new PDO('mysql:host=localhost;dbname=alume', 'root', '') or die('Could not connect: ' . mysql_error());
if(isset($_SESSION["cart_item"])){
    $item_total = 0;
?> 
<br/><br/>
<!-- TABLEAU D'AFFICHAGE DES ARTICLES DU PANIER -->
<center><table cellpadding="10" cellspacing="1">
<tbody>
<tr>
<th style="text-align:left;"><strong>Nom de l'article</strong></th>
<th style="text-align:left;"><strong>Reference de l'article</strong></th>
<th style="text-align:right;"><strong>Quantité</strong></th>
<th style="text-align:right;"><strong>Prix de l'article</strong></th>
<th style="text-align:center;"><strong>Action</strong></th>
</tr>
<?php
    foreach ($_SESSION["cart_item"] as $item){
		?>
				<tr>
				<td style="text-align:left;border-bottom:#F0F0F0 1px solid;"><strong><?php echo $item["nom_art"]; ?></strong></td>
				<td style="text-align:left;border-bottom:#F0F0F0 1px solid;"><?php echo $item["code_art"]; ?></td>
				<td style="text-align:right;border-bottom:#F0F0F0 1px solid;"><?php echo $item["quantité"]; ?></td>
				<td style="text-align:right;border-bottom:#F0F0F0 1px solid;"><?php echo "€".$item["prix_art"]; ?></td>
				<td style="text-align:center;border-bottom:#F0F0F0 1px solid;"><a href="index.php?action=remove&code_art=<?php echo $item["code_art"]; ?>" class="btnRemoveAction">Supprimer l'article</a></td>
				</tr>
				<?php
        $item_total += ($item["prix_art"]*$item["quantité"]);
		}

    //$insertcmd = $bdd->prepare ("INSERT INTO ligne_commande_client(qte_lignec,id_commandc, id_art) VALUES (?,?,?) ")
  //  $insertmbr->execute(array($));

		?>



<tr>
<td colspan="5" align=right><strong>Total:</strong> <?php echo "$".$item_total; ?></td>
</tr>
</tbody>
</table>
</center> <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<!-- FIN TABLEAU D'AFFICHAGE DES ARTICLES DU PANIER -->
  <?php
}
?>
