<?php

define("VALOR", 100);
echo "Valor: ".VALOR;
$c = "VALOR";
if(defined($c)){
	echo "Constante $c está definida";
}
echo "Valor de c: ".$c;
?>