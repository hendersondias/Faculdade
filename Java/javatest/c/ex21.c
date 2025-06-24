#include <stdio.h>

int main() {
    float salario_fixo, vendas, salario_final;
    int faltas;
    printf("Digite o valor da parte fixa do salário: ");
    scanf("%f", &salario_fixo);
    printf("Digite o total de vendas no período: ");
    scanf("%f", &vendas);
    printf("Digite o número de faltas: ");
    scanf("%d", &faltas);

    float comissao;
    if (vendas <= 1500) {
        comissao = vendas * 0.02;
    } else if (vendas <= 3000) {
        comissao = vendas * 0.03;
    } else if (vendas <= 6000) {
        comissao = vendas * 0.05;
    } else {
        comissao = vendas * 0.06;
    }

    float desconto = faltas * 5;

    salario_final = salario_fixo + comissao - desconto;

    printf("O salário final do vendedor é: %.2f\n", salario_final);
}
