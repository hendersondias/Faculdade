function validarCPF(cpf) {
  cpf = cpf.replace(/[^\d]+/g, '');
  if (cpf == '') return false;
  if (cpf.length != 11 ||
    cpf == "00000000000" ||
    cpf == "11111111111" ||
    cpf == "22222222222" ||
    cpf == "33333333333" ||
    cpf == "44444444444" ||
    cpf == "55555555555" ||
    cpf == "66666666666" ||
    cpf == "77777777777" ||
    cpf == "88888888888" ||
    cpf == "99999999999")
    return false;

  var soma = 0;
  for (var i = 0; i < 9; i++)
    soma += parseInt(cpf.charAt(i)) * (10 - i);
  var resto = 11 - (soma % 11);
  if (resto == 10 || resto == 11)
    resto = 0;
  if (resto != parseInt(cpf.charAt(9)))
    return false;

  soma = 0;
  for (var i = 0; i < 10; i++)
    soma += parseInt(cpf.charAt(i)) * (11 - i);
  resto = 11 - (soma % 11);
  if (resto == 10 || resto == 11)
    resto = 0;
  if (resto != parseInt(cpf.charAt(10)))
    return false;
  return true;
}


function verificarVazio(campo) {
  return campo.value.trim() == '';
}


function verificarSenhas(senha, confirmar) {
  return senha.value == confirmar.value;
}

function validarFormulario() {
  var cpf = document.getElementById("cpf");
  var nome = document.getElementById("nome");
  var email = document.getElementById("email");
  var senha = document.getElementById("senha");
  var confirmar = document.getElementById("confirmar");
  var valido = true;

  if (validarCPF(cpf.value)) {
    cpf.classList.remove("invalid");
    cpf.classList.add("valid");
  } else {
    cpf.classList.remove("valid");
    cpf.classList.add("invalid");
    alert("CPF inválido");
    valido = false;
  }

  if (verificarVazio(nome)) {
    nome.classList.remove("valid");
    nome.classList.add("invalid");
    alert("Preencha o nome");
    valido = false;
  } else {
    nome.classList.remove("invalid");
    nome.classList.add("valid");
  }

  if (verificarVazio(email)) {
    email.classList.remove("valid");
    email.classList.add("invalid");
    alert("Preencha o email");
    valido = false;
  } else {
    email.classList.remove("invalid");
    email.classList.add("valid");
  }

  if (verificarVazio(senha)) {
    senha.classList.remove("valid");
    senha.classList.add("invalid");
    alert("Preencha a senha");
    valido = false;
  } else {
    senha.classList.remove("invalid");
    senha.classList.add("valid");
  }

  if (verificarSenhas(senha, confirmar)) {
    confirmar.classList.remove("invalid");
    confirmar.classList.add("valid");
  } else {
    confirmar.classList.remove("valid");
    confirmar.classList.add("invalid");
    alert("As senhas não coincidem");
    valido = false;
  }
  if (valido) {
    alert("Dados gravados com sucesso!");
  }
  return valido;
}
