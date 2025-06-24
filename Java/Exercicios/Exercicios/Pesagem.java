public class Pesagem
{
     public static void main( String args[] ) {
         
         /*Instancio a classe Pessoas no objeto func1 passando os dados 
          *como parametros. Dessa forma estamos utilizando o construtor
          *que recebe os parametros
          */
        Pessoas func1 = new Pessoas("Fabio da Silva" , 31, 81.0f, 1.77f);
        
        /*Instancio a classe Pessoas no objeto func2, como não foram passados
         * nenumm parametro ele utiliza o construtor que obriga a digitação 
         * dos parametros.
         */
        Pessoas func2 = new Pessoas(); 
        
        /*chama o metodo toString que foi alterado dentro da classe para
         * que exiba os dados do objeto em questão
         */        
        System.out.println( func1.toString() );
        System.out.println( func2.toString() );

     }
}

