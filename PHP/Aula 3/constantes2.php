<?php
define ("VALOR", 100);
echo "Valor = " . VALOR . "<br>";
$c = "VALOR";
echo "Valor = " . constant($c);
if (defined($c)){
	echo "Constante $c está definida";
}
?>