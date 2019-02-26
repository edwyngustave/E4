<?php
	include 'menu.php';
	session_start();
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
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<h1>Alu Project, spécialiste de la véranda
et de la pergola à Paris
</h1>
<h2>
			
			<p>Située aux portes de Montauban, dans le 17ème arrondissement (75) Alu  intervient dans le remplacement ou l’installation de menuiseries pour votre habitation, qu’il s’agisse de portes, fenêtres, portails, volets, piscine de luxe, etc. 

Nous sommes aussi spécialisés dans l’aménagement de vos espaces de vie, grâce à nos vérandas, qui s’intègrent parfaitement à votre habitation, et à nos pergolas, qui permettent de réguler l’ombre et la lumière sur votre espace extérieur. 

Notre idée ? Que vous puissiez changer de maison, sans quitter la vôtre !</p></h2>

<a href="article.php" title="En savoir plus sur notre société" class="bouton">En savoir plus</a>


<!-- CAROUSEL -->
<div id="banner">
	<div id="slider">
		<div class="viewer">
			<div class="reel">
				<div class="slide">
					<h2></h2>
					<p>Piscine de luxe</p>
					<a class="link" href="article.php?piscines=piscines"></a> <img src="image/piscineluxe2.jpg" alt="" /> </div>
				<div class="slide">
					<h2></h2>
					<p>Porte de luxe</p>
					<a class="link" href="article.php?fenetres=fenetres"></a> <img src="image/portedeluxe.jpg" alt="" /> </div>
				<div class="slide">
					<h2></h2>
					<p>Fenetre de luxe</p>
					<a class="link" href="article.php?portes=portes"></a> <img src="image/fenetredeluxe.jpg" alt="" /> </div>
			</div>
		</div>

		<div class="indicator">
			<ul>
				<li class="active">1</li>
				<li>2</li>
				<li>3</li>
			</ul>
		</div>
	</div>
	<script type="text/javascript">
		$('#slider').slidertron({
			viewerSelector: '.viewer',
			reelSelector: '.viewer .reel',
			slidesSelector: '.viewer .reel .slide',
			advanceDelay: 3000,
			speed: 'slow',
			navPreviousSelector: '.previous-button',
			navNextSelector: '.next-button',
			indicatorSelector: '.indicator ul li',
			slideLinkSelector: '.link'
		});
	</script>
</div>
<!-- FIN CAROUSEL -->

<?php
	include 'footer.php';
 ?>

</body>
</html>
