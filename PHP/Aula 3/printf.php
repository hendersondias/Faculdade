<?php 
$dia = date("d"); 
$mes = date("m"); 
$ano = date("Y"); 
printf("%04d-%02d-%02d", $ano, $mes, $dia); 
$vlr = 1235.50; 
$vlr2 = 502.23; 
$sld = $vlr - $vlr2; 
printf("%01.2f", $sld);
?>
