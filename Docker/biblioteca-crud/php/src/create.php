<?php
include 'db.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $titulo = $_POST['titulo'];
    $autor = $_POST['autor'];

    $sql = "INSERT INTO livros (titulo, autor) VALUES ('$titulo', '$autor')";

    if ($conn->query($sql) === TRUE) {
        header("Location: index.php");
        exit();
    } else {
        echo "Erro: " . $sql . "<br>" . $conn->error;
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Cadastrar Livro</title>
</head>
<body>
    <h1>Cadastrar Novo Livro</h1>
    <form method="POST" action="create.php">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" required>
        <br>
        <label for="autor">Autor:</label>
        <input type="text" id="autor" name="autor" required>
        <br>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
