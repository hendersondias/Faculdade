<?php
// pessoaController.php
require 'db.php';  // Certifique-se de que o caminho está correto

// Função para listar todas as pessoas
function getPessoas() {
    global $pdo;  // Certifique-se de que está usando o objeto $pdo corretamente
    $stmt = $pdo->query("SELECT * FROM pessoas");
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}

// Função para buscar uma pessoa pelo ID
function getPessoaById($id) {
    global $pdo;
    $stmt = $pdo->prepare("SELECT * FROM pessoas WHERE id = :id");
    $stmt->execute(['id' => $id]);
    return $stmt->fetch(PDO::FETCH_ASSOC);
}

// Função para adicionar ou atualizar uma pessoa
function savePessoa($nome, $idade, $id = null) {
    global $pdo;
    if ($id) {
        // Atualiza registro existente
        $stmt = $pdo->prepare("UPDATE pessoas SET nome = :nome, idade = :idade WHERE id = :id");
        $stmt->execute(['nome' => $nome, 'idade' => $idade, 'id' => $id]);
    } else {
        // Adiciona novo registro
        $stmt = $pdo->prepare("INSERT INTO pessoas (nome, idade) VALUES (:nome, :idade)");
        $stmt->execute(['nome' => $nome, 'idade' => $idade]);
    }
}

// Função para excluir uma pessoa
function deletePessoa($id) {
    global $pdo;
    $stmt = $pdo->prepare("DELETE FROM pessoas WHERE id = :id");
    $stmt->execute(['id' => $id]);
}

// Verifica se a requisição é POST e processa os dados
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Se os dados forem enviados via formulário normal (não JSON)
    $nome = $_POST['nome'] ?? null;
    $idade = $_POST['idade'] ?? null;
    $id = $_POST['id'] ?? null;

    // Verifica se é uma requisição para excluir
    if (isset($_POST['delete'])) {
        deletePessoa($_POST['id']);
        echo json_encode(['status' => 'success', 'message' => 'Pessoa excluída com sucesso!']);
    } else {
        // Adiciona ou atualiza uma pessoa
        savePessoa($nome, $idade, $id);
        echo json_encode(['status' => 'success', 'message' => 'Pessoa salva com sucesso!']);
    }
    exit;
}
?>
