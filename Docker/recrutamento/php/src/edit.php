<?php
$id = $_GET['id'];
$conn = new mysqli("db", "user", "userpass", "recrutamento");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $titulo = $_POST['titulo'];
    $descricao = $_POST['descricao'];
    $localizacao = $_POST['localizacao'];

    $sql = "UPDATE vagas SET titulo='$titulo', descricao='$descricao', localizacao='$localizacao' WHERE id=$id";
    if ($conn->query($sql) === TRUE) {
        header('Location: index.php');
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
}

$sql = "SELECT * FROM vagas WHERE id=$id";
$result = $conn->query($sql);
$vaga = $result->fetch_assoc();
?>

<html>
<head>
    <title>Editar Vaga</title>
</head>
<body>
    <h1>Editar Vaga</h1>
    <form method="post">
        Título: <input type="text" name="titulo" value="<?php echo $vaga['titulo']; ?>"><br><br>
        Descrição: <textarea name="descricao"><?php echo $vaga['descricao']; ?></textarea><br><br>
        Localização: <input type="text" name="localizacao" value="<?php echo $vaga['localizacao']; ?>"><br><br>
        <input type="submit" value="Atualizar Vaga">
    </form>
</body>
</html>

<?php
$conn->close();
?>
