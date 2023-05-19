<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Rosiers</title>
    </head>
	
    <body background="http://cdn56.fansshare.com/photos/hdwallpaper/in-blue-color-yet-differs-in-lightness-and-darkness-style-is-simple-and-clean-hd-creative-wallpaper-colour-1589291903.jpg">
    <center> 
    
        <br>
<h3><b><u>Rosiers</u></b></h3>
<br>
<table border=1>
   	<tr>
	       	<th><b>R&eacute;f&eacute;rence</b></th>
       	       	<th><b>D&eacute;signation</b></th>
       	       	<th><b>Photo</b></th>
		<th><b>Prix</b></th>
   	</tr>
       <?php
        $login='lafleur';
        $mdp='secret';
        $connexion = new PDO('mysql:host=localhost;dbname=lafleur'
                ,$login , $mdp);
        $resultat = $connexion->query('SELECT * FROM produit WHERE pdt_categorie ="ros";');
            
        foreach($resultat as $ligne)
        {
            echo '<tr><td>'.$ligne['pdt_ref'].'</td><td>'.$ligne['pdt_designation'].
                    "</td><td> ".$ligne['pdt_image'].'</td><td>'.$ligne['pdt_prix'].
                    '&#128;</td></tr>';
            
        }
            echo '</table><br>';
             $result = $connexion->query('SELECT pdt_ref,pdt_designation FROM produit WHERE pdt_ref LIKE "r%" ;');
        echo "<form action='panier.php' method='post'>
            <select name='rosier'>
            <option >S&eacute;lectionnez un article</option>";
        foreach($result as $ligne)
        {
            echo '<option  value="'.$ligne['pdt_ref'].'">'.$ligne['pdt_designation'].'</option>';
        }
        
        echo '<input type="number" name="quantite" min="1" max="9999" /><input type="submit" value="Ajoutez au panier" name="valider3"></form>';
            
        ?>
        
        
    </center>
    </body>
</html>	