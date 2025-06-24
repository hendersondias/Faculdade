#include <stdio.h>
#include <math.h>

int main() {
    float a, b, c;
    float delta; 
    float x1, x2; 

    printf("Digite os valores de a, b e c: ");
    scanf("%f %f %f", &a, &b, &c);

    delta = pow(b, 2) - 4 * a * c;

    if (delta > 0) {
        x1 = (-b + sqrt(delta)) / (2 * a);
        x2 = (-b - sqrt(delta)) / (2 * a);

        printf("As raízes da equação são: %.2f e %.2f\n", x1, x2);
    } else if (delta == 0) {
        x1 = -b / (2 * a);

        printf("A raiz da equação é: %.2f\n", x1);
    } else {
        printf("A equação não possui raízes reais.\n");
    }
}