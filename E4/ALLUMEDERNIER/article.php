<?php
session_start();
require_once("panier/dbcontroller.php");
$db_handle = new DBController();
require_once('panier/action_panier.php');
require_once("menu.php")
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
 <link rel="stylesheet" href="article.css">
 <link href="menu_article.css" rel="stylesheet" type="text/css" media="all" />

 </head>

 <body>
<?php
	include 'produit_pisc.php';
?>
</body>

<?php
  //include 'footer.php';
 ?>
</html>
