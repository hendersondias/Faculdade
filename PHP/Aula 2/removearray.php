
<?php 
$a = array("cliente 1", 3 => "cliente 2", "cliente 3"); 
$a1 = array("cliente 1" => 1000, "cliente 2" => 5000, "cliente 3" => 0); 
$a2 = array("cliente 1" =>
	array("endereço" => "Rua x, no. 10", 
		  "bairro" => "Vila Maria",
		  "cidade" => "São Paulo"),
	"cliente 2" => array("endereço" => "Rua y, no. 102 ",
	"bairro" => "Glória",
	"cidade" => "Vila Velha"));

unset($a[3]); // Remove o elemento 3 do array $a
unset($a1); // Remove o array $a1 
echo "<pre>"; 
print_r($a); 
print_r($a1);
print_r($a2);
echo "</pre>";

?>
