import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menor = Integer.MAX_VALUE;
        int maior = Integer.MIN_VALUE;
        int valor;

        System.out.println("Digite valores até que 0 seja inserido:");

        do {
            valor = sc.nextInt();

            if (valor != 0) {
                if (valor < menor) {
                    menor = valor;
                }
                if (valor > maior) {
                    maior = valor;
                }
            }
        } while (valor != 0);

        System.out.println("O menor valor digitado foi: " + menor);
        System.out.println("O maior valor digitado foi: " + maior);

        sc.close();
    }
}