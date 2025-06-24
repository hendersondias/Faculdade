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
			$id = $_POST['id'];
			$nome = $_POST['nome'];
		
			//Conexão ao banco
			require_once('dbConnect.php');
			
			//Define a coleção
			mysqli_set_charset($conn,$charset);
			
			$query = 'UPDATE cursos SET nome = "'.$nome.'" WHERE id = '. $id;
			
			//Executa a query
			$result = mysqli_query($conn, $query);
			
			//criando uma array
			$response = array();
			
			//Testa de não deu erro no comando SQL
			if ($result)
			{   //retorna a quantidade de linhas afetadas pelo comando SQL
				if (mysqli_affected_rows($conn) > 0 )
				   $response['alterou'] = true;					
				else
				   $response['alterou'] = false;					
				
			}
			else //caso de erro no SQL
				$response['erro'] = "Erro na execução do update";
				
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