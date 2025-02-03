#include <stdio.h>

int main() {
    float distancia1, tempo1, velocidade1;
    float distancia2, tempo2, velocidade2;

    printf("Digite a distância percorrida pelo carro 1: ");
    scanf("%f", &distancia1);
    printf("Digite o tempo levado pelo carro 1: ");
    scanf("%f", &tempo1);
    velocidade1 = distancia1 / tempo1;

    printf("Digite a distância percorrida pelo carro 2: ");
    scanf("%f", &distancia2);
    printf("Digite o tempo levado pelo carro 2: ");
    scanf("%f", &tempo2);
    velocidade2 = distancia2 / tempo2;

    if (velocidade1 > velocidade2) {
        printf("O carro 1 teve a maior velocidade média.\n");
    } else if (velocidade2 > velocidade1) {
        printf("O carro 2 teve a maior velocidade média.\n");
    }
}
