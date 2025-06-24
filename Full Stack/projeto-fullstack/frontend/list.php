<?php
require '../backend/pessoaController.php';
$pessoas = getPessoas();
?>

<h2>Lista de Pessoas</h2>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Idade</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($pessoas as $pessoa): ?>
            <tr>
                <td><?= $pessoa['id'] ?></td>
                <td><?= $pessoa['nome'] ?></td>
                <td><?= $pessoa['idade'] ?></td>
                <td>
                    <form action="../backend/pessoaController.php" method="POST" style="display:inline;">
                        <input type="hidden" name="delete" value="true">
                        <input type="hidden" name="id" value="<?= $pessoa['id'] ?>">
                        <button type="submit">Excluir</button>
                    </form>
                </td>
            </tr>
        <?php endforeach; ?>
    </tbody>
</table>
