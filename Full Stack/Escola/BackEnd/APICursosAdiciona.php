<?php
	//Cabeçalho informando que é JSON 
	header('Content-Type: application/json');
	
	//Testa se foi chamado pelo metodo POST
	if ($_SERVER['REQUEST_METHOD'] == 'POST' )
	{
		require_once('Config.php');
		
		$api_token = $_POST['api_token'];
		if ($api_token == $Token )
		{
			$nome = $_POST['nome'];
		
			//Conexão ao banco
			require_once('dbConnect.php');
			
			//Define a coleção
			mysqli_set_charset($conn,$charset);
			
			$query = 'INSERT INTO cursos (nome) values ("'.$nome.'")';
			
			//Executa a query
			$result = mysqli_query($conn, $query);
			
			//criando uma array
			$response = array();
			
			//Testa de não deu erro no comando SQL
			if ($result)
			{   //retorna a quantidade de linhas afetadas pelo comando SQL
				if (mysqli_affected_rows($conn) > 0 )
				   $response['incluiu'] = true;					
				else
				   $response['incluiu'] = false;					
				
			}
			else //caso de erro no SQL
				$response['erro'] = "Erro na execução do insert";
				
			//Enviar o array com os dados para a tela
			//em formato json
			echo json_encode($response);
						
		}
		else
		{
			$response['auth_token'] = false;
			echo json_encode($response);
		}
	}

?>