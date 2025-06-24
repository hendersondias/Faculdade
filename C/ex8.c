#include <stdio.h>

int main() {
    float cotacao_dolar, dolares, reais;
    printf("Digite a cotação do dólar: ");
    scanf("%f", &cotacao_dolar);
    printf("Digite a quantidade de dólares disponíveis: ");
    scanf("%f", &dolares);
    reais = dolares * cotacao_dolar;
    printf("O valor da conversão em real é: R$ %.2f\n", reais);
}
