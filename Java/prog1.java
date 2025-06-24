import java.util.Scanner;

public class prog1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int val;
        do {
            System.out.print("Insira um número: ");
            val = scanner.nextInt();
            if (val != 0) {
                if (val < min) {
                    min = val;
                }
                if (val > max) {
                    max = val;
                }
            }
        } while (val != 0);
        System.out.println("O menor valor é: " + min);
        System.out.println("O maior valor é: " + max);
    }
}
