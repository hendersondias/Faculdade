<?php
$servername = "db"; 
$username = "MYSQL_USER"; 
$password = "MYSQL_PASSWORD"; 
$dbname = "MY_DATABASE"; 

// Cria a conexão
$conn = new mysqli($servername, $username, $password, $dbname);

// Verifica a conexão
if ($conn->connect_error) {
    die("Conexão falhou: " . $conn->connect_error);
}

echo "Conexão bem-sucedida!";
?>
