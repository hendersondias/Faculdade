<?php
include 'db.php';

$id = $_GET['id'];

$sql = "DELETE FROM livros WHERE id=$id";

if ($conn->query($sql) === TRUE) {
    header("Location: index.php");
    exit();
} else {
    echo "Erro: " . $sql . "<br>" . $conn->error;
}
?>
