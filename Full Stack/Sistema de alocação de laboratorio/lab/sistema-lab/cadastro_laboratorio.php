<?php
// cadastro_laboratorio.php
session_start();
require_once 'conexao.php';

if (!isset($_SESSION['tipo']) || $_SESSION['tipo'] !== 'Diretor') {
    header('Location: login.php');
    exit();
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome = $_POST['nome'] ?? '';
    $qtd = intval($_POST['qtd'] ?? 0);

    if ($nome && $qtd > 0) {
        $stmt = $conn->prepare("INSERT INTO laboratorio (nome, qtd_computadores) VALUES (?, ?)");
        $stmt->bind_param("si", $nome, $qtd);

        if ($stmt->execute()) {
            $mensagem = "Laboratório cadastrado com sucesso!";
        } else {
            $erro = "Erro ao cadastrar: " . $stmt->error;
        }
    } else {
        $erro = "Preencha todos os campos corretamente.";
    }
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Laboratório</title>
    <link rel="stylesheet" href="css/estilos.css?v=2">
</head>
<body>
    <h2>Cadastro de Laboratório</h2>
    <?php
    if (!empty($mensagem)) echo "<p class='sucesso'>$mensagem</p>";
    if (!empty($erro)) echo "<p class='erro'>$erro</p>";
    ?>
    <form method="POST">
        <label for="nome">Nome do Laboratório:</label>
        <input type="text" name="nome" required><br>

        <label for="qtd">Quantidade de Computadores:</label>
        <input type="number" name="qtd" min="1" required><br>

        <button type="submit">Cadastrar Laboratório</button>
    </form>
    <br>
    <a href="dashboard_diretor.php">Voltar ao Painel</a>
</body>
</html>
