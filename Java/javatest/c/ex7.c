#include <stdio.h>

int main() {
    char nome[50];
    float salario_fixo, vendas, comissao, salario_final;
    printf("Digite o nome do vendedor: ");
    scanf("%s", nome);
    printf("Digite o salário fixo do vendedor: ");
    scanf("%f", &salario_fixo);
    printf("Digite o total de vendas efetuadas pelo vendedor (em dinheiro): ");
    scanf("%f", &vendas);
    comissao = vendas * 0.15;
    salario_final = salario_fixo + comissao;
    printf("Nome do vendedor: %s\n", nome);
    printf("Salário fixo: %.2f\n", salario_fixo);
    printf("Salário no final do mês: %.2f\n", salario_final);
}
