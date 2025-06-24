<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $titulo = $_POST['titulo'];
    $descricao = $_POST['descricao'];
    $localizacao = $_POST['localizacao'];

    $conn = new mysqli("db", "user", "userpass", "recrutamento");

    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = "INSERT INTO vagas (titulo, descricao, localizacao) VALUES ('$titulo', '$descricao', '$localizacao')";
    if ($conn->query($sql) === TRUE) {
        header('Location: index.php');
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }

    $conn->close();
}
?>

<html>
<head>
    <title>Criar Vaga</title>
</head>
<body>
    <h1>Criar Nova Vaga</h1>
    <form method="post">
        Título: <input type="text" name="titulo"><br><br>
        Descrição: <textarea name="descricao"></textarea><br><br>
        Localização: <input type="text" name="localizacao"><br><br>
        <input type="submit" value="Criar Vaga">
    </form>
</body>
</html>
