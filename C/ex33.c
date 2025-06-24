#include <stdio.h>

int main() {
    float salario, soma_salario = 0, maior_salario = 0, media_salario, percentual_menor_2000;
    int filhos, soma_filhos = 0, count = 0, count_menor_2000 = 0, media_filhos;

    printf("Digite o salário (ou zero para sair): ");
    scanf("%f", &salario);

    while (salario != 0) {
        printf("Digite o número de filhos: ");
        scanf("%d", &filhos);

        soma_salario += salario;
        soma_filhos += filhos;
        count++;

        if (salario > maior_salario) {
            maior_salario = salario;
        }

        if (salario < 2000) {
            count_menor_2000++;
        }

        printf("Digite o salário (ou zero para sair): ");
        scanf("%f", &salario);
    }

    if (count > 0) {
        media_salario = soma_salario / count;
        media_filhos = soma_filhos / count;
    }

    if (count_menor_2000 > 0) {
        percentual_menor_2000 = ((float)count_menor_2000 / count) * 100;
    }

    printf("\nMédia de salário da população: R$ %.2f\n", media_salario);
    printf("Média do número de filhos: %d\n", media_filhos);
    printf("Maior salário: R$ %.2f\n", maior_salario);
    printf("Percentual de pessoas com salário menor que R$ 2000,00: %.2f%%\n", percentual_menor_2000);
}
