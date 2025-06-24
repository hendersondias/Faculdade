<?php
session_start();

// Verifica se o usuário está logado
if (!isset($_SESSION['usuario_id'])) {
    header("Location: login.php");
    exit();
}

// Caminho correto para o script listar_pizzas.php
$pizzasJson = file_get_contents('http://localhost/Pizzaria_Supreme/backend/listar_pizzas.php');
$pizzas = json_decode($pizzasJson, true);  // Converte o JSON para array associativo

if (!$pizzas) {
    $pizzas = [];  // Garante que $pizzas seja sempre um array, mesmo se não houver pizzas
}

?>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cardápio - Pizzaria Supreme</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <h1>Bem-vindo, <?php echo htmlspecialchars($_SESSION['usuario_nome']); ?>!</h1>
    <h2>Cardápio</h2>
    <div class="cardapio">
        <?php if (count($pizzas) > 0): ?>
            <?php foreach ($pizzas as $pizza): ?>
                <div class="pizza-item">
                    <img src="<?php echo htmlspecialchars($pizza['imagem']); ?>" alt="<?php echo htmlspecialchars($pizza['nome']); ?>">
                    <h3><?php echo htmlspecialchars($pizza['nome']); ?></h3>
                    <p><?php echo htmlspecialchars($pizza['descricao']); ?></p>
                    <p>R$ <?php echo number_format($pizza['preco'], 2, ',', '.'); ?></p>
                    <!-- Alteração para usar GET em vez de POST -->
                    <a href="confirmar_pedido.php?pizza_id=<?php echo $pizza['id']; ?>">
                        <button type="button">Adicionar ao Carrinho</button>
                    </a>
                </div>
            <?php endforeach; ?>
        <?php else: ?>
            <p>Não há pizzas disponíveis no momento.</p>
        <?php endif; ?>
    </div>
</body>
</html>
