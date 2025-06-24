#include <stdio.h>

int main() {
    int num, soma_pares = 0, produto_impares = 1;

    printf("Digite um número inteiro e positivo (ou zero para sair): ");
    scanf("%d", &num);

    while (num != 0) {
        if (num % 2 == 0) {
            soma_pares += num;
        } else {
            produto_impares *= num;
        }

        printf("Digite um número inteiro e positivo (ou zero para sair): ");
        scanf("%d", &num);
    }

    printf("\nProduto dos números ímpares: %d\n", produto_impares);
    printf("Soma dos números pares: %d\n", soma_pares);

}
