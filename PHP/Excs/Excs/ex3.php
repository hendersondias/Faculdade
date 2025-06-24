<?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $nomeLivro = $_POST['nomeLivro'];
        $tipoUsuario = $_POST['tipoUsuario'];
        $dataDevolucao = new DateTime();

        echo "<h2>Recibo de Empréstimo</h2>";
        echo "Livro: " . $nomeLivro . "<br>";
        echo "Tipo de Usuário: " . $tipoUsuario . "<br>";

        if ($tipoUsuario == 'professor') {
            $dataDevolucao->modify('+10 days');
        } else {
            $dataDevolucao->modify('+3 days');
        }

        echo "Data de Devolução: " . $dataDevolucao->format('d/m/Y') . "<br>";
    }
    ?>