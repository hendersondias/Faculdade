#include <stdio.h>
#include <stdbool.h>

bool nprimo(int x) {
    if (x < 2) {
        return false;
    }
    for (int i = 2; i < x; i++) {
        if (x % i == 0) {
            return false;
        }
    }
    return true;
}

int main() {
    int n; 
    int cont = 0; 
    int num = 2; 

    printf("Digite o valor de n: ");
    scanf("%d", &n);

    for (num = 2; cont < n; num++) {
        if (nprimo(num)) {
            printf("%d ", num);
            cont++;
        }
    }
    printf("\n");
}
