#include <stdio.h>

int main() {
    int A, B;
    printf("Digite o valor de A: ");
    scanf("%d", &A);
    printf("Digite o valor de B: ");
    scanf("%d", &B);
    if (A > B) {
        printf("O maior número é: %d\n", A);
    } else {
        printf("O maior número é: %d\n", B);
    }
}
