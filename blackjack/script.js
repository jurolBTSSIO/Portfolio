let compteurAsJoueur = 0;
let compteurAsBanque = 0;
let carte;
let scoreJoueur = 0;
let scoreBanque = 0;
function carteAleatoire()
{
    let min=1; 
    let max=52;
    return Math.floor(Math.random() * (max - min)) + min;
}
function CalclerScoreJoueur()
{ 
    if ( carte % 13 < 11 && carte % 13 != 0 && carte % 13 != 1 )
    {
        scoreJoueur += carte % 13;
    }
    else if( carte % 13 == 1 )
    {
        scoreJoueur += 11;
        compteurAsJoueur++;
    }
    else
    {
        scoreJoueur += 10;
    }  
}
function CalculerScoreBanque()
{
    if ( carte % 13 < 11 && carte % 13 != 0 && carte % 13 !=1 )
    {
        scoreBanque += carte % 13;
    }
    else if( carte % 13 == 1 )
    {
        scoreBanque += 11;
        compteurAsBanque++;
    }
    else
    {
        scoreBanque += 10;
    }
}
function Carte()
{
    carte = carteAleatoire();
    CalclerScoreJoueur();

    if ( scoreJoueur > 21 && compteurAsJoueur != 0)
    {
        scoreJoueur -= 10;
        compteurAsJoueur--;
    }

    document.getElementById("joueur").innerHTML += "<img  src='images/" + carte + ".jpg'>";
    document.getElementById("scoreJoueur").innerHTML =  scoreJoueur ;

    if ( scoreJoueur > 21)
{
    alert("Perdu!!");
}
    if ( scoreJoueur == 21 )
    {
        window.location.href="blackjack.html";
    }
}
function Reste()
{
    var i = 0
    document.getElementById("verso").innerHTML = "";

    while ( i < 4 && scoreBanque <= scoreJoueur )
    { 
        carte = carteAleatoire();
        CalculerScoreBanque();
        
        if ( scoreBanque > 21 && compteurAsBanque != 0 )
    {
        scoreBanque -= 10;
        compteurAsBanque--;
    }
        document.getElementById("banque").innerHTML += "<img src='images/" + carte + ".jpg'>";
        i++;   
    }
    if ( scoreJoueur < scoreBanque && scoreBanque <= 21)
        {
            alert("Perdu!!");
        }
    else 
        {
            alert("Gagné!!");
        }
        document.getElementById("scoreBanque").innerHTML = scoreBanque;   
}

