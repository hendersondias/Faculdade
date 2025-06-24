#include <stdio.h>

int main() {
    float deposito, rendimento, valor_final;
    printf("Digite o valor depositado: ");
    scanf("%f", &deposito);
    rendimento = deposito * 0.007;
    valor_final = deposito + rendimento;
    printf("O valor com rendimento após um mês é: %.2f\n", valor_final);
}
