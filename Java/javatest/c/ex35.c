#include <stdio.h>

int main() {
    int num, count = 0;

    printf("Digite um número (ou zero para sair): ");
    scanf("%d", &num);

    while (num != 0) {
        if (num >= 100 && num <= 200) {
            count++;
        }

        printf("Digite um número (ou zero para sair): ");
        scanf("%d", &num);
    }

    printf("\nQuantidade de números entre 100 e 200: %d\n", count);
}
