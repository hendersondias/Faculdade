<?php
$servername = "db"; // Nome do serviço MySQL no docker-compose
$username = "user";
$password = "userpass";
$dbname = "biblioteca";

// Cria a conexão
$conn = new mysqli($servername, $username, $password, $dbname);

// Verifica a conexão
if ($conn->connect_error) {
    die("Conexão falhou: " . $conn->connect_error);
}
?>
