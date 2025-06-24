<?php
function &soma($valor1, $valor2) {
$resultado = $valor1+$valor2;
return $resultado;
}
$res = &soma(10,20);
echo "Soma: $res";
?>
