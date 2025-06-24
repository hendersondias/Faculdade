 <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $nome = $_POST['nome'];
        $area = $_POST['area'];

        echo "<h2>Obrigado, $nome. Aqui estão as vagas disponíveis na área de $area:</h2>";

        switch ($area) {
            case 'analise':
                echo "<ul>
                        <li>Analista de Sistemas</li>
                        <li>Engenheiro de Software</li>
                      </ul>";
                break;
            case 'infraestrutura':
                echo "<ul>
                        <li>Analista de Redes</li>
                        <li>Coordenador de Equipes</li>
                      </ul>";
                break;
            case 'desenvolvimento':
                echo "<ul>
                        <li>Programador PHP</li>
                        <li>Programador Python</li>
                      </ul>";
                break;
            default:
                echo "Por favor, selecione uma área de interesse.";
        }
    }
    ?>