<?php
require 'conexao.php';  // Verifique se o caminho para o arquivo de conexão está correto

header('Content-Type: application/json');  // Definindo o tipo de retorno como JSON

try {
    // Consultando todas as pizzas no banco de dados
    $stmt = $pdo->query("SELECT * FROM pizzas");
    $pizzas = $stmt->fetchAll(PDO::FETCH_ASSOC);  // Buscando todas as pizzas em formato associativo

    if (count($pizzas) > 0) {
        // Se houver pizzas, retorne como JSON
        echo json_encode($pizzas);
    } else {
        // Se não houver pizzas, retorne uma resposta vazia
        echo json_encode([]);
    }
} catch (PDOException $e) {
    // Caso haja erro, retorna uma mensagem de erro em JSON
    echo json_encode(['error' => 'Erro ao listar pizzas: ' . $e->getMessage()]);
}
?>
