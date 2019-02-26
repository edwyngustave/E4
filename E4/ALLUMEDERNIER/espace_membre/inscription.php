<?php
$bdd = new PDO('mysql:host=localhost;dbname=alume', 'root', '') or die('Could not connect: ' . mysql_error());

if(isset($_POST['forminscription'])) {

   //$pseudo = htmlspecialchars($_POST['pseudo']);
   $mail_cli = htmlspecialchars($_POST['mail_cli']);
   $mail_cli2 = htmlspecialchars($_POST['mail_cli2']);
   $mdp_cli = sha1($_POST['mdp_cli']);
   $mdp_cli2 = sha1($_POST['mdp_cli2']);
   $nom_cli = htmlspecialchars($_POST['nom_cli']);
   $prenom_cli = htmlspecialchars($_POST['prenom_cli']);
   $adress_cli = htmlspecialchars($_POST['adress_cli']);
   $cp_cli = htmlspecialchars($_POST['cp_cli']);
   $tel_cli = htmlspecialchars($_POST['tel_cli']);


   if(!empty($_POST['mail_cli']) AND !empty($_POST['mail_cli2']) AND !empty($_POST['mdp_cli']) AND !empty($_POST['mdp_cli2'])
   	AND !empty($_POST['nom_cli']) AND !empty($_POST['prenom_cli']) AND !empty($_POST['adress_cli']) AND !empty($_POST['cp_cli']) AND !empty($_POST['tel_cli'])) {
      if($mail_cli == $mail_cli2) {


      if(filter_var($mail_cli, FILTER_VALIDATE_EMAIL)) {
      $reqmail = $bdd->prepare("SELECT * FROM client WHERE mail_cli = ?");
      $reqmail->execute(array($mail_cli));
      $mailexist = $reqmail->rowCount();

      if($mailexist == 0) {

      if($mdp_cli == $mdp_cli2) {

      $insertmbr = $bdd->prepare("INSERT INTO client(mail_cli, mdp_cli, nom_cli, prenom_cli, tel_cli, adress_cli, cp_cli ) VALUES(?, ?, ?, ?, ?, ?, ?)");
      $insertmbr->execute(array($mail_cli, $mdp_cli, $nom_cli, $prenom_cli, $tel_cli, $adress_cli, $cp_cli));
      $erreur = "<a style='color: green;'>Votre compte a bien été créé !</a></br><a href=\"connexion.php\">Me connecter</a>";
             }
          else
            {
          $erreur = "Vos mots de passes ne correspondent pas !";
            }
            }
           else
           {
          $erreur = "Adresse mail déjà utilisée !";
           }
       } else

       {
        $erreur = "Votre adresse mail n'est pas valide !";
       }
         } else
         {
            $erreur = "Vos adresses mail ne correspondent pas !";
         }
      }
       else
       {
         $erreur = "Votre prenom doit être renseigné et ne doit pas dépasser 255 caractères !";
      }
   }
   else
   {
     $erreur = "Tous les champs doivent être complétés !";
   }

?>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MAXCORP</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="jquery.slidertron-1.1.js"></script>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600|Archivo+Narrow:400,700" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link href="espace.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

  <div id="header-wrapper">
    <div id="header" class="container">
      <div id="logo">
        <h1><a href="#">ALUME</a></h1>
        <p></p>
      </div>

      <div id="menu">
        <ul>
          <li class="first active"><a href="../index.php" accesskey="1" title="">ACCUEIL</a></li>
          <li><a href="../article.php" accesskey="2" title="">ARTICLE</a></li>
          <li><a href="connexion.php" accesskey="4" title="">ESPACE MEMBRE</a></li>
          <li><a href="../contact.php" accesskey="5" title="">CONTACT</a></li>
          <li><a href="../panier/index.php" accesskey="6" title="">PANIER</a></li>
        </ul>
      </div>
    </div>
  </div>

<div align="center">

	<h2>Inscription<h2>
		<br /><br />
		<form method="POST" action="">

<table>
<!--	<tr>
	<td align="right">
	<label for="pseudo"> Pseudo :</label>

	</td>

		<td>

		<input type="text" placeholder="Votre Pseudo" id="pseudo"
		name="pseudo">
		</td>
</tr>
-->



	<tr>
	<td align="right">
	<label for="mail_cli"> Mail :</label>

	</td>

		<td>

		<input type="email" placeholder="Votre mail" id="mail_cli"
		name="mail_cli">
		</td>
</tr>


	<tr>
	<td align="right">
	<label for="mail_cli2"> Confirmation du mail :</label>

	</td>

		<td>

		<input type="email" placeholder="Confirmez votre mail" id="mail_cli2"
		name="mail_cli2">
		</td>
</tr>



<tr>
	<td align="right">
	<label for="mdp_cli"> Mot de passe :</label>

	</td>

		<td>

		<input type="password" placeholder="Votre mot de passe" id="mdp_cli"
		name="mdp_cli">
		</td>
</tr>


<tr>
	<td align="right">
	<label for="mdp_cli2"> Confirmation du mdp :</label>

	</td>

		<td>

		<input type="password" placeholder="Confirmez votre mdp" id="mdp_cli2"
		name="mdp_cli2">
		</td>
</tr>


<tr>
	<td align="right">
	<label for="nom_cli">Nom :</label>

	</td>

		<td>

		<input type="text" placeholder="Votre nom" id="nom_cli"
		name="nom_cli">
		</td>
</tr>



<tr>
	<td align="right">
	<label for="prenom_cli"> Prenom :</label>

	</td>

		<td>

		<input type="text" placeholder="Votre Prenom" id="prenom_cli"
		name="prenom_cli">
		</td>
</tr>



<tr>
	<td align="right">
	<label for="adress_cli">Adresse :</label>

	</td>

		<td>

		<input type="text" placeholder="Votre adresse" id="adress_cli"
		name="adress_cli">
		</td>
</tr>

<tr>
	<td align="right">
	<label for="cp_cli">Code postal :</label>

	</td>

		<td>

		<input type="text" placeholder="Votre Code postal" id="cp_cli"
		name="cp_cli">
		</td>
</tr>



<tr>
	<td align="right">
	<label for="tel_cli">Téléphone :</label>

	</td>

		<td>

		<input type="" placeholder="Votre téléphone" id="tel_cli"
		name="tel_cli">
		</td>
</tr>









<tr>
	<td></td>
    <td align="center"> <br /> <input type="submit" name="forminscription" value="Je m'inscris ! "> </td>

</tr>



</table>

</form>

<?php

if(isset($erreur)){
	echo '<font color="red">'.$erreur."</font>";
}

?>




</div>


<?php
  include '../footer_panier.php';
 ?>

</body>
</html>
