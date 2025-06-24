/*Esse ecxercicio é igual ao Ex1 mas utilizando switch case no lugar do if
 * 
 */
public class Ex2
{
    public static void main( String args[]) {
        int num1;
        try {
            num1 = Integer.parseInt( args[0] );
            
            int resultado = num1 % 2;
            switch ( resultado ) 
            {
                case 0: 
                    System.out.println( "O numero é par" );
                    break;
                case 1:
                    System.out.println( "O numero é impar" );
                    break;
            }
 
        }
        catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println("Numero de paramentros invalido!");
        }
        catch ( NumberFormatException e ) 
        {
            System.out.println("Informe apenas numeros inteiros!");
        }   
    }
}
