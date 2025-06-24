#include <stdio.h>

 
int fibonacci(int n) {
  if (n == 1 || n == 2) {
    return 1;
  }

  else {
    return fibonacci(n-1) + fibonacci(n-2);
  }
}

 

int main() {
 
  int n;

  printf("Digite o número de termos da sequência de Fibonacci:\n");
  scanf("%d", &n);

  printf("Os %d primeiros termos da sequência de Fibonacci são:\n", n);

  for (int i = 1; i <= n; i++) {
    printf("%d ", fibonacci(i));
  }

 
  printf("\n");

}