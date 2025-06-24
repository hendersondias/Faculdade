#include <stdio.h>

int main() {
    float distancia, combustivel, consmedio;
    printf("Digite a distância total percorrida pelo automóvel (em km): ");
    scanf("%f", &distancia);
    printf("Digite o total de combustível gasto (em litros): ");
    scanf("%f", &combustivel);
    consmedio = distancia / combustivel;
    printf("O consumo médio do automóvel é: %.2f km/l\n", consmedio);
}
