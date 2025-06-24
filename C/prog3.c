#include <stdio.h>

int main() {
    int n;
    int i; 
    int par; 
    int impar; 

    printf("Digite um numero: ");
    scanf("%d", &n); 

    par = 0;
    impar = 1;

    printf("Os %d primeiros numeros pares sao:\n", n);
    for (i = 0; i < n; i++) {
        printf("%d ", par);
        par = par + 2; 
    }

    printf("\nOs %d primeiros numeros impares sao:\n", n);
    for (i = 0; i < n; i++) {
        printf("%d ", impar);
        impar = impar + 2;
    }
}
