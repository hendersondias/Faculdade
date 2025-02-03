#include <stdio.h>

int main() {
    int count = 0, count_pares = 0, count_impares = 0;
    float num, soma = 0, soma_pares = 0, maior, menor, media, media_pares, porcentagem_impares;

    printf("Digite um número positivo (ou zero para sair): ");
    scanf("%f", &num);

    if (num != 0) {
        maior = num;
        menor = num;
    }

    while (num != 0) {
        soma += num;
        count++;

        if (num > maior) {
            maior = num;
        }

        if (num < menor) {
            menor = num;
        }

        if ((int)num % 2 == 0) {
            soma_pares += num;
            count_pares++;
        } else {
            count_impares++;
        }

        printf("Digite um número positivo (ou zero para sair): ");
        scanf("%f", &num);
    }

    if (count > 0) {
        media = soma / count;
    }

    if (count_pares > 0) {
        media_pares = soma_pares / count_pares;
    }

    if (count_impares > 0) {
        porcentagem_impares = ((float)count_impares / count) * 100;
    }

    printf("\nSoma de todos os números: %.2f\n", soma);
    printf("Quantidade de números: %d\n", count);
    printf("Média dos números: %.2f\n", media);
    printf("Maior número: %.2f\n", maior);
    printf("Menor número: %.2f\n", menor);
    printf("Média dos números pares: %.2f\n", media_pares);
    printf("Porcentagem de números ímpares: %.2f%%\n", porcentagem_impares);

    return 0;
}
