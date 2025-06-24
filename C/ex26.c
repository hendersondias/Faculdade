#include <stdio.h>

int main() {
    int num1, num2, operacao;
    
    printf("Digite o primeiro número inteiro: ");
    scanf("%d", &num1);
    
    printf("Digite o segundo número inteiro: ");
    scanf("%d", &num2);
    
    printf("Escolha a operação (1 para adição, 2 para subtração, 3 para multiplicação, 4 para divisão): ");
    scanf("%d", &operacao);

    switch (operacao) {
        case 1:
            printf("Resultado da adição: %d\n", num1 + num2);
            break;
        case 2:
            printf("Resultado da subtração: %d\n", num1 - num2);
            break;
        case 3:
            printf("Resultado da multiplicação: %d\n", num1 * num2);
            break;
        case 4:
            if (num2 != 0) {
                printf("Resultado da divisão: %.2f\n", (float)num1 / num2);
            } else {
                printf("Erro: divisão por zero!\n");
            }
            break;
        default:
            printf("Operação inválida. Por favor, escolha uma operação válida.\n");
            break;
    }
}
