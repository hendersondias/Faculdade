<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<?php
// Recebe os dados do formulário com a variável $_POST
$nome = $_POST['nome'];
$senha = $_POST['senha'];
$sexo = $_POST['sexo'];
$turno = $_POST['turno'];
$cidade = $_POST['cidade'];

	$hostname="localhost";
	$username="root";
	$password="";
	$dbname="teste2";
	$usertable="aluno";
	$yourfield = "nome";
	
	//conexão	e seleção do banco de dados
	$con = mysqli_connect($hostname, $username, $password, $dbname);
	
	//executa a consulta
	
	$query = "INSERT INTO aluno (nome, senha, sexo, turno, cidade) VALUES ('$nome','$senha','$sexo','$turno','$cidade')";
	$insert = mysqli_query($con,$query);
	
	if($insert){
          echo "Aluno Cadastrado com Sucesso";
        }else{
          echo"Erro";
    }
//Exibe os dados na página de resposta: RespForm1.php
echo "Os dados recebidos do formulário são: <p>";
echo "
<table width = '400' border='1' cellspacing='0' cellpadding='0'>
  <tr>
  <td width = '100'>Nome:<td>
  <td width = '300'>$nome</td>
  </tr>
  <tr>
  <td width = '100'>Senha:<td>
  <td width = '300'>$senha</td>
  </tr>
  <tr>
  <td width = '100'>Sexo:<td>
  <td width = '300'>$sexo</td>
  </tr>
  <tr>
  <td width = '100'>Turno:<td>
  <td width = '300'>$turno</td>
  </tr>
  <tr>
  <td width = '100'>Cidade:<td>
  <td width = '300'>$cidade</td>
  </tr>
  <tr>
  <td width = '100'>Senha:<td>
  <td width = '300'>$senha</td>
  </tr>
  </table>
 ";
?>
<html>
<head><title>Curso de PHP</title>
</head>
<body>
<p><font face="Arial, Helvetica, sans-serif" size="4">
<a href="Form1.html">Clique aqui para voltar ao formulário.</a>
</font>
</body>
</html> 