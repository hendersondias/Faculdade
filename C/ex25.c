#include <stdio.h>

int main() {
    int numero;
    char escolha;

    do {
        printf("Digite um número entre 0 e 5: ");
        scanf("%d", &numero);

        if (numero >= 0 && numero <= 5) {
            printf("Deseja os numerais em inglês (I) ou português (P)? ");
            scanf(" %c", &escolha);

            if (escolha == 'I' || escolha == 'i') {
                switch (numero) {
                    case 0:
                        printf("Zero\n");
                        break;
                    case 1:
                        printf("One\n");
                        break;
                    case 2:
                        printf("Two\n");
                        break;
                    case 3:
                        printf("Three\n");
                        break;
                    case 4:
                        printf("Four\n");
                        break;
                    case 5:
                        printf("Five\n");
                        break;
                    default:
                        printf("Número inválido.\n");
                        break;
                }
            } else if (escolha == 'P' || escolha == 'p') {
                switch (numero) {
                    case 0:
                        printf("Zero\n");
                        break;
                    case 1:
                        printf("Um\n");
                        break;
                    case 2:
                        printf("Dois\n");
                        break;
                    case 3:
                        printf("Três\n");
                        break;
                    case 4:
                        printf("Quatro\n");
                        break;
                    case 5:
                        printf("Cinco\n");
                        break;
                    default:
                        printf("Número inválido.\n");
                        break;
                }
            } else {
                printf("Escolha inválida. Digite 'I' para inglês ou 'P' para português.\n");
            }
        } else {
            printf("Número fora do intervalo permitido (0 a 5).\n");
        }

        printf("Deseja continuar (S/N)? ");
        scanf(" %c", &escolha);

    } while (escolha == 'S' || escolha == 's');

}
