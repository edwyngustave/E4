AFFICHER LE NOMBRE DE CAMION CONDUIS PAR CHAUFFEUR
-----------------------------------------------------------------------
create view statcamion(numerochauffeur,totalcamion)
as select c.id_chauf, count(*)
from camion c
group by c.id_chauf;
------------------------------------


AFFICHER TOUT LES PRODUITS AINSI QUE LEURS PRODUITS DE SUBSTITUTION SI IL Y EN A
-----------------------------------------------------------------------
create view substition(produit, substitution)
as select a.code_art, a.sub_code_art
from article a
group by a.code_art;
------------------------------------


AFFICHE SEULEMENT PRODUITS QUI ONT DES PRODUITS DE SUBSTITUTION ET LEURS PRODUITS DE SUBSTITUTION
-----------------------------------------------------------------------
create view substition(produit, substitution)
as select a.code_art, a.sub_code_art
from article a
where a.sub_code_art is not null
group by a.code_art;
------------------------------------


AFFICHER LE NOMBRE DE COMMANDES REALISEES CHAQUE ANNEES
-----------------------------------------------------------------------
SELECT count(id_commandc), year(date_commandc) as nb_com from commandec group by year(date_commandc);
------------------------------------


CE TRIGER PERMET A CHAQUE NOUVELLE COMMNANDE DINCREMENTER DANS LA TABLE CLIENT LE NOMBRE DE COMMANDES DU CLIENT
-----------------------------------------------------------------------
Déclencheurs `commandec`
--
DELIMITER $$
CREATE TRIGGER `Statcom` AFTER INSERT ON `commandec` FOR EACH ROW BEGIN
Declare nb int;
select nbcom into nb
from client where id_cli=new.id_cli;
if nb is null 

then set nb=0;
end if;
UPDATE CLIENT 
set nbcom=nb+1 where id_cli=new.id_cli;
END
$$
DELIMITER ;
DELIMITER $$

---------------------------------------


QUAND ON SUPPRIME UNE COMMANDE ON REMET A JOUR LE NOMBRE DE COMMANDES DANS LA TABLE CLIENT EN FAISANT -1
---------------------------------------------------------------
CREATE TRIGGER `Statcom2` AFTER DELETE ON `commandec` FOR EACH ROW BEGIN
Declare nb int;
select nbcom into nb
from client where id_cli=old.id_cli;
UPDATE CLIENT 
set nbcom=nb-1 where id_cli=old.id_cli;
END
$$
DELIMITER ;
DELIMITER $$
---------------------------------------------------


QUAND ON SUPPRIME UNE COMMANDE ON SUPPRIME LES LIGNES QUELLE CONTIENT AUSSI
--------------------------------------------------------------
CREATE TRIGGER `deleteCommande` BEFORE DELETE ON `commandec` FOR EACH ROW BEGIN
delete from lignecommandc where lignecommande.id_commandc = old.id_commandc;
END
$$
DELIMITER ;
--------------------------------------------------------------