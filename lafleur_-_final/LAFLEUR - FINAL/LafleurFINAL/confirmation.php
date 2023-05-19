<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
	<center>
        <?php
        
        if(isset($_POST['code']) && isset($_POST['mdp'])){
            echo "La commande a été enregistrée sous le numéro : ".$_POST['code']."".rand(100000000,999999999).".";
        }
        ?>
		</center>
    </body>
</html>
