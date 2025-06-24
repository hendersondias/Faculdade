<?php
	require_once('Config.php');
	
	//Gera String de consulta
	$postdata = http_build_query(
		array(
			'api_token' => $Token
		) );
	
	//Armazena o cabeçalho do html
	$opts = array('http' =>
		array( 'method' => 'POST',
			   'header' => 'Content-type: application/x-www-form-urlencoded',
			   'content' => $postdata ) );
			   
	//cria um contexto de fluxo
	$context = stream_context_create($opts);
	
	//abre arquivo, passando contexto
	$result = file_get_contents('http://'.$servidor.'/Escola/BackEnd/APICursosListaTodos.php', 
	              false, $context );
				  
	//Transforma o JSON em array
	$jsonObj = json_decode( $result );
?>	
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="utf-8">
		<title>Lista Cursos</title>
	</head>
	<body>
		<h1>Lista de Cursos</h1>
		<BR>
		<table class="table" style="font-size: 16px;">
			<tr>
				<th style="text-align:center; width: 20%">ID</th>
				<th style="text-align:center; width: 50%">Nome do Curso</th>
			</tr>
		
<?php	
	foreach ( $jsonObj as $curso )
	{
		echo "<tr>";
			echo "<td style='text-align:left; width: 20%'>$curso->id</td>";
			echo "<td style='text-align:center; width: 50%'>$curso->nome</td>";
		echo "</tr>";	
	}
	
?>
		</table>
	</body>
</html>