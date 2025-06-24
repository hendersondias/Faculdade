public class ParOuImparIf {
    public static void main(String[] args) {
        int numero = Integer.parseInt(args[0]);
        if (numero % 2 == 0) {
            System.out.println("O número " + numero + " é par.");
        } else {
            System.out.println("O número " + numero + " é ímpar.");
        }
        try {
            numero = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("O valor informado não é um número inteiro.");
        }
    }
}
