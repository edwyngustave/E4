<?php
session_start();

$bdd = new PDO('mysql:host=localhost;dbname=alume', 'root', '')or die('Could not connect: ' . mysql_error());

if(isset($_SESSION['id_cli'])) {
   $requser = $bdd->prepare("SELECT * FROM client WHERE id_cli = ?");
   $requser->execute(array($_SESSION['id_cli']));
   $user = $requser->fetch();
/*   if(isset($_POST['newpseudo']) AND !empty($_POST['newpseudo']) AND $_POST['newpseudo'] != $user['pseudo']) {
      $newpseudo = htmlspecialchars($_POST['newpseudo']);
      $insertpseudo = $bdd->prepare("UPDATE client SET pseudo = ? WHERE id = ?");
      $insertpseudo->execute(array($newpseudo, $_SESSION['id']));
      header('Location: profil.php?id='.$_SESSION['id']);
   }
*/
   if(isset($_POST['newmail']) AND !empty($_POST['newmail']) AND $_POST['newmail'] != $user['mail_cli']) {
      $newmail = htmlspecialchars($_POST['newmail']);
      $insertmail = $bdd->prepare("UPDATE client SET mail_cli = ? WHERE id_cli = ?");
      $insertmail->execute(array($newmail, $_SESSION['id_cli']));
      header('Location: profil.php?id='.$_SESSION['id_cli']);
        }

   if(isset($_POST['newnom']) AND !empty($_POST['newnom']) AND $_POST['newnom'] != $user['nom_cli']) {
      $newnom = htmlspecialchars($_POST['newnom']);
      $insertnom = $bdd->prepare("UPDATE client SET nom_cli = ? WHERE id_cli = ?");
      $insertnom->execute(array($newnom, $_SESSION['id_cli']));
      header('Location: profil.php?id='.$_SESSION['id_cli']);
   }

     if(isset($_POST['newprenom']) AND !empty($_POST['newprenom']) AND $_POST['newprenom'] != $user['prenom_cli']) {
      $newprenom = htmlspecialchars($_POST['newnom']);
      $insertprenom = $bdd->prepare("UPDATE client SET prenom_cli = ? WHERE id_cli = ?");
      $insertprenom->execute(array($newprenom, $_SESSION['id_cli']));
      header('Location: profil.php?id='.$_SESSION['id_cli']);
   }


     if(isset($_POST['newadresse']) AND !empty($_POST['newadresse']) AND $_POST['newadresse'] != $user['adress_cli']) {
      $newadresse = htmlspecialchars($_POST['newadresse']);
      $insertadresse = $bdd->prepare("UPDATE client SET adress_cli = ? WHERE id_cli = ?");
      $insertadresse->execute(array($newadresse, $_SESSION['id_cli']));
      header('Location: profil.php?id='.$_SESSION['id_cli']);
   }

    if(isset($_POST['newcp']) AND !empty($_POST['newcp']) AND $_POST['newcp'] != $user['cp_cli']) {
      $newcp = htmlspecialchars($_POST['newcp']);
      $insertcp = $bdd->prepare("UPDATE client SET cp_cli = ? WHERE id_cli = ?");
      $insertcp->execute(array($newcp, $_SESSION['id_cli']));
      header('Location: profil.php?id='.$_SESSION['id_cli']);
   }

    if(isset($_POST['newtel']) AND !empty($_POST['newtel']) AND $_POST['newtel'] != $user['tel_cli']) {
      $newtel = htmlspecialchars($_POST['newtel']);
      $inserttel = $bdd->prepare("UPDATE client SET tel_cli = ? WHERE id_cli = ?");
      $inserttel->execute(array($newtel, $_SESSION['id_cli']));
      header('Location: profil.php?id='.$_SESSION['id_cli']);
   }


   if(isset($_POST['newmdp1']) AND !empty($_POST['newmdp1']) AND isset($_POST['newmdp2']) AND !empty($_POST['newmdp2'])) {
      $mdp1 = sha1($_POST['newmdp1']);
      $mdp2 = sha1($_POST['newmdp2']);
      if($mdp1 == $mdp2) {
         $insertmdp = $bdd->prepare("UPDATE client SET mdp_cli = ? WHERE id_cli = ?");
         $insertmdp->execute(array($mdp1, $_SESSION['id_cli']));
         header('Location: profil.php?id='.$_SESSION['id_cli']);
      } else {
         $msg = "Vos deux mdp ne correspondent pas !";
      }
   }
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ALUME</title>
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
         <h2>Edition de mon profil</h2>
         <div align="left">
           <center>
            <form method="POST" action="" enctype="multipart/form-data">
<!--               <label>Pseudo :</label>
               <input type="text" name="newpseudo" placeholder="Pseudo" value="<?php echo $user['pseudo']; ?>" /><br /><br />
-->            <label>Mail :</label>
               <input type="text" name="newmail" placeholder="Mail" value="<?php echo $user['mail_cli']; ?>" /><br /><br />
               <label>Mot de passe :</label>
               <input type="password" name="newmdp1" placeholder="Mot de passe"/><br /><br />
               <label>Confirmation - mot de passe :</label>
               <input type="password" name="newmdp2" placeholder="Confirmation du mot de passe" /><br /><br />
               <label>Nom :</label>
               <input type="text" name="newnom" placeholder="Nom" /><br /><br />
               <label>Prenom :</label>
               <input type="text" name="newprenom" placeholder="Prenom" /><br /><br />
               <label>Adresse :</label>
               <input type="text" name="newadresse" placeholder="Adresse" /><br /><br />
                <label>Code postal :</label>
               <input type="text" name="newcp" placeholder="Code postal" /><br /><br />
               <label>Téléphone :</label>
               <input type="number" name="newtel" placeholder="Téléphone" /><br /><br />
               <input type="submit" value="Mettre à jour votre profil !"/>
            </form>
            <?php if(isset($msg)) { echo $msg; } ?>
          </center>
         </div>

      </div> 

      <?php
        include '../footer_panier.php';
       ?>

   </body>
</html>

<?php
}
else {
   header("Location: connexion.php");
}
?>
