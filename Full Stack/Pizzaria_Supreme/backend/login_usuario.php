<?php
require 'conexao.php';
session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'];
    $senha = $_POST['senha'];

    try {
        $stmt = $pdo->prepare("SELECT * FROM usuarios WHERE email = ?");
        $stmt->execute([$email]);
        $usuario = $stmt->fetch(PDO::FETCH_ASSOC);

        if ($usuario && password_verify($senha, $usuario['senha'])) {
            $_SESSION['usuario_id'] = $usuario['id'];
            $_SESSION['usuario_nome'] = $usuario['nome'];

            // Redireciona para a página do cardápio
            header("Location: ../frontend_php/cardapio.php");
            exit();
        } else {
            echo "Email ou senha incorretos.";
        }
    } catch (PDOException $e) {
        echo "Erro ao fazer login: " . $e->getMessage();
    }
}
?>
