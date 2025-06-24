#include <stdio.h>

int main() {
    int numero;

    while (1) {
        printf("Digite um número (ou 0 para sair): ");
        scanf("%d", &numero);

        if (numero == 0) {
            break; // Sai do loop quando 0 é digitado
        }

        int dobro = numero * 2;
        printf("O dobro de %d é %d\n", numero, dobro);
    }

}
