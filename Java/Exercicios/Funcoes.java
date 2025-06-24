import java.util.Scanner; /*Importa a biblioteca para leitura do teclado*/
import java.util.InputMismatchException; /*importa a biblioteca de erro de valores*/

public class Funcoes
{
    /* Metodo estatico para digicao de valor inteiro ele recebe dois textos:
     * 1 - a string que sera exibida pedindo para o usuario digitar algo
     * 2 - A mensagem de erro que será exibida caso seja digitado um valor invalido
     */
    static int digitaInt( String texto, String erro ){
        int valor = 0; /*variavel onde sera gravado o valor digitado*/
        int controle = 0; /*Variavel de controle para saber se deu erro ou não*/
        Scanner teclado = new Scanner(System.in); /* Instancia o objeto teclado para receber os valores digitados*/
        while (controle == 0){ /*só sai do looping quando tiver digitado um valor válido - controle diferente de 0*/
            try {
                controle = 1; /*seta 1 em controle*/
                System.out.print(texto); /*Exibe o texto recebido pedindo para digitar algo*/
                valor = teclado.nextInt(); /*faz a leitura do teclado e grava na variavel valor*/
            }
            catch( InputMismatchException e ){ /*se deu erro, entra nesse codigo*/
                System.out.println(erro); /*exibe a mensagem de erro desejada*/
                controle = 0; /*seta o controle em 0, indicando que teve erro*/
                teclado.next(); /*Limpa o buffer do teclado para nova leitura, necessário apenas quando da erro*/
            }
         }
        return valor;
    }

    /*Metodo estatico para digicao de valor float ele recebe dois textos
     * 1 - a string que sera exibida pedindo para o usuario digitar algo
     * 2 - A mensagem de erro que será exibida caso seja digitado um valor invalido
     * Obs.: não comentei as linhas pois é identico ao metodo digitaInt trocando apenas o campo int por float
     */
    static float digitaFloat( String texto, String erro ){
        float valor = 0.0f;
        int controle = 0;
        Scanner teclado = new Scanner(System.in); 
        while (controle == 0){
            try {
                controle = 1;
                System.out.print(texto);
                valor = teclado.nextFloat();
             }
            catch( InputMismatchException e ){
                System.out.println(erro);
                controle = 0;
                teclado.next();
            }
        }
        return valor;
    }
    
    static boolean is_even( int number ){
        if (number == 1) 
            return false;
        if (number == 0 )
            return true;
            
        return is_even( number-2);    
    }
}


