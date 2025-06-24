<?php
$host = 'localhost';
$dbname = 'Pizzaria_Supreme';
$user = 'root'; // Substitua se necessário
$password = ''; // Substitua se necessário

try {
    $pdo = new PDO("mysql:host=$host;dbname=$dbname", $user, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Erro na conexão com o banco de dados: " . $e->getMessage());
}
?>
