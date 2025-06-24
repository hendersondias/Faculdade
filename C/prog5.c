#include <stdio.h>

int main() {
    int n;
    int soma_pares = 0;
    int soma_impares = 0;
    int num = 0; 


    printf("Digite o valor de n: ");
    scanf("%d", &n);

    for (int i = 0; i < n && num <= 1000; i++) {
        printf("Digite um número inteiro positivo: ");
        scanf("%d", &num);

        if (num % 2 == 0) {
            soma_pares += num;
        } else {
            soma_impares += num;
        }
    }

    printf("A soma dos números pares é %d\n", soma_pares);
    printf("A soma dos números ímpares é %d\n", soma_impares);

}
