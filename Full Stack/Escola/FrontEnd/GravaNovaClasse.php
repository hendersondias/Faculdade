<?php
	require_once('Config.php');
	
	//Gera String de consulta
	$postdata = http_build_query(
		array(
			'api_token' => $Token,
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
	$result = file_get_contents('http://'.$servidor.'/Escola/BackEnd/APIClassesAdiciona.php', 
	              false, $context );
				  
	//Transforma o JSON em array
	$jsonObj = json_decode( $result );
?>	
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="utf-8">
		<title>Inclusão de Classes</title>
	</head>
	<body>
<?php


	
	if ($jsonObj->incluiu)
	{
		echo "Registro incluido";
	}
	else
	{
		echo "Erro na inclusão";
	}
?>


	</body>
</html>