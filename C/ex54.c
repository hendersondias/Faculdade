#include <stdio.h>

int main() {
    int num, count_intervalo = 0, count_fora_intervalo = 0;

    for (int i = 1; i <= 10; i++) {
        printf("Digite o número %d: ", i);
        scanf("%d", &num);

        if (num >= 10 && num <= 20) {
            count_intervalo++;
        } else {
            count_fora_intervalo++;
        }
    }

    printf("\nQuantidade de números no intervalo [10,20]: %d\n", count_intervalo);
    printf("Quantidade de números fora do intervalo [10,20]: %d\n", count_fora_intervalo);

}
