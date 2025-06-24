#include <stdio.h>

int main() {
    int codigo, total_produtos = 100;
    float preco_custo, preco_novo, soma_precos = 0, soma_precos_novos = 0, media_precos, media_precos_novos;

    for (int i = 1; i <= total_produtos; i++) {
        printf("Digite o código do produto %d: ", i);
        scanf("%d", &codigo);

        printf("Digite o preço de custo do produto %d: ", i);
        scanf("%f", &preco_custo);

        preco_novo = preco_custo * 1.2;
        soma_precos += preco_custo;
        soma_precos_novos += preco_novo;

        printf("Código do produto: %d\n", codigo);
        printf("Preço novo do produto: R$ %.2f\n\n", preco_novo);
    }

    media_precos = soma_precos / total_produtos;
    media_precos_novos = soma_precos_novos / total_produtos;

    printf("\nMédia dos preços sem aumento: R$ %.2f\n", media_precos);
    printf("Média dos preços com aumento: R$ %.2f\n", media_precos_novos);
}
