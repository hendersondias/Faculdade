import java.util.Scanner; /*Importa a biblioteca para leitura do teclado*/
import java.util.InputMismatchException; /*importa a biblioteca dessa mensagem de erro*/

public class EX5
{
    public static void main( String args[] )
    {
        /*inicio as variaveis*/
        int num;
        int maior = 0; /*carrega o menor valor possivel*/
        int menor = 9999999; /*carrega o maior valor possivel*/
        int soma = 0;
        int qtde = 0;
        int somaPar = 0;
        int qtdePar = 0;
        Scanner teclado = new Scanner(System.in);         
        
        do
        {
            System.out.print("Digite um numero: ");
            try {
               num = teclado.nextInt();  
               if (num !=0) { /*se o valor digitado for diferente de zero*/
                   if (num > maior) maior = num; //armazena o maior numero
                   if (num < menor)  menor = num; //armazena o menor numero
                   soma += num; //soma todos so numeros
                   qtde++; //guarda a quantidade de numeros digitados
                   if ( num % 2 == 0 ) { //faz o modulo, para saber se ele é par
                       somaPar += num; //soma apenas os numeros pares
                       qtdePar++; //armazena a quantidade de numeros pares
                   }
                }
            }
            catch( InputMismatchException e ) {  //caso tenha digitado um numero invalido, exibe a mensagem 
                System.out.println("Digite um numero valido");
                num = 1; //põe um valor  na variavel para ele não sair do do while
                teclado.next(); //limpa o buffer do teclado
            }
        } while (num != 0 ); //fica no looping até que seja digitado 0
        
        System.out.println("o maior valor é " + maior); //exibe o maior
        System.out.println("o menor valor é " + menor); //exibe o menor
        System.out.println("A soma dos numeros é:  " + soma); //exibe a soma
        System.out.println("Foram digitados " + qtde + " numeros"); //exibe a quantidade de numeros digitados
        System.out.println("A media é:  " + ((soma*1.0)/qtde) ); // calcula e exibe a media
        System.out.println("A media par é:  " + ((somaPar*1.0)/qtdePar) ); //calcula e exibe a media dos numeros pares
        System.out.println("A % de Impar é:  " + (100-(qtdePar*100.0/qtde) )); /*calcula a quantidade de numeros impares 
                                                                                * utilizamos a quantidade de pares para cacular os impares
                                                                                * se tirarmos a quantidade de pares da quantidade total temos
                                                                                * a quantidade de impares.
                                                                                */
        
                

        
    }
}
