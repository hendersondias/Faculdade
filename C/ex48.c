#include <stdio.h>

int main() {
    int num, count = 0;

    for (int i = 1; i <= 15; i++) {
        printf("Digite o número %d: ", i);
        scanf("%d", &num);

        if (num > 30) {
            count++;
        }
    }

    printf("\nQuantidade de números maiores que 30: %d\n", count);

}
