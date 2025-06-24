<?php
	require_once('Config.php');
	
	//Gera String de consulta
	$postdata = http_build_query(
		array(
			'api_token' => $Token,
			'id' => $_POST['id'],
			'nome' => $_POST['nome'],
			'idcurso' => $_POST['id_curso'],
		) );
	
	//Armazena o cabeçalho do html
	$opts = array('http' =>
		array( 'method' => 'POST',
			   'header' => 'Content-type: application/x-www-form-urlencoded',
			   'content' => $postdata ) );
			   
	//cria um contexto de fluxo
	$context = stream_context_create($opts);
	
	//abre arquivo, passando contexto
	$result = file_get_contents('http://'.$servidor.'/Escola/BackEnd/APIClassesAltera.php', 
	              false, $context );
				  
	//Transforma o JSON em array
	$jsonObj = json_decode( $result );
?>	
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="utf-8">
		<title>Alteração de Classes</title>
	</head>
	<body>
<?php


	
	if ($jsonObj->alterou)
	{
		echo "Registro alterado";
	}
	else
	{
		echo "Erro na alteracao";
	}
?>


	</body>
</html>