public class Pessoas {
    private String nome;
    private int idade;
    private double peso;
    private double altura;

    public Pessoas(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public void mostrarNome() {
        System.out.println("Nome: " + nome);
    }

    public void mostrarIdade() {
        System.out.println("Idade: " + idade + " anos");
    }

    public void mostrarPeso() {
        System.out.println("Peso: " + peso + " kg");
    }
    
    public void mostrarAltura() {
        System.out.println("Altura: " + altura + " metros");
    }

    public double calcularIMC() {
        if (altura <= 0) {
            System.out.println("Altura inválida para calcular o IMC.");
            return -1;
        }
        return peso / (altura * altura);
    }

    public static void main(String[] args) {
        Pessoas pessoa = new Pessoas("Exemplo Pessoa", 30, 70.5, 1.75);

        pessoa.mostrarNome();
        pessoa.mostrarIdade();
        pessoa.mostrarPeso();
        pessoa.mostrarAltura();

        double imc = pessoa.calcularIMC();
        if (imc != -1) {
            System.out.println("IMC: " + imc);
        }
    }
}
