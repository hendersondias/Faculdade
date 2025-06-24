public class EX3
{
    public static void main( String args[] )
    {
        int num = 0;
        int eNumero = 1;/*essa variável é utilizada para saber se deu algum erro*/
        try
        {
            num = Integer.parseInt( args[0] );
        }
        catch ( NumberFormatException e ) 
        { 
           eNumero = 0; /*se der erro muda a variavel para 0*/
        }    
        catch ( ArrayIndexOutOfBoundsException e ) 
        {
             eNumero = 0;
        }
        
        if ( eNumero == 1 ) /*se a variavel for 1 quer dizer que não tivemos erro, portando podemos testar se o numero é positivo*/
        {
            if ( num >= 0 ) /*se for maior que 0 é positivo*/
            {
               System.out.println("É um numero positivo");
            }
            else { /*caso seja menor que 0 é negativo*/
               System.out.println("É um numero negativo");
            }
        }
        else /* se deu erro, mostra uma mensagem falando que não foi digitado um numero*/
           System.out.println("Não é numero");
    }
}
