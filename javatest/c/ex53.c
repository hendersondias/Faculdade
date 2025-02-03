#include <stdio.h>

int main() {
    int num, soma_negativos = 0;

    for (int i = 1; i <= 50; i++) {
        printf("Digite o número %d: ", i);
        scanf("%d", &num);

        if (num < 0) {
            soma_negativos += num;
        }
    }

    printf("\nSomatório dos números negativos: %d\n", soma_negativos);

}
