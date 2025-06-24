<?php
require 'conexao.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $usuario_id = $_POST['usuario_id'];
    $pizza_id = $_POST['pizza_id'];
    $endereco = $_POST['endereco'];

    try {
        $stmt = $pdo->prepare("INSERT INTO pedidos (usuario_id, pizza_id, endereco) VALUES (?, ?, ?)");
        $stmt->execute([$usuario_id, $pizza_id, $endereco]);
        echo "Pedido registrado com sucesso!";
    } catch (PDOException $e) {
        echo "Erro ao registrar pedido: " . $e->getMessage();
    }
}
?>
