#include <stdio.h>

int main() {
    int a, b, resultado = 0;

    printf("Digite o valor de A: ");
    scanf("%d", &a);

    printf("Digite o valor de B: ");
    scanf("%d", &b);

    for (int i = 1; i <= b; i++) {
        resultado += a;
    }

    printf("O resultado de %d * %d é %d\n", a, b, resultado);

}
