<?php
session_start();
if (!isset($_SESSION['user_id'])) {
    header("Location: index.php");
    exit();
}

include 'connect.php';

// Handle adding tool
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['tool_name'], $_POST['tool_brand'])) {
    $tool_name = $_POST['tool_name'];
    $tool_brand = $_POST['tool_brand'];
    $user_id = $_SESSION['user_id'];

    $sql = "INSERT INTO tb_ferramentas (nome_ferramenta, marca_ferramenta) VALUES (?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ss", $tool_name, $tool_brand);
    $stmt->execute();
    $stmt->close();

    $tool_id = $conn->insert_id;

    $sql = "INSERT INTO tb_usuario_ferramentas (cod_usuario, cod_ferramenta) VALUES (?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ii", $user_id, $tool_id);
    $stmt->execute();
    $stmt->close();
}

// Fetch tools
$sql = "SELECT f.cod_ferramenta, f.nome_ferramenta, f.marca_ferramenta 
        FROM tb_ferramentas f 
        INNER JOIN tb_usuario_ferramentas uf ON f.cod_ferramenta = uf.cod_ferramenta 
        WHERE uf.cod_usuario = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $_SESSION['user_id']);
$stmt->execute();
$result = $stmt->get_result();
$tools = $result->fetch_all(MYSQLI_ASSOC);
$stmt->close();
?>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h1>Bem-vindo!</h1>
    <form method="post">
        <label for="tool_name">Nome da Ferramenta:</label>
        <input type="text" id="tool_name" name="tool_name" required>
        <br>
        <label for="tool_brand">Marca da Ferramenta:</label>
        <input type="text" id="tool_brand" name="tool_brand" required>
        <br>
        <button type="submit">Adicionar Ferramenta</button>
    </form>

    <h2>Ferramentas</h2>
    <ul>
        <?php foreach ($tools as $tool): ?>
            <li>
                <?php echo htmlspecialchars($tool['nome_ferramenta']) . " (" . htmlspecialchars($tool['marca_ferramenta']) . ")"; ?>
                <a href="edit.php?id=<?php echo $tool['cod_ferramenta']; ?>">Editar</a>
                <a href="delete.php?id=<?php echo $tool['cod_ferramenta']; ?>">Deletar</a>
            </li>
        <?php endforeach; ?>
    </ul>
</body>
</html>