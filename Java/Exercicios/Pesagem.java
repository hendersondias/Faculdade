import java.util.ArrayList;
import java.util.Scanner;

public class Pesagem
{
     public static void main( String args[] ) {
        ArrayList<Pessoas> listaPessoas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in); 
         
        int opc = 0;
        int loc;
        
        do {
            opc = Funcoes.digitaInt( "\nDigite: \n1- para adicionar \n2- para localizar\n" +
                             "3- Lista os nomes\n4- para excluir\n0- para sair \nOpção: ",
                             "digite uma opção valida!" );
            switch (opc){
                case 0:                    
                    break;
                case 1:
                    listaPessoas.add( new Pessoas() ); 
                    break;
                case 2:    
                    loc = localizaPessoa( listaPessoas, 1 );
                    if ( loc != -1 )
                       System.out.println( listaPessoas.get(loc).toString() );
                    else
                       System.out.println( "Nome não encontrado!");
                    break; 
                case 3:
                    for ( int i=0; i<listaPessoas.size(); i++ ){
                        System.out.println( listaPessoas.get(i).getNome() );
                    }
                    break;
                case 4:
                    loc = localizaPessoa( listaPessoas, 2 );
                    if ( loc != -1 )
                       listaPessoas.remove(loc);
                    else
                       System.out.println( "Nome não encontrado! Impossivel apagar!");
                    break;                     
                default:
                    System.out.println("digite uma opção válida!");
                    break;
            }
                       
            
        } while ( opc != 0 );
        
        

     }
     
     static int localizaPessoa( ArrayList<Pessoas> listPess, int op ) {
         Scanner teclado = new Scanner(System.in); 
         if (op == 1)
            System.out.print( "Nome para localizar:" );
         else 
            System.out.print( "Nome que deseja excluir:" );
         String nome = teclado.nextLine();
         int ret = -1;
         
         for( int i=0; i < listPess.size(); i++ ){
             if ( listPess.get(i).getNome().equals( nome ) ) {
                 ret = i;
                 break;
             }
         }
         
         return ret;
     }
}

