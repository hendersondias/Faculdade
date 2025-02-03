public class ParOuImparSwitch {
    public static void main(String[] args) {
        int numero = Integer.parseInt(args[0]);
        switch (numero % 2) {
            case 0:
                System.out.println("O número " + numero + " é par.");
                break;
            case 1:
                System.out.println("O número " + numero + " é ímpar.");
                break;
            default:
                System.out.println("O valor informado não é um número inteiro.");
                break;
        }
    }
}
