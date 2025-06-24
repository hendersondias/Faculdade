<?php
require 'conexao.php';

header('Content-Type: application/json');

try {
    $stmt = $pdo->query("
        SELECT 
            pedidos.id AS pedido_id,
            usuarios.nome AS usuario_nome,
            pizzas.nome AS pizza_nome,
            pizzas.descricao AS pizza_descricao,
            pizzas.preco AS pizza_preco,
            pedidos.rua,
            pedidos.complemento,
            pedidos.bairro,
            pedidos.cep
        FROM pedidos
        JOIN usuarios ON pedidos.usuario_id = usuarios.id
        JOIN pizzas ON pedidos.pizza_id = pizzas.id
        ORDER BY pedidos.id DESC
    ");
    $pedidos = $stmt->fetchAll(PDO::FETCH_ASSOC);

    echo json_encode($pedidos);
} catch (PDOException $e) {
    echo json_encode(['error' => $e->getMessage()]);
}
?>
