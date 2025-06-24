public class Pesagem {

    public static void main(String[] args) {
        Pessoas pessoa1 = new Pessoas("Exemplo1", 25, 75.0, 1.80);
        Pessoas pessoa2 = new Pessoas("Exemplo2", 30, 62.5, 1.65);

        System.out.println("Dados da pessoa 1:");
        pessoa1.mostrarNome();
        pessoa1.mostrarIdade();
        pessoa1.mostrarPeso();
        pessoa1.mostrarAltura();

        double imcPessoa1 = pessoa1.calcularIMC();
        if (imcPessoa1 != -1) {
            System.out.println("IMC: " + imcPessoa1);
            interpretarIMC(imcPessoa1);
        }

        System.out.println("\nDados da pessoa 2:");
        pessoa2.mostrarNome();
        pessoa2.mostrarIdade();
        pessoa2.mostrarPeso();
        pessoa2.mostrarAltura();

        double imcPessoa2 = pessoa2.calcularIMC();
        if (imcPessoa2 != -1) {
            System.out.println("IMC: " + imcPessoa2);
            interpretarIMC(imcPessoa2);
        }
    }

    public static void interpretarIMC(double imc) {
        if (imc < 16) {
            System.out.println("Situação: Magreza grave");
        } else if (imc >= 16 && imc < 17) {
            System.out.println("Situação: Magreza moderada");
        } else if (imc >= 17 && imc < 18.5) {
            System.out.println("Situação: Magreza leve");
        } else if (imc >= 18.5 && imc < 25) {
            System.out.println("Situação: Saudável");
        } else if (imc >= 25 && imc < 30) {
            System.out.println("Situação: Sobrepeso");
        } else if (imc >= 30 && imc < 35) {
            System.out.println("Situação: Obesidade grau I");
        } else if (imc >= 35 && imc < 40) {
            System.out.println("Situação: Obesidade grau II (severa)");
        } else {
            System.out.println("Situação: Obesidade grau III (mórbida)");
        }
    }
}
