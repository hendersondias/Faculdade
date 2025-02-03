<?php
include 'db.php';

$sql = "SELECT * FROM livros";
$result = $conn->query($sql);
?>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Biblioteca</title>
</head>
<body>
    <h1>Biblioteca - Lista de Livros</h1>
    <a href="create.php">Cadastrar Novo Livro</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Autor</th>
            <th>Ações</th>
        </tr>
        <?php
        if ($result->num_rows > 0) {
            while ($row = $result->fetch_assoc()) {
                echo "<tr>";
                echo "<td>" . $row['id'] . "</td>";
                echo "<td>" . $row['titulo'] . "</td>";
                echo "<td>" . $row['autor'] . "</td>";
                echo "<td>
                    <a href='edit.php?id=" . $row['id'] . "'>Editar</a> |
                    <a href='delete.php?id=" . $row['id'] . "'>Deletar</a>
                </td>";
                echo "</tr>";
            }
        } else {
            echo "<tr><td colspan='4'>Nenhum livro encontrado</td></tr>";
        }
        ?>
    </table>
</body>
</html>
