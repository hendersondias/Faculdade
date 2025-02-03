#include <stdio.h>

int main() {
    float valor_compra, valor_prestacao;
    printf("Digite o valor da compra: ");
    scanf("%f", &valor_compra);
    valor_prestacao = valor_compra / 5;
    printf("O valor de cada prestação é: %.2f\n", valor_prestacao);
}
