<?php
include 'connect.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'];
    $password = $_POST['password'];
    $confirm_password = $_POST['confirm_password'];

    if ($password == $confirm_password) {
        // Hash da senha antes de armazenar no banco de dados
        $hashed_password = password_hash($password, PASSWORD_DEFAULT);

        $sql = "INSERT INTO tb_usuario (login_usuario, senha_usuario) VALUES (?, ?)";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("ss", $username, $hashed_password);
        if ($stmt->execute()) {
            header("Location: index.php");
            exit();
        } else {
            echo "Erro ao cadastrar usuário.";
        }
        $stmt->close();
    } else {
        echo "As senhas não coincidem.";
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Cadastro</title>
</head>
<body>
    <form method="post">
        <label for="username">Usuário:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Senha:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <label for="confirm_password">Confirmar Senha:</label>
        <input type="password" id="confirm_password" name="confirm_password" required>
        <br>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
