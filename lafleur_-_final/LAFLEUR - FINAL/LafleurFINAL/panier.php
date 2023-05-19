<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Panier</title>
        
<style type="text/css">
  <!--
    a {
      text-decoration: none;
    }
  //-->
  </style>
    </head>
    <body background="http://cdn56.fansshare.com/photos/hdwallpaper/in-blue-color-yet-differs-in-lightness-and-darkness-style-is-simple-and-clean-hd-creative-wallpaper-colour-1589291903.jpg">
    <center>
        
<br>
<h3><b><u>Panier</u></b></h3>
<br>
       
        <table border=1>
   	<tr>
	       	<th><b>R&eacute;f&eacute;rence</b></th>
       	       	<th><b>D&eacute;signation</b></th>
       	       	<th><b>Prix Unit.</b></th>
		<th><b>Qt&eacute;</b></th>
                <th><b>Montant</b></th>
   	</tr>
        

           <?php
           
     
        $login='lafleur';
        $mdp='secret';
        $connexion = new PDO('mysql:host=localhost;dbname=lafleur'
                ,$login , $mdp);
        
        if(isset($_POST['bulbe'])){
        $ajout = $connexion->query('INSERT INTO commande (id,nom,prix_unitaire) 
        SELECT pdt_ref,pdt_designation,pdt_prix  
        FROM produit WHERE pdt_ref ="'.$_POST['bulbe'].'";');
        $ajout2 = $connexion->query('UPDATE commande SET quantite="'.$_POST['quantite'].'" '
                . 'WHERE id="'.$_POST['bulbe'].'";');
        header('location:bulbes.php');
        }
        
        if(isset($_POST['plante'])){
        $ajout = $connexion->query('INSERT INTO commande (id,nom,prix_unitaire) 
        SELECT pdt_ref,pdt_designation,pdt_prix  
        FROM produit WHERE pdt_ref ="'.$_POST['plante'].'";');
        $ajout2 = $connexion->query('UPDATE commande SET quantite="'.$_POST['quantite'].'" '
                . 'WHERE id="'.$_POST['plante'].'";');
        header('location:plantes.php');
        }
        
         if(isset($_POST['rosier'])){
        $ajout = $connexion->query('INSERT INTO commande (id,nom,prix_unitaire) 
        SELECT pdt_ref,pdt_designation,pdt_prix  
        FROM produit WHERE pdt_ref ="'.$_POST['rosier'].'";');
        $ajout2 = $connexion->query('UPDATE commande SET quantite="'.$_POST['quantite'].'" '
                . 'WHERE id="'.$_POST['rosier'].'";');
        header('location:rosiers.php');
        }
        
        $resultat = $connexion->query('SELECT * FROM commande ;');
        foreach($resultat as $ligne)
        {
            echo '<tr><td>'.$ligne['id'].'</td><td>'.$ligne['nom'].
                    "</td><td> ".$ligne['prix_unitaire'].'&#128;</td><td>'.$ligne['quantite'].
                    '</td><td>'.$ligne['prix_unitaire']*$ligne['quantite'].'&#128;</td></tr>';
        }
        
        $total= $connexion->query('SELECT SUM(quantite*prix_unitaire) FROM commande;'); 
        foreach ($total as $ligne){
        echo '<td colspan="4" align="right">Total</td><td>'.$ligne[0].'&#128;</td></table><br>';
        }
        
        $result = $connexion->query('SELECT * FROM commande ;');
        echo "<form action='panier.php' method='post'>
            <select name='del'>
            <option >S&eacute;lectionnez un article</option>";
        
        foreach($result as $ligne){
            echo '<option  value="'.$ligne['id'].'">'.$ligne['nom'].'</option>';
        }
        echo '<input type="number" name="quantite" min="1" max="9998"  />'
        . '<input type="submit" value ="Supprimer"></form>';
        
        if(isset($_POST['del'])&& isset($_POST['quantite'])){
            $modif = $connexion->query("UPDATE commande SET quantite= quantite - ".$_POST['quantite']."
            WHERE id='".$_POST['del']."';");
            $check= $connexion->query("SELECT quantite FROM commande WHERE id='".$_POST['del']."';");
            foreach ($check as $ligne){
                if($ligne['quantite']<1){
                    $supp = $connexion->query("DELETE FROM commande WHERE id='".$_POST['del']."';");
                }
            }
        
        header('Location:panier.php');   
        }
        else if(isset($_POST['del'])) {
            $supp = $connexion->query("DELETE FROM commande WHERE id='".$_POST['del']."';");
            header('Location:panier.php');       
        }   
        
        
        
        echo "<br/><form action='panier.php' method='post'>
            
            <input type='submit' value='Videz le panier' name='delete'>
         </form>";
        
        
        if(isset($_POST['delete'])){
            
            $suppression = $connexion->query("DELETE FROM commande ;");
            header('Location:panier.php');
         }
         
            
        ?>
        <br>
        <a href="commande.php" target=droite>Commander</a>
        
    </center> 
    </body>
</html>
