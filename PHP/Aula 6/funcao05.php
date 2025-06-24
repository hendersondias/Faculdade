<?php

$valor1 = 10;
$valor2 = 7;
echo "A média dos valores é ".media($valor1, $valor2);

function media($valor1, $valor2){
	$m = ($valor1+$valor2)/2;
	return $m;
}


?>