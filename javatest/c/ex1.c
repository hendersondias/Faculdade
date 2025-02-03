#include <stdio.h>

int main() {
    float valor1, valor2, media;
    printf("Digite o primeiro valor: ");
    scanf("%f", &valor1);
    printf("Digite o segundo valor: ");
    scanf("%f", &valor2);
    media = (valor1 + valor2) / 2;
    printf("A média dos valores é: %.2f\n", media);
    return 0;
}
