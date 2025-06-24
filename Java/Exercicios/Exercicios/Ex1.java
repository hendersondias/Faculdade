public class Ex1
{
    public static void main( String args[]) {
        int num1;
        try { /*Se der algum erro no codigo dentro dessa chave, trate-o*/
            num1 = Integer.parseInt( args[0] ); /*le o argumento recebido ao executar o programa*/
            
            int resultado = num1 % 2; /*calcula o modulo do numero recebido, módulo retorna o resto da divisão de inteiros*/
            if (resultado == 0 ) {
                System.out.println( "O numero é par" );
            }
            else {
                System.out.println( "O numero é impar" );
            }
        }
        catch ( ArrayIndexOutOfBoundsException e ) { /*se deu erro de quantidade de parametros invalidos, executa esse codigo*/
            System.out.println("Numero de paramentros invalido!");
        }
        catch ( NumberFormatException e ) /*se foi informado algum caracter que não seja numero, executa esse codigo*/
        {
            System.out.println("Informe apenas numeros inteiros!");
        }   
    }
}
