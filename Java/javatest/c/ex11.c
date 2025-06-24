#include <stdio.h>

int main() {
    float preco_custo, percentual_acrescimo, valor_venda;
    printf("Digite o preço de custo do produto: ");
    scanf("%f", &preco_custo);
    printf("Digite o percentual de acréscimo: ");
    scanf("%f", &percentual_acrescimo);
    valor_venda = preco_custo * (1 + percentual_acrescimo / 100);
    printf("O valor de venda do produto é: %.2f\n", valor_venda);
}
