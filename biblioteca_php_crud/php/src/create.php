<?php
include 'db.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $titulo = $_POST['titulo'];
    $autor = $_POST['autor'];
    
    $sql = "INSERT INTO livros (titulo, autor) VALUES ('$titulo', '$autor')";
    if ($conn->query($sql) === TRUE) {
        header("Location: index.php");
    } else {
        echo "Erro: " . $conn->error;
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Adicionar Livro</title>
</head>
<body>
    <h1>Adicionar Livro</h1>
    <form method="POST">
        <label>Título:</label>
        <input type="text" name="titulo" required><br>
        <label>Autor:</label>
        <input type="text" name="autor" required><br>
        <input type="submit" value="Adicionar">
    </form>
</body>
</html>
