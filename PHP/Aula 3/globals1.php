<?php
function test(){
	$teste = "variável local";
    echo '$teste em escopo global: '.$GLOBALS["teste"]."<br>";
    echo '$teste em escopo atual: '.$teste. "<br>";

}
$teste = "Exemplo de conteúdo";
test();
?>