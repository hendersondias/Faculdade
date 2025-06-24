#include <stdio.h>

int main() {
    int idade, sexo, total_habitantes = 1000;
    int count_mulheres_18_25 = 0, count_mulheres_salario_1500 = 0;
    float salario, soma_salarios = 0, media_salario, porcentagem_mulheres_18_25;

    for (int i = 1; i <= total_habitantes; i++) {
        printf("Digite a idade do habitante %d: ", i);
        scanf("%d", &idade);

        printf("Digite o sexo do habitante %d (1 - masculino, 2 - feminino): ", i);
        scanf("%d", &sexo);

        printf("Digite o salário do habitante %d: ", i);
        scanf("%f", &salario);

        soma_salarios += salario;

        if (sexo == 2 && idade >= 18 && idade <= 25) {
            count_mulheres_18_25++;
        }

        if (sexo == 2 && salario <= 1500) {
            count_mulheres_salario_1500++;
        }
    }

    media_salario = soma_salarios / total_habitantes;
    porcentagem_mulheres_18_25 = ((float)count_mulheres_18_25 / total_habitantes) * 100;

    printf("\nMédia de salário do grupo: R$ %.2f\n", media_salario);
    printf("Porcentagem de mulheres com idade entre 18 e 25 anos: %.2f%%\n", porcentagem_mulheres_18_25);
    printf("Quantidade de mulheres com salário até R$1500,00: %d\n", count_mulheres_salario_1500);

}

