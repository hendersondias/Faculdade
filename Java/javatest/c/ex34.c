#include <stdio.h>

int main() {
    int num_carteira, num_multas, maior_num_multas = 0, carteira_maior_num_multas;
    float valor_multa, soma_multas = 0, soma_total = 0;

    printf("Digite o número da carteira de motorista (ou zero para sair): ");
    scanf("%d", &num_carteira);

    while (num_carteira != 0) {
        printf("Digite o número de multas: ");
        scanf("%d", &num_multas);

        if (num_multas > maior_num_multas) {
            maior_num_multas = num_multas;
            carteira_maior_num_multas = num_carteira;
        }

        soma_multas = 0;

        for (int i = 1; i <= num_multas; i++) {
            printf("Digite o valor da multa %d: ", i);
            scanf("%f", &valor_multa);
            soma_multas += valor_multa;
        }

        printf("Valor da dívida do motorista com carteira %d: R$ %.2f\n", num_carteira, soma_multas);

        soma_total += soma_multas;

        printf("Digite o número da carteira de motorista (ou zero para sair): ");
        scanf("%d", &num_carteira);
    }

    printf("\nTotal de recursos arrecadados: R$ %.2f\n", soma_total);
    printf("Número da carteira do motorista com maior número de multas: %d\n", carteira_maior_num_multas);
}
