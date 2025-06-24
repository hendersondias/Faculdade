<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nome = $_POST['nome'];
    $celular = $_POST['celular'];
    $email = $_POST['email'];
    $senha = $_POST['senha'];

    echo "Nome: " . $nome . "<br>";
    echo "Celular: " . $celular . "<br>";
    echo "Email: " . $email . "<br>";
    echo "Senha: " . $senha;
}
?>
