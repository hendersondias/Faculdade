#include <stdio.h>

int main() {
    int idade, maior_idade = 0, count_feminino = 0;
    int sexo, cor_olhos, cor_cabelos;

    printf("Digite a idade (ou um número negativo para sair): ");
    scanf("%d", &idade);

    while (idade >= 0) {
        if (idade > maior_idade) {
            maior_idade = idade;
        }

        printf("Digite o sexo (1 - masculino, 2 - feminino): ");
        scanf("%d", &sexo);

        printf("Digite a cor dos olhos (1 - azuis, 2 - verdes, 3 - castanhos): ");
        scanf("%d", &cor_olhos);

        printf("Digite a cor dos cabelos (1 - louros, 2 - castanhos, 3 - pretos): ");
        scanf("%d", &cor_cabelos);

        if (sexo == 2 && idade >= 18 && idade <= 35 && cor_olhos == 2 && cor_cabelos == 1) {
            count_feminino++;
        }

        printf("Digite a idade (ou um número negativo para sair): ");
        scanf("%d", &idade);
    }

    printf("\nMaior idade dos habitantes: %d\n", maior_idade);
    printf("Quantidade de indivíduos do sexo feminino com idade entre 18 e 35 anos e que tenham olhos verdes e cabelos louros: %d\n", count_feminino);

}
