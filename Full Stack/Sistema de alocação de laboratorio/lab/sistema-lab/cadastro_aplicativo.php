<?php
// cadastro_aplicativo.php
session_start();
require_once 'conexao.php';

if (!isset($_SESSION['tipo']) || $_SESSION['tipo'] !== 'TI') {
    header('Location: login.php');
    exit();
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome_app = $_POST['nome_app'] ?? '';

    if ($nome_app) {
        // Inserir aplicativo (se ainda não existir)
        $stmt = $conn->prepare("INSERT INTO aplicativo (nome) VALUES (?)");
        $stmt->bind_param("s", $nome_app);

        if ($stmt->execute()) {
            $mensagem = "Aplicativo cadastrado com sucesso.";
        } else {
            $erro = "Erro ao cadastrar aplicativo.";
        }
    } else {
        $erro = "Preencha todos os campos.";
    }
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Aplicativo</title>
    <link rel="stylesheet" href="css/estilos.css?v=2">
</head>
<body>
    <h2>Cadastro de Aplicativo</h2>
    <?php
    if (!empty($mensagem)) echo "<p class='sucesso'>$mensagem</p>";
    if (!empty($erro)) echo "<p class='erro'>$erro</p>";
    ?>
    <form method="POST">
        <label for="nome_app">Nome do Aplicativo:</label>
        <input type="text" name="nome_app" required><br>

        <button type="submit">Cadastrar Aplicativo</button>
    </form>
    <br>
    <a href="dashboard_coordenador.php">Voltar ao início</a>
</body>
</html>
