<form action="../backend/pessoaController.php" method="POST" id="personForm">
    <input type="hidden" name="id" id="id">
    
    <label for="nome">Nome:</label>
    <input type="text" name="nome" id="nome" required>
    
    <label for="idade">Idade:</label>
    <input type="number" name="idade" id="idade" required>
    
    <button type="submit">Salvar</button>
</form>
