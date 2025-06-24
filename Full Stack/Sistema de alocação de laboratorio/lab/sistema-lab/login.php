<!-- login.php -->
<?php
session_start();
require_once 'conexao.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'] ?? '';
    $senha = $_POST['senha'] ?? '';

    $stmt = $conn->prepare("SELECT id_usuario, nome_completo, tipo_usuario, senha FROM usuario WHERE email = ?");
    $stmt->bind_param("s", $email);
    $stmt->execute();
    $resultado = $stmt->get_result();

    if ($resultado->num_rows === 1) {
        $usuario = $resultado->fetch_assoc();

        if ($senha === $usuario['senha']) { // Em produção, use password_hash e password_verify
            $_SESSION['id'] = $usuario['id_usuario'];
            $_SESSION['nome'] = $usuario['nome_completo'];
            $_SESSION['tipo'] = $usuario['tipo_usuario'];

            // Redireciona conforme o tipo de usuário
            switch ($usuario['tipo_usuario']) {
                case 'Diretor':
                    header("Location: dashboard_diretor.php");
                    break;
                case 'Coordenador':
                    header("Location: dashboard_coordenador.php");
                    break;
                case 'TI':
                    header("Location: dashboard_ti.php");
                    break;
            }
            exit();
        } else {
            $erro = "Senha incorreta.";
        }
    } else {
        $erro = "Usuário não encontrado.";
    }
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Login - Sistema de Laboratórios</title>
    <link rel="stylesheet" href="css/estilos.css?v=2">
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <?php if (!empty($erro)) echo "<p class='erro'>$erro</p>"; ?>
        <form method="POST" action="">
            <label for="email">Usuário (Email):</label>
            <input type="email" name="email" required><br>

            <label for="senha">Senha:</label>
            <input type="password" name="senha" required><br>

            <button type="submit">Entrar</button>
        </form>
    </div>
</body>
</html>
