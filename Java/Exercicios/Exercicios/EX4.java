import java.util.Scanner; /*Importa a biblioteca para leitura do teclado*/
import java.util.InputMismatchException; /*importa a biblioteca dessa mensagem de erro*/

public class EX4
{
    public static void main( String args[] )
    {
        int num;
        int maior = 0; /*Inicia a variavel onde sera guardado o maior valor com o menor valor possivel*/
        int menor = 9999999; /*Inicia a variavel onde sera guardado o menor valor com um valor bem alto ou o maior valor possivel*/
        Scanner teclado = new Scanner(System.in); /*Instancia o objeto para leitura do teclado*/         
        
        do /*Diferente do while, o do while sempre será executado uma vez, mesmo que a condição não seja verdadeira*/
        {
            System.out.print("Digite um numero: ");
            try {
               num = teclado.nextInt(); /*faz a leitura de um inteiro no teclado*/ 
               if (num > maior) maior = num; /*se o numero digitado for MAIOR que o armazenado na variavel, coloca ele na variavel
                                              *quando um if vai executar apenas um comando, ele pode ser feito sem utilizar {}
                                              */
               if (num < menor && num != 0)  menor = num; /*se o numero digitado for MENOR que o armazenado na variavel, coloca ele na variavel
                                                           * checa tambem se o numero digitado foi 0 para não quardar ele na variavel.
                                                           * 0 só é utilizado para sair do programa.
                                                           */
            }
            catch( InputMismatchException e ) { /*em caso de erro, escreve que o numero é invalido*/
                System.out.println("Digite um numero valido");
                num = 1; /*muda a variavel para 1 fazendo com que ele continue dentro do do while*/
                teclado.next(); /*limpa o buffer do teclado, só é necessario quando da erro*/
            }
        } while (num != 0 ); /*enquando não for digitado 0, fica dendo do do while*/
        
        /* Imprime o menor e o maior valor*/
        System.out.println("o maior valor é " + maior);
        System.out.println("o menor valor é " + menor);
        


        
    }
}
