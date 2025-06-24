<?php
	require_once('Config.php');
	
	//Gera String de consulta
	$postdata = http_build_query(
		array(
			'api_token' => $Token,
			'id' => $_GET['id']
		) );
	
	//Armazena o cabeçalho do html
	$opts = array('http' =>
		array( 'method' => 'POST',
			   'header' => 'Content-type: application/x-www-form-urlencoded',
			   'content' => $postdata ) );
			   
	//cria um contexto de fluxo
	$context = stream_context_create($opts);
	
	//abre arquivo, passando contexto
	$result = file_get_contents('http://'.$servidor.'/Escola/BackEnd/APIClassesListaporID.php', 
	              false, $context );
				  
	//Transforma o JSON em array
	$jsonObj = json_decode( $result );
	
	
	
	//Gera String de consulta
	$postdata2 = http_build_query(
		array(
			'api_token' => $Token
		) );
	
	//Armazena o cabeçalho do html
	$opts2 = array('http' =>
		array( 'method' => 'POST',
			   'header' => 'Content-type: application/x-www-form-urlencoded',
			   'content' => $postdata2 ) );
			   
	//cria um contexto de fluxo
	$context2 = stream_context_create($opts2);
	
	//abre arquivo, passando contexto
	$result2 = file_get_contents('http://'.$servidor.'/Escola/BackEnd/APICursosListaTodos.php', 
	              false, $context2 );
				  
	//Transforma o JSON em array
	$jsonObj2 = json_decode( $result2 );	
	
	
	foreach ( $jsonObj as $classe )
	{
		$nome = $classe->nome;
		$idcurso = $classe->curso_id;
	}
?>	
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="utf-8">
		<title>Alteração de Classes</title>
	</head>
	<body>
		<h1>Altera a classe</h1>
		<BR>
		<form action="GravaAltClasse.php" method="post">
			Descrição: <input type=text name=nome value="<?php echo $nome; ?>"><br>
						
			Cursos: 
			<select name="id_curso">
				<option value=""></option>
				<?php
				foreach ( $jsonObj2 as $curso )
				{
					echo "<option value=$curso->id";
					if ($idcurso == $curso->id)
						echo " selected=selected";
					echo ">$curso->nome</option>";
				}
				?>
			</select><br><br>
			
			<input type=hidden name=id value="<?php echo $_GET['id']; ?>">
			<input type=submit value="Gravar">
			<input type=reset value="Limpar">
		</form>


	</body>
</html>