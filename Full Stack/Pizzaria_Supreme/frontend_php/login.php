<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Pizzaria Supreme</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <h1>Login</h1>
    <form action="../backend/login_usuario.php" method="POST">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required><br>

        <button type="submit">Entrar</button>
    </form>
    <a href="cadastro.php">Não tem conta? Cadastre-se</a>
</body>
</html>
