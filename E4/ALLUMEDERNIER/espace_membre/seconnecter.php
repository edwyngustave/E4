<?php
session_start();

try{
   $bdd = new PDO('mysql:host=alumeprorwbts.mysql.db;dbname=alumeprorwbts', 'alumeprorwbts', 'Feueduc6');


}catch(PDOException $e){
   die('Erreur : '.$e->getMessage());
}


if(isset($_POST['formconnexion'])) {
   $mailconnect = htmlspecialchars($_POST['mailconnect']);
   $mdpconnect = sha1($_POST['mdpconnect']);
   if(!empty($mailconnect) AND !empty($mdpconnect)) {
      $requser = $bdd->prepare("SELECT * FROM client WHERE mail_cli = ? AND mdp_cli = ?");
      $requser->execute(array($mailconnect, $mdpconnect));
      $userexist = $requser->rowCount();
      if($userexist == 1)
      {
         $userinfo = $requser->fetch();
         $_SESSION['id_cli'] = $userinfo['id_cli'];
         //$_SESSION['pseudo'] = $userinfo['pseudo'];
         $_SESSION['mail_cli'] = $userinfo['mail_cli'];
         header("Location: profil.php?id=".$_SESSION['id_cli']);

      }
      else
      {
         $erreur = "Mauvais mail ou mot de passe !";
      }
   }
   else
   {
      $erreur = "Tous les champs doivent être complétés !";
   }
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
        <p>Lorem ipsum veroeros</p>
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


      <div style="height:233px;" align="center">
         <h2>Connexion</h2>
         <br /><br />
         <form method="POST" action="">
          <input type="email" name="mailconnect" placeholder="Mail" />
          <input type="password" name="mdpconnect" placeholder="Mot de passe" />
          <br /><br />
          <input type="submit" name="formconnexion" value="Se connecter" />
         </form>
       </br>




  <?php


     if(isset($erreur)) {
     echo '<font color="red">'.$erreur."</font>";
         }
         ?>

         <a href="inscription.php" title=""><input type="submit" name="formconnexion" value="S'inscrire" /></a>
      </div>

      <footer class="footer-distributed">
      	<div class="footer-left">
      		<h1>ALUME</h1>
      		<p class="footer-links">
      			<a href="#">ACCUEIL</a>
      			·
      			<a href="#">PISCINE</a>
      			·
      			<a href="#">PORTE</a>
      			·
      			<a href="#">ESPACES MEMBRE</a>
      			·
      			<a href="#">PANIER</a>
      			·
      			<a href="#">CONTACT</a>
      		</p>
      		<p class="footer-company-name">Alume &copy; 2018</p>
      	</div>
      	<div class="footer-center">
      		<div>
      			<i class="fa fa-map-marker"></i>
      			<p><span>2, Impasse des 2 cousins</span> Paris, France</p>
      		</div>
      		<div>
      			<i class="fa fa-phone"></i>
      			<p>+6 12 34 56 78</p>
      		</div>
      		<div>
      			<i class="fa fa-envelope"></i>
      			<p><a href="#">contact@alume.com</a></p>
      		</div>
      	</div>

      	<div class="footer-right">

      		<p class="footer-company-about">
      			<span>A propos de l'entreprise</span>
      Plus de 20 ans d'expertise dans la construction.
      		</p>

      		<div class="footer-icons">
      			<a href="#"><i class="fa fa-facebook"></i></a>
      			<a href="#"><i class="fa fa-twitter"></i></a>
      			<a href="#"><i class="fa fa-linkedin"></i></a>
      			<a href="#"><i class="fa fa-github"></i></a>
      		</div>
      	</div>
      </footer>

   </body>
</html>
