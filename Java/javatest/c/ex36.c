#include <stdio.h>

int main() {
    int sexo, cor_olhos, cor_cabelos, idade;

    printf("Digite o sexo (1 - masculino, 2 - feminino): ");
    scanf("%d", &sexo);

    printf("Digite a cor dos olhos (1 - azuis, 2 - verdes, 3 - castanhos): ");
    scanf("%d", &cor_olhos);

    printf("Digite a cor dos cabelos (1 - louros, 2 - castanhos, 3 - pretos): ");
    scanf("%d", &cor_cabelos);

    printf("Digite a idade: ");
    scanf("%d", &idade);

    printf("\nSexo: %s\n", sexo == 1 ? "Masculino" : "Feminino");

    switch (cor_olhos) {
        case 1:
            printf("Cor dos olhos: Azuis\n");
            break;
        case 2:
            printf("Cor dos olhos: Verdes\n");
            break;
        case 3:
            printf("Cor dos olhos: Castanhos\n");
            break;
    }

    switch (cor_cabelos) {
        case 1:
            printf("Cor dos cabelos: Louros\n");
            break;
        case 2:
            printf("Cor dos cabelos: Castanhos\n");
            break;
        case 3:
            printf("Cor dos cabelos: Pretos\n");
            break;
    }

    printf("Idade: %d\n", idade);
}
