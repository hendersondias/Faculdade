<?php
header('Content-Type: application/json');
header('Access-Control-Allow-Methods: POST');
header('Access-Control-Allow-Headers: Content-Type');

include 'config.php';

// Função para validar o token
function validateToken($token) {
    return $token === API_TOKEN;
}

// Verificar o método de requisição
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo json_encode(['message' => 'Método não permitido']);
    exit;
}

// Validar token
$headers = apache_request_headers();
if (!isset($headers['Authorization']) || !validateToken($headers['Authorization'])) {
    echo json_encode(['message' => 'Token inválido']);
    exit;
}

// Obter ID da requisição
$data = json_decode(file_get_contents('php://input'), true);
if (!isset($data['id'])) {
    echo json_encode(['message' => 'ID não fornecido']);
    exit;
}

$id = intval($data['id']);

try {
    $db = getDB();
    $stmt = $db->prepare('DELETE FROM pessoas WHERE id = :id');
    $result = $stmt->execute([':id' => $id]);

    if ($result) {
        echo json_encode(['success' => true]);
    } else {
        echo json_encode(['success' => false]);
    }
} catch (PDOException $e) {
    echo json_encode(['success' => false, 'message' => 'Erro no banco de dados']);
}
?>
