#include <stdio.h>

int main() {
    float nota1, nota2, media_final;
    printf("Digite a primeira nota parcial: ");
    scanf("%f", &nota1);
    printf("Digite a segunda nota parcial: ");
    scanf("%f", &nota2);
    media_final = (nota1 + nota2) / 2;
    if (media_final >= 7) {
        printf("Parabéns! Você passou direto com média final %.2f.\n", media_final);
    } else if (media_final < 4) {
        printf("Infelizmente você foi reprovado direto com média final %.2f.\n", media_final);
    } else {
        float nota_necessaria = 10 - media_final;
        printf("Você vai à final e precisa tirar %.2f para passar.\n", nota_necessaria);
    }
}
