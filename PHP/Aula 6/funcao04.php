<?php
function quadrado(&$valor){
	$valor_original = $valor;
	$valor *= $valor_original;
	echo "<br>Quadrado de $valor_original é ".$valor;
}
$valor = 12;
echo "Valor original: $valor";
quadrado($valor);
echo "<br>Valor atual: $valor";
?>