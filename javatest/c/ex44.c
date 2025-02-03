#include <stdio.h>

int main() {
    int sexo, idade, total_habitantes = 2000;
    int count_mulheres = 0, count_homens = 0, count_18_35 = 0;
    float altura, soma_idades = 0, soma_alturas_mulheres = 0, soma_idades_homens = 0;
    float media_idade, media_altura_mulheres, media_idade_homens, percentual_18_35;

    for (int i = 1; i <= total_habitantes; i++) {
        printf("Digite o sexo do habitante %d (0 - feminino, 1 - masculino): ", i);
        scanf("%d", &sexo);

        printf("Digite a idade do habitante %d: ", i);
        scanf("%d", &idade);

        printf("Digite a altura do habitante %d: ", i);
        scanf("%f", &altura);

        soma_idades += idade;

        if (sexo == 0) {
            count_mulheres++;
            soma_alturas_mulheres += altura;
        } else {
            count_homens++;
            soma_idades_homens += idade;
        }

        if (idade >= 18 && idade <= 35) {
            count_18_35++;
        }
    }

    media_idade = soma_idades / total_habitantes;

    if (count_mulheres > 0) {
        media_altura_mulheres = soma_alturas_mulheres / count_mulheres;
    }

    if (count_homens > 0) {
        media_idade_homens = soma_idades_homens / count_homens;
    }

    percentual_18_35 = ((float)count_18_35 / total_habitantes) * 100;

    printf("\nMédia da idade do grupo: %.2f\n", media_idade);
    printf("Média da altura das mulheres: %.2f\n", media_altura_mulheres);
    printf("Média da idade dos homens: %.2f\n", media_idade_homens);
    printf("Percentual de pessoas com idade entre 18 e 35 anos: %.2f%%\n", percentual_18_35);
}
