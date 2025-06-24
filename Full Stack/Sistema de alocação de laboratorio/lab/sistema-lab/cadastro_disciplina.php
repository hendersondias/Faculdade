<?php
// cadastro_disciplina.php
session_start();
require_once 'conexao.php';

if (!isset($_SESSION['tipo']) || $_SESSION['tipo'] !== 'Coordenador') {
    header('Location: login.php');
    exit();
}

// Carregar aplicativos disponíveis
$aplicativos = $conn->query("SELECT id_aplicativo, nome FROM aplicativo ORDER BY nome");
$laboratorios = $conn->query("SELECT id_laboratorio, nome, qtd_computadores FROM laboratorio ORDER BY nome");

$qtd_computadores = null;

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome = $_POST['nome'] ?? '';
    $qtd_alunos = intval($_POST['qtd_alunos'] ?? 0);
    $duracao = intval($_POST['duracao'] ?? 0);
    $inicio = $_POST['horario_inicio'] ?? '';
    $fim = $_POST['horario_fim'] ?? '';
    $data_alocacao = $_POST['data_alocacao'] ?? ''; // Novo campo de data
    $apps = $_POST['apps'] ?? [];
    $id_lab = $_POST['id_lab'] ?? '';
    $id_coordenador = $_SESSION['id'];

    // Obter a quantidade de computadores do laboratório selecionado
    if (!empty($id_lab)) {
        $stmt_lab = $conn->prepare("SELECT qtd_computadores FROM laboratorio WHERE id_laboratorio = ?");
        $stmt_lab->bind_param("i", $id_lab);
        $stmt_lab->execute();
        $result_lab = $stmt_lab->get_result();
        $lab_info = $result_lab->fetch_assoc();
        $qtd_computadores = $lab_info['qtd_computadores'] ?? null;
    }

    // Verificar se já existe uma alocação para o mesmo laboratório na mesma data
    $stmt_check = $conn->prepare("SELECT * FROM alocacao WHERE id_laboratorio = ? AND data_alocacao = ?");
    $stmt_check->bind_param("is", $id_lab, $data_alocacao);
    $stmt_check->execute();
    $result_check = $stmt_check->get_result();

    if ($result_check->num_rows > 0) {
        $erro = "Reserva não concluída! Há uma solicitação de alocação para a mesma data, por favor selecionar outra data.";
    } else if ($inicio >= $fim) {
        $erro = "O horário de início deve ser anterior ao horário de término.";
    } else if ($nome && $qtd_alunos > 0 && $duracao > 0 && $inicio && $fim && count($apps) && $qtd_computadores !== null) {
        if ($qtd_alunos > $qtd_computadores * 2) {
            $erro = "A quantidade de alunos não pode ultrapassar " . ($qtd_computadores * 2) . ".";
        } else {
            $stmt = $conn->prepare("INSERT INTO disciplina (nome, qtd_alunos, horario_inicio, horario_fim, duracao, id_coordenador) VALUES (?, ?, ?, ?, ?, ?)");
            $stmt->bind_param("sissii", $nome, $qtd_alunos, $inicio, $fim, $duracao, $id_coordenador);

            if ($stmt->execute()) {
                $id_disciplina = $conn->insert_id;

                foreach ($apps as $id_app) {
                    $stmt2 = $conn->prepare("INSERT INTO disciplina_aplicativo (id_disciplina, id_aplicativo) VALUES (?, ?)");
                    $stmt2->bind_param("ii", $id_disciplina, $id_app);
                    $stmt2->execute();
                }

                // Inserir a alocação na tabela alocacao
                $stmt3 = $conn->prepare("INSERT INTO alocacao (id_laboratorio, id_disciplina, data_alocacao) VALUES (?, ?, ?)");
                $stmt3->bind_param("iis", $id_lab, $id_disciplina, $data_alocacao);
                $stmt3->execute();

                // Mensagem de sucesso
                $mensagem = "Solicitação enviada com sucesso! Enviamos para aprovação do Diretor.";
            } else {
                $erro = "Erro ao cadastrar disciplina: " . $stmt->error;
            }
        }
    } else {
        $erro = "Preencha todos os campos corretamente.";
    }
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Disciplina</title>
    <link rel="stylesheet" href="css/estilos.css?v=2">
</head>
<body>
    <h2>Solicitação de Alocação do Laboratório</h2>
    <?php
    if (!empty($mensagem)) echo "<p class='sucesso'>{$mensagem}</p>";
    if (!empty($erro)) echo "<p class='erro'>{$erro}</p>";
    ?>
    <form method="POST">
        <label for="nome">Nome da Disciplina:</label>
        <input type="text" name="nome" required><br>

        <label for="qtd_alunos">Quantidade de Alunos:</label>
        <input type="number" name="qtd_alunos" required><br>

        <label for="duracao">Duração (minutos):</label>
        <input type="number" name="duracao" required><br>

        <label for="horario_inicio">Horário de Início:</label>
        <input type="time" name="horario_inicio" required><br>

        <label for="horario_fim">Horário de Término:</label>
        <input type="time" name="horario_fim" required><br>

        <label for="data_alocacao">Data da Reserva:</label><br>
        <input type="date" name="data_alocacao" required><br>

        <label for="id_lab">Selecione o Laboratório:</label>
        <select name="id_lab" id="id_lab" required>
            <option value="">-- Selecione --</option>
            <?php
            // Para carregar novamente após envio, precisamos resetar o ponteiro do result set para o início
            if ($laboratorios !== false) {
                $laboratorios->data_seek(0);
                while ($lab = $laboratorios->fetch_assoc()):
            ?>
                <option value="<?php echo $lab['id_laboratorio']; ?>"><?php echo htmlspecialchars($lab['nome']); ?></option>
            <?php
                endwhile;
            }
            ?>
        </select><br>

        <label for="qtd_computadores">Quantidade de Computadores:</label>
        <input type="text" name="qtd_computadores" id="qtd_computadores" readonly><br>

        <label for="apps">Aplicativos Requeridos:</label><br>
        <?php
        if ($aplicativos !== false) {
            $aplicativos->data_seek(0);
            while ($app = $aplicativos->fetch_assoc()):
        ?>
            <input type="checkbox" name="apps[]" value="<?php echo $app['id_aplicativo']; ?>">
            <?php echo htmlspecialchars($app['nome']); ?><br>
        <?php
            endwhile;
        }
        ?>

        <button type="submit">Enviar Solicitação</button>
    </form>
    <br>
    <a href="dashboard_coordenador.php">Voltar ao Painel</a>

    <script>
    document.getElementById('id_lab').addEventListener('change', function () {
        var labId = this.value;
        if (labId) {
            fetch('get_lab_info.php?id=' + labId)
                .then(response => response.json())
                .then(data => {
                    document.getElementById('qtd_computadores').value = data.qtd_computadores;
                });
        } else {
            document.getElementById('qtd_computadores').value = '';
        }
    });
    </script>
</body>
</html>
