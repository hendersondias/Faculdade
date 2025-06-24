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
		<title>Inclusão de Classes</title>
	</head>
	<body>
		<h1>Inclui uma classe</h1>
		<BR>
		<form action="GravanovaClasse.php" method="post">
			Descrição: <input type=text name=nome ><br>
						
			Cursos: 
			<select name="id_curso">
				<option value=""></option>
				<?php
				foreach ( $jsonObj as $curso )
				{
					echo "<option value=$curso->id";
					echo ">$curso->nome</option>";
				}
				?>
			</select><br><br>
			
			<input type=submit value="Incluir">
			<input type=reset value="Limpar">
		</form>


	</body>
</html>