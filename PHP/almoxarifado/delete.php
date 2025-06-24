<?php
include 'connect.php';
session_start();

if (!isset($_SESSION['user_id'])) {
    header("Location: index.php");
    exit();
}

if (isset($_GET['id'])) {
    $id = $_GET['id'];
    $user_id = $_SESSION['user_id'];

    // Primeiro, exclua as referências na tabela `tb_usuario_ferramentas`
    $sql = "DELETE FROM tb_usuario_ferramentas WHERE cod_ferramenta = ?";
    $stmt = $conn->prepare($sql);
    if ($stmt) {
        $stmt->bind_param("i", $id);
        $stmt->execute();
        $stmt->close();
    }

    // Finalmente, exclua a ferramenta
    $sql = "DELETE FROM tb_ferramentas WHERE cod_ferramenta = ?";
    $stmt = $conn->prepare($sql);
    if ($stmt) {
        $stmt->bind_param("i", $id);
        $stmt->execute();
        $stmt->close();
    }

    // Redireciona de volta para o dashboard
    header("Location: dashboard.php");
    exit();
}
?>
