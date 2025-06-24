<?php
// dashboard_coordenador.php
session_start();
if ($_SESSION['tipo'] !== 'Coordenador') {
    header('Location: login.php');
    exit();
}
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Painel do Coordenador</title>
    <link rel="stylesheet" href="css/estilos.css">
    <style>
        .dashboard-container {
            max-width: 400px;
            width: 100%;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin: 20px auto;
            text-align: center;
        }
        .dashboard-container ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }
        .dashboard-container li {
            margin: 10px 0;
        }
        .dashboard-container a {
            color: #0066cc;
            text-decoration: none;
        }
        .dashboard-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <h1>Bem-vindo, <?php echo $_SESSION['nome']; ?>!</h1>
        <h2>Painel do Coordenador</h2>
        <ul>
            <li><a href="cadastro_disciplina.php">Solicitar Alocação do Laboratório</a></li>
            <li><a href="consulta_labs.php">Consultar Laboratórios</a></li>
            <li><a href="logout.php">Sair</a></li>
        </ul>
    </div>
</body>
</html>