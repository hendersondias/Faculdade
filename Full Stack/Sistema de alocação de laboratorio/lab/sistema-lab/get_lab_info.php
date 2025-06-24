<?php
// get_lab_info.php
session_start();
require_once 'conexao.php';

$id_lab = $_GET['id'] ?? '';

if ($id_lab) {
    $stmt = $conn->prepare("SELECT qtd_computadores FROM laboratorio WHERE id_laboratorio = ?");
    $stmt->bind_param("i", $id_lab);
    $stmt->execute();
    $result = $stmt->get_result();
    $lab_info = $result->fetch_assoc();

    echo json_encode($lab_info);
}
?>
