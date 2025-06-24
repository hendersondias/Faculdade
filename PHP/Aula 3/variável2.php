<?php
$var = "Carol";
$nome = $var; // Atribuição direta (cópia)
$Nome = &$var; // Atribuição por referência
$nome = "Isabelle"; //só modifica $nome
$Nome = "Anna Carolina"; //$var é modificado
echo "\$var = $var <br>";
echo "\$nome = $nome <br>";
echo "\$Nome = $Nome <br>";
?>