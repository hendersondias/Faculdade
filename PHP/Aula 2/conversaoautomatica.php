<?php 
$f= 1 + "10.5";        //float (11.5)
$f= 1 + "-1.3e3";      //float (-1299)
$f= 1 + "x-1.5e30";    //integer (1)
$f= 1 + "x3";          //integer (1)
$f= 1 + "10x";         //integer (11) 
$f= 4 + "10.2y";       //float (14.2)
$f= "10.0 x" + 1;      //float (11)
$f= "10.0 x" + 1.0;    //float (11) 
?>
