#include <stdio.h>

 

int main() {

  float valores[15];
  float maior, menor;

  printf("Digite 15 valores reais:\n");
  for (int i = 0; i < 15; i++) {
    scanf("%f", &valores[i]);
  }

  maior = valores[0];
  menor = valores[0];

  for (int i = 1; i < 15; i++) {
    if (valores[i] > maior) {
      maior = valores[i];
    }

    if (valores[i] < menor) {
      menor = valores[i];
    }
  }

  printf("O maior valor é: %.2f\n", maior);
  printf("O menor valor é: %.2f\n", menor);

}