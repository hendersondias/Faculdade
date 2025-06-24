#include <stdio.h>

int main() {
    float custo_fabrica, custo_consumidor;
    printf("Digite o custo de fábrica do carro: ");
    scanf("%f", &custo_fabrica);
    custo_consumidor = custo_fabrica * (1 + 0.45) * (1 + 0.28);
    printf("O custo ao consumidor do carro é: %.2f\n", custo_consumidor);
    
}
