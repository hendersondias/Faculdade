#include <stdio.h>

int main() {
    float celsius, fahrenheit;

    printf("Fahrenheit | Celsius\n");
    printf("--------------------\n");

    for (fahrenheit = 40; fahrenheit <= 80; fahrenheit++) {
        celsius = 5.0 / 9.0 * (fahrenheit - 32);
        printf("%10.1f | %6.1f\n", fahrenheit, celsius);
    }
}
