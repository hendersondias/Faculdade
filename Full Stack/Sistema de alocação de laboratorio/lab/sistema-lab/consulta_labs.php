<?php
// consulta_labs.php
session_start();
require_once 'conexao.php';

if (!isset($_SESSION['tipo']) || $_SESSION['tipo'] !== 'Coordenador') {
    header('Location: login.php');
    exit();
}

$query = "
    SELECT l.id_laboratorio, l.nome, l.qtd_computadores
    FROM laboratorio l
    WHERE l.id_laboratorio NOT IN (
        SELECT a.id_laboratorio
        FROM alocacao a
        WHERE a.status = 'Aprovado'
    )
    ORDER BY l.nome
";

$resultado = $conn->query($query);
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Consulta de Laboratórios</title>
    <link rel="stylesheet" href="css/estilos.css?v=2">
</head>
<body>
    <h2>Laboratórios Disponíveis (não reservados)</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>Nome</th>
            <th>Quantidade de Computadores</th>
        </tr>
        <?php while ($lab = $resultado->fetch_assoc()): ?>
            <tr>
                <td><?php echo $lab['nome']; ?></td>
                <td><?php echo $lab['qtd_computadores']; ?></td>
            </tr>
        <?php endwhile; ?>
    </table>
    <br>
    <a href="dashboard_coordenador.php">Voltar ao Painel</a>
</body>
</html>
