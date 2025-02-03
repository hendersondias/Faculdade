<?php
include 'db.php';

$id = $_GET['id'];
$sql = "SELECT * FROM livros WHERE id=$id";
$result = $conn->query($sql);
$livro = $result->fetch_assoc();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $titulo = $_POST['titulo'];
    $autor = $_POST['autor'];

    $sql = "UPDATE livros SET titulo='$titulo', autor='$autor' WHERE id=$id";

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
    <title>Editar Livro</title>
</head>
<body>
    <h1>Editar Livro</h1>
    <form method="POST" action="edit.php?id=<?php echo $id; ?>">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" value="<?php echo $livro['titulo']; ?>" required>
        <br>
        <label for="autor">Autor:</label>
        <input type="text" id="autor" name="autor" value="<?php echo $livro['autor']; ?>" required>
        <br>
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
