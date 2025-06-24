<?php
$var = "Carol";
$nome = $var;
$Nome = &$var;
$nome = "Isabelle";
$Nome = "Anna Carolina";
echo "var = $var <br>";
echo "nome = $nome <br>";
echo "Nome = $Nome <br>";
?>