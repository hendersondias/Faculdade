<?php
// cadastro_usuario.php
session_start();
require_once 'conexao.php';

if (!isset($_SESSION['tipo']) || $_SESSION['tipo'] !== 'Diretor') {
    header('Location: login.php');
    exit();
}

$tipo = $_GET['tipo'] ?? '';
$tipos_validos = ['Diretor', 'Coordenador', 'TI'];

if (!in_array($tipo, $tipos_validos)) {
    die('Tipo de usuário inválido.');
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome = $_POST['nome'] ?? '';
    $email = $_POST['email'] ?? '';
    $senha = $_POST['senha'] ?? '';

    if ($nome && $email && $senha) {
        $stmt = $conn->prepare("INSERT INTO usuario (nome_completo, email, senha, tipo_usuario) VALUES (?, ?, ?, ?)");
        $stmt->bind_param("ssss", $nome, $email, $senha, $tipo);

        if ($stmt->execute()) {
            $mensagem = "$tipo cadastrado com sucesso!";
        } else {
            $erro = "Erro ao cadastrar: " . $stmt->error;
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
    <title>Cadastro de <?php echo $tipo; ?></title>
    <link rel="stylesheet" href="css/estilos.css?v=2">
</head>
<body>
    <h2>Cadastro de <?php echo $tipo; ?></h2>
    <?php
    if (!empty($mensagem)) echo "<p class='sucesso'>$mensagem</p>";
    if (!empty($erro)) echo "<p class='erro'>$erro</p>";
    ?>
    <form method="POST">
        <label for="nome">Nome Completo:</label>
        <input type="text" name="nome" required><br>

        <label for="email">Email:</label>
        <input type="email" name="email" required><br>

        <label for="senha">Senha:</label>
        <input type="password" name="senha" required><br>

        <button type="submit">Cadastrar <?php echo $tipo; ?></button>
    </form>
    <br>
    <a href="dashboard_diretor.php">Voltar ao Painel</a>
</body>
</html>
