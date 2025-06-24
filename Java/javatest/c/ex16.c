#include <stdio.h>

int main() {
    float salario, financiamento;
    printf("Digite o valor do salário: ");
    scanf("%f", &salario);
    printf("Digite o valor do financiamento pretendido: ");
    scanf("%f", &financiamento);
    if (financiamento <= 5 * salario) {
        printf("Financiamento Concedido\n");
    } else {
        printf("Financiamento Negado\n");
    }
    printf("Obrigada por nos consultar\n");
}
