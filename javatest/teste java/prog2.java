import java.util.Scanner;

public class prog2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0, cont = 0, cont1 = 0, cont2 = 0,cont3 = 0, val;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        do {
            System.out.print("Insira um número: ");
            val = scanner.nextInt();
            if (val != 0) {
                sum += val;
                cont++;
                if (val < min) {
                    min = val;
                }
                if (val > max) {
                    max = val;
                }
                if (val % 2 == 0) {
                    cont1 += val;
                    cont2++;
                } else {
                    cont3++;
                }
            }
        } while (val != 0);
        double media = (double) sum / cont;
        double mediadig = (double) cont1 / cont2;
        double mediaporc = (double) cont3 / cont * 100;
        System.out.println("A soma de todos os números digitados é: " + sum);
        System.out.println("A quantidade de números digitados é: " + cont);
        System.out.println("A média dos números digitados é: " + media);
        System.out.println("O maior número digitado é: " + max);
        System.out.println("O menor número digitado é: " + min);
        System.out.println("A média dos números pares digitados é: " + mediadig);
        System.out.println("A porcentagem de números ímpares digitados é: " + mediaporc + "%");
    }
}
