<?php
session_start();
require '../backend/conexao.php';

// Verifica se o usuário está logado
if (!isset($_SESSION['usuario_id'])) {
    header("Location: login.php");
    exit();
}

// Obtém o ID da pizza a partir da URL ou do POST
$pizza_id = isset($_GET['pizza_id']) ? intval($_GET['pizza_id']) : (isset($_POST['pizza_id']) ? intval($_POST['pizza_id']) : null);

// Verifica se o ID da pizza foi passado corretamente
if ($pizza_id === null) {
    echo "Pizza não encontrada!";
    exit();
}

// Obtém os detalhes da pizza do banco de dados
$stmt = $pdo->prepare("SELECT * FROM pizzas WHERE id = ?");
$stmt->execute([$pizza_id]);
$pizza = $stmt->fetch(PDO::FETCH_ASSOC);

if (!$pizza) {
    echo "Pizza não encontrada!";
    exit();
}

// Processa o formulário de confirmação de pedido
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $usuario_id = $_SESSION['usuario_id'];
    $rua = $_POST['rua'] ?? null;
    $complemento = $_POST['complemento'] ?? null;
    $bairro = $_POST['bairro'] ?? null;
    $cep = $_POST['cep'] ?? null;

    // Valida os campos do endereço
    if (empty($rua) || empty($bairro) || empty($cep)) {
        echo "Por favor, preencha todos os campos obrigatórios do endereço!";
        exit();
    }

    // Insere o pedido no banco de dados
    $stmt = $pdo->prepare("
        INSERT INTO pedidos (usuario_id, pizza_id, rua, complemento, bairro, cep) 
        VALUES (?, ?, ?, ?, ?, ?)
    ");
    $success = $stmt->execute([$usuario_id, $pizza_id, $rua, $complemento, $bairro, $cep]);

    if ($success) {
        echo "Pedido registrado com sucesso!";
        exit();
    } else {
        echo "Erro ao registrar o pedido.";
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmar Pedido - Pizzaria Supreme</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <h1>Confirmar Pedido</h1>
    <h2>Pizza: <?php echo htmlspecialchars($pizza['nome']); ?></h2>
    <p><?php echo htmlspecialchars($pizza['descricao']); ?></p>
    <p>R$ <?php echo number_format($pizza['preco'], 2, ',', '.'); ?></p>

    <form action="confirmar_pedido.php" method="POST">
        <input type="hidden" name="pizza_id" value="<?php echo $pizza_id; ?>">
        <label for="rua">Rua:</label>
        <input type="text" id="rua" name="rua" required><br>

        <label for="complemento">Complemento:</label>
        <input type="text" id="complemento" name="complemento"><br>

        <label for="bairro">Bairro:</label>
        <input type="text" id="bairro" name="bairro" required><br>

        <label for="cep">CEP:</label>
        <input type="text" id="cep" name="cep" required><br>

        <button type="submit">Confirmar Pedido</button>
    </form>
</body>
</html>
