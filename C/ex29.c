#include <stdio.h>

int main() {
    int valor, maior, menor;
    int primeiro = 1; 

    printf("Digite valores (0 para sair):\n");

    while (1) {
        printf("Digite um valor: ");
        scanf("%d", &valor);

        if (valor == 0) {
            break;
        }

        if (primeiro) {
            maior = valor;
            menor = valor;
            primeiro = 0;
        } else {
            if (valor > maior) {
                maior = valor;
            }
            if (valor < menor) {
                menor = valor;
            }
        }
    }

    if (primeiro) {
        printf("Nenhum valor foi inserido.\n");
    } else {
        printf("Maior valor inserido: %d\n", maior);
        printf("Menor valor inserido: %d\n", menor);
    }

}
