#include <stdio.h>

int main() {
    float valor1, valor2, soma, subtracao, multiplicacao, divisao;
    printf("Digite o primeiro valor: ");
    scanf("%f", &valor1);
    printf("Digite o segundo valor: ");
    scanf("%f", &valor2);
    soma = valor1 + valor2;
    subtracao = valor1 - valor2;
    multiplicacao = valor1 * valor2;
    divisao = valor1 / valor2;
    printf("A soma dos valores é: %.2f\n", soma);
    printf("A subtração dos valores é: %.2f\n", subtracao);
    printf("A multiplicação dos valores é: %.2f\n", multiplicacao);
    printf("A divisão dos valores é: %.2f\n", divisao);
    return 0;
}
