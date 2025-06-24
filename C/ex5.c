#include <stdio.h>

int main() {
    float celsius, fahrenheit;
    printf("Digite a temperatura em graus Celsius: ");
    scanf("%f", &celsius);
    fahrenheit = (9 * celsius + 160) / 5;
    printf("A temperatura em graus Fahrenheit é: %.2f\n", fahrenheit);
}
