<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Commande</title>
    </head>
    <body background="http://cdn56.fansshare.com/photos/hdwallpaper/in-blue-color-yet-differs-in-lightness-and-darkness-style-is-simple-and-clean-hd-creative-wallpaper-colour-1589291903.jpg">
    <center>
    <br>
<h3><b><u>Votre commande</u></b></h3>
<br>
        <?php
        $login='lafleur';
        $mdp='secret';
        $connexion = new PDO('mysql:host=localhost;dbname=lafleur'
                ,$login, $mdp);
         $resultat = $connexion->query('SELECT * FROM commande;');
        echo  '<table border=1>';
         foreach($resultat as $ligne)
        {
            echo '<tr><td>'.$ligne['id'].'</td><td>'.$ligne['nom'].
                    "</td><td> ".$ligne['prix_unitaire'].'&#128;</td><td>'.$ligne['quantite'].
                    '</td><td>'.$ligne['prix_unitaire']*$ligne['quantite'].'&#128;</td></tr>';
        }
        
        $total= $connexion->query('SELECT SUM(quantite*prix_unitaire) FROM commande;'); 
        foreach ($total as $ligne){
        echo '<td colspan="4" align="right">Total</td><td>'.$ligne[0].'&#128;</td></table>';
        }
        ?>
        <p><form action="confirmation.php" method="post">
            <label> Code client : </label>
            <input type="text" name="code"/>
            <label> Mot de passe : </label>
            <input type="password" name="mdp"/><p>
            </center>
            <input style="margin-left: 550px" type="submit" value="Envoyer la commande"/>
        </form>
        
        
    
    </body>
</html>
