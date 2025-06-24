<?php
$servername = "db";
$username = "user";
$password = "userpass";
$dbname = "recrutamento";

// Criar conexão
$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar conexão
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// CRUD - Read (Listar Vagas)
$sql = "SELECT * FROM vagas";
$result = $conn->query($sql);
?>

<html>
<head>
    <title>Agência de Recrutamento</title>
</head>
<body>
    <h1>Vagas de Emprego</h1>
    <a href="create.php">Adicionar Nova Vaga</a>
    <table border="1">
        <thead>
            <tr>
                <th>Título</th>
                <th>Descrição</th>
                <th>Localização</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <?php while($row = $result->fetch_assoc()): ?>
            <tr>
                <td><?php echo $row['titulo']; ?></td>
                <td><?php echo $row['descricao']; ?></td>
                <td><?php echo $row['localizacao']; ?></td>
                <td>
                    <a href="edit.php?id=<?php echo $row['id']; ?>">Editar</a>
                    <a href="delete.php?id=<?php echo $row['id']; ?>">Deletar</a>
                </td>
            </tr>
            <?php endwhile; ?>
        </tbody>
    </table>
</body>
</html>

<?php
$conn->close();
?>
