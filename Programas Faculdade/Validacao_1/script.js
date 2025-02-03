// Função para validar o CPF
function validarCPF(cpf) {
    // Remover os caracteres não numéricos do cpf
    cpf = cpf.replace(/\D/g, "");

    // Verificar se o cpf tem 11 dígitos
    if (cpf.length != 11) {
        return false;
    }

    // Calcular os dígitos verificadores do cpf
    var soma = 0;
    var resto;
    for (var i = 1; i <= 9; i++) {
        soma += parseInt(cpf.substring(i - 1, i)) * (11 - i);
    }
    resto = (soma * 10) % 11;
    if (resto == 10 || resto == 11) {
        resto = 0;
    }
    if (resto != parseInt(cpf.substring(9, 10))) {
        return false;
    }
    soma = 0;
    for (var i = 1; i <= 10; i++) {
        soma += parseInt(cpf.substring(i - 1, i)) * (12 - i);
    }
    resto = (soma * 10) % 11;
    if (resto == 10 || resto == 11) {
        resto = 0;
    }
    if (resto != parseInt(cpf.substring(10, 11))) {
        return false;
    }

    // Se passou por todas as verificações, o cpf é válido
    return true;
}

// Função para validar o preenchimento do campo nome
function validarNome(nome) {
    // Verificar se o nome não está em branco
    if (nome.trim() == "") {
        return false;
    }

    // Se passou pela verificação, o nome é válido
    return true;
}

// Função para validar o preenchimento do campo senha
function validarSenha(senha) {
    // Verificar se a senha não está em branco
    if (senha.trim() == "") {
        return false;
    }

    // Se passou pela verificação, a senha é válida
    return true;
}

// Função para verificar se os dois campos de senhas são iguais
function verificarSenhas(senha, confirmarSenha) {
    // Comparar as senhas
    if (senha != confirmarSenha) {
        return false;
    }

    // Se passou pela comparação, as senhas são iguais
    return true;
}
