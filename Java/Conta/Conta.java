// Criando uma classe Conta para representar uma conta bancária
public class Conta {
    // Atributos da classe Conta
    private int numero; // número da conta
    private String titular; // nome do titular da conta
    private double saldo; // saldo atual da conta

    // Construtor da classe Conta
    public Conta(int numero, String titular) {
        this.numero = numero; // atribuindo o número da conta ao atributo numero
        this.titular = titular; // atribuindo o nome do titular ao atributo titular
        this.saldo = 0.0; // iniciando o saldo com zero
    }

    // Métodos da classe Conta
    public int getNumero() { // método para obter o número da conta
        return this.numero;
    }

    public String getTitular() { // método para obter o nome do titular da conta
        return this.titular;
    }

    public void setTitular(String titular) { // método para alterar o nome do titular da conta
        this.titular = titular;
    }

    public double getSaldo() { // método para obter o saldo atual da conta
        return this.saldo;
    }

    public void depositar(double valor) { // método para depositar um valor na conta
        if (valor > 0) { // verificando se o valor é positivo
            this.saldo += valor; // adicionando o valor ao saldo
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) { // método para sacar um valor da conta
        if (valor > 0) { // verificando se o valor é positivo
            double taxa = 3.0; // taxa cobrada pelo banco por cada saque
            if (this.saldo >= valor + taxa) { // verificando se há saldo suficiente para o saque e a taxa
                this.saldo -= (valor + taxa); // subtraindo o valor e a taxa do saldo
                System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else {
            System.out.println("Valor inválido para saque.");
        }
    }

    public void mostrarDados() { // método para mostrar os dados da conta
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Nome do titular: " + this.titular);
        System.out.println("Saldo atual: R$ " + this.saldo);
    }
}

