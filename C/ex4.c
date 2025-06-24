#include <stdio.h>

int main() {
    int A, B, temp;
    printf("Digite o valor de A: ");
    scanf("%d", &A);
    printf("Digite o valor de B: ");
    scanf("%d", &B);
    temp = A;
    A = B;
    B = temp;
    printf("Os valores trocados são: A = %d, B = %d\n", A, B);
}
