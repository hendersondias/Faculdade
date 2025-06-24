<?php
// aprovacao.php
session_start();
require_once 'conexao.php';

if (!isset($_SESSION['tipo']) || $_SESSION['tipo'] !== 'Diretor') {
    header('Location: login.php');
    exit();
}

// Consulta para buscar alocações pendentes
$query = "
    SELECT a.id_alocacao, l.nome AS laboratorio, d.nome AS disciplina, d.horario_inicio, d.horario_fim, 
           l.qtd_computadores, d.qtd_alunos, d.duracao, a.data_alocacao
    FROM alocacao a
    JOIN laboratorio l ON l.id_laboratorio = a.id_laboratorio
    JOIN disciplina d ON d.id_disciplina = a.id_disciplina
    WHERE a.status = 'Pendente'
    ORDER BY a.id_alocacao DESC
";

$alocacoes = $conn->query($query);

// Verificar se a consulta retornou resultados
if ($alocacoes === false) {
    echo "Erro na consulta: " . $conn->error;
    exit();
}

// Lógica para aprovar ou rejeitar alocações
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id_alocacao = $_POST['id_alocacao'] ?? '';
    $acao = $_POST['acao'] ?? '';

    if ($acao === 'aprovar') {
        $stmt = $conn->prepare("UPDATE alocacao SET status = 'Aprovado' WHERE id_alocacao = ?");
        $stmt->bind_param("i", $id_alocacao);
        $stmt->execute();
        $mensagem = "Alocação realizada com sucesso, por favor avise o coordenador.";
    } elseif ($acao === 'rejeitar') {
        $stmt = $conn->prepare("UPDATE alocacao SET status = 'Rejeitado' WHERE id_alocacao = ?");
        $stmt->bind_param("i", $id_alocacao);
        $stmt->execute();
        $erro = "Alocação foi rejeitada, por favor avise o coordenador.";
    }
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Aprovação de Alocações</title>
    <link rel="stylesheet" href="css/estilos.css?v=2">
    <style>
        form button {
            display: block;
            width: 100%;
            margin: 4px 0;
            padding: 8px;
            font-weight: bold;
        }
        form button[name="acao"][value="rejeitar"] {
            background-color: #dc3545;
        }
        form button[name="acao"][value="rejeitar"]:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <h2>Solicitações Pendentes de Alocação</h2>
    <?php if (!empty($mensagem)) echo "<p class='sucesso'>$mensagem</p>"; ?>
    <?php if (!empty($erro)) echo "<p class='erro'>$erro</p>"; ?>
    <table border="1" cellpadding="5">
        <tr>
            <th>Laboratório</th>
            <th>Disciplina</th>
            <th>Horário</th>
            <th>Quantidade de Computadores</th>
            <th>Quantidade de Alunos</th>
            <th>Duração (minutos)</th>
            <th>Data da Reserva</th>
            <th>Ações</th>
        </tr>
        <?php if ($alocacoes->num_rows > 0): ?>
            <?php while ($row = $alocacoes->fetch_assoc()): ?>
                <tr>
                    <td><?php echo htmlspecialchars($row['laboratorio']); ?></td>
                    <td><?php echo htmlspecialchars($row['disciplina']); ?></td>
                    <td><?php echo htmlspecialchars($row['horario_inicio'] . ' - ' . $row['horario_fim']); ?></td>
                    <td><?php echo htmlspecialchars($row['qtd_computadores']); ?></td>
                    <td><?php echo htmlspecialchars($row['qtd_alunos']); ?></td>
                    <td><?php echo htmlspecialchars($row['duracao']); ?></td>
                    <td><?php echo htmlspecialchars($row['data_alocacao']); ?></td>
                    <td>
                        <form method="POST">
                            <input type="hidden" name="id_alocacao" value="<?php echo $row['id_alocacao']; ?>">
                            <button name="acao" value="aprovar">Aprovar</button>
                            <button name="acao" value="rejeitar">Rejeitar</button>
                        </form>
                    </td>
                </tr>
            <?php endwhile; ?>
        <?php else: ?>
            <tr>
                <td colspan="8">Nenhuma solicitação pendente.</td>
            </tr>
        <?php endif; ?>
    </table>
    <br>
    <a href="dashboard_diretor.php">Voltar ao Painel</a>
</body>
</html>