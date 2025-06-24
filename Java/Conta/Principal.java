import java.util.Scanner;
// Criando uma classe Principal para testar a classe Conta
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // criando um objeto Scanner para ler dados do teclado

        System.out.println("Digite o número da conta:");
        int numero = sc.nextInt(); // lendo o número da conta

        System.out.println("Digite o nome do titular da conta:");
        sc.nextLine(); // consumindo a quebra de linha pendente do nextInt()
        String titular = sc.nextLine(); // lendo o nome do titular da conta

        Conta c1 = new Conta(numero, titular); // criando um objeto Conta com os dados informados

        System.out.println("Deseja fazer um depósito inicial? (s/n)");
        char opcao = sc.next().charAt(0); // lendo a opção do usuário

        if (opcao == 's' || opcao == 'S') { // se a opção for sim
            System.out.println("Digite o valor do depósito inicial:");
            double valor = sc.nextDouble(); // lendo o valor do depósito inicial
            c1.depositar(valor); // chamando o método depositar do objeto c1 com o valor informado
        }

        c1.mostrarDados(); // chamando o método mostrarDados do objeto c1

        System.out.println("Deseja fazer um depósito? (s/n)");
        opcao = sc.next().charAt(0); // lendo a opção do usuário

        if (opcao == 's' || opcao == 'S') { // se a opção for sim
            System.out.println("Digite o valor do depósito:");
            double valor = sc.nextDouble(); // lendo o valor do depósito
            c1.depositar(valor); // chamando o método depositar do objeto c1 com o valor informado
        }

        c1.mostrarDados(); // chamando o método mostrarDados do objeto c1

        System.out.println("Deseja fazer um saque? (s/n)");
        opcao = sc.next().charAt(0); // lendo a opção do usuário

        if (opcao == 's' || opcao == 'S') { // se a opção for sim
            System.out.println("Digite o valor do saque:");
            double valor = sc.nextDouble(); // lendo o valor do saque
            c1.sacar(valor); // chamando o método sacar do objeto c1 com o valor informado
        }

        c1.mostrarDados(); // chamando o método mostrarDados do objeto c1

        sc.close(); // fechando o objeto Scanner
    }
}
