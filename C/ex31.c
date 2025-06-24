#include <stdio.h>

int main() {
    float altura_joao = 1.45;
    float altura_maria = 1.57;
    float crescimento_joao = 0.23;
    float crescimento_maria = 0.15;
    int anos = 0;

    while (altura_joao <= altura_maria) {
        anos++;
        altura_joao += crescimento_joao;
        altura_maria += crescimento_maria;
        printf("Ano %d: João tem %.2f m e Maria tem %.2f m\n", anos, altura_joao, altura_maria);
    }

    printf("Serão necessários %d anos para que João seja mais alto que Maria.\n", anos);
}
