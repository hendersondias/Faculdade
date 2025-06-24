<?php
include 'connect.php';

if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['id'])) {
    $id = $_GET['id'];
    $sql = "SELECT nome_ferramenta, marca_ferramenta FROM tb_ferramentas WHERE cod_ferramenta = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $id);
    $stmt->execute();
    $stmt->bind_result($nome, $marca);
    $stmt->fetch();
    $stmt->close();
}

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['id'])) {
    $id = $_POST['id'];
    $nome = $_POST['nome'];
    $marca = $_POST['marca'];

    $sql = "UPDATE tb_ferramentas SET nome_ferramenta = ?, marca_ferramenta = ? WHERE cod_ferramenta = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ssi", $nome, $marca, $id);
    $stmt->execute();
    $stmt->close();

    header("Location: dashboard.php");
    exit();
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Ferramenta</title>
</head>
<body>
    <form method="post">
        <input type="hidden" name="id" value="<?php echo $id; ?>">
        <label for="nome">Nome da Ferramenta:</label>
        <input type="text" id="nome" name="nome" value="<?php echo htmlspecialchars($nome); ?>" required>
        <br>
        <label for="marca">Marca da Ferramenta:</label>
        <input type="text" id="marca" name="marca" value="<?php echo htmlspecialchars($marca); ?>" required>
        <br>
        <button type="submit">Salvar</button>
    </form>
</body>
</html>
