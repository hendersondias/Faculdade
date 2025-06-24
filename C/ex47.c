#include <stdio.h>
#include <math.h>

int main() {
    int num;

    for (int i = 1; i <= 10; i++) {
        printf("Digite o número %d: ", i);
        scanf("%d", &num);

        printf("O cubo de %d é %.0f\n", num, pow(num, 3));
    }
}
