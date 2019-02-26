<?php
include 'menu.php';
?>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Contact</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600|Archivo+Narrow:400,700" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

<div class="test">
 <div style="text-align:center">
   <u><h1>Contacter ALUME à Paris</h1> </u></br>
   <h2><p>
   Pour toute demande de renseignements supplémentaires sur nos produits, ou pour toute demande de devis, vous pouvez contacter AlUME à Paris par téléphone, mail ou en remplissant le formulaire de contact ci-contre. Afin de nous situer plus facilement, découvrez notre plan d’accès ci-dessous. 

N'hésitez pas à nous contacter : une question sur l'installation d'une veranda ou d'une pergola ? Besoin de faire remplacer vos portes et fenêtres, ou de faire installer un portail ? Notre équipe est à votre écoute et saura vous conseiller pour vous guider vers la gamme de menuiseries adaptée à vos besoins. 

</p></h2>
 </div>
 <div class="row">
   <div class="col-lg-10">
   <div class="column">
     <div id="map" style="width:100% height:50px;">
       <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6326.802218926391!2d2.2837759595820075!3d48.88737059119119!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e66f91aa85bfb1%3A0xca6c403c8e457b76!2sEcole+Iris!5e0!3m2!1sfr!2sfr!4v1516967183162" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
     </div>
   </div>
   </div>

   
<div class="column2">
	<form action="" method="post">
	Prénom: <input type="text" id="fname" name="first_name"><br>
	Nom: <input type="text" id="lname" name="last_name"><br>
	Email: <input type="text" name="email"><br>
	Message:<br><textarea rows="5" name="message" cols="30"></textarea><br>
	<input type="submit" name="submit" value="Envoyer">
	</form>
</div>

<?php 
if(isset($_POST['submit'])){
    $to = "contact@alume.com"; // this is your Email address
    $from = $_POST['email']; // this is the sender's Email address
    $first_name = $_POST['first_name'];
    $last_name = $_POST['last_name'];
    $subject = "Prise de contact";
    $subject2 = "Prise de contact";
    $message = $first_name . " " . $last_name . " wrote the following:" . "\n\n" . $_POST['message'];
    $message2 = "Voici une copie de votre message " . $first_name . "\n\n" . $_POST['message'];

    $headers = "From:" . $from;
    $headers2 = "From:" . $to;
    mail($to,$subject,$message,$headers);
    mail($from,$subject2,$message2,$headers2); // sends a copy of the message to the sender
    echo "Message envoyé. \n";
	echo "Merci " . $first_name . ", nous allons tenter de vous répondre dans les plus brefs délais.";
    // You can also use header('Location: thank_you.php'); to redirect to another page.
    }
?>
<br/>
<br/>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<?php
	include 'footer.php';
 ?>

</body>
</html>