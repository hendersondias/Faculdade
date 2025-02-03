// Código para ordenar um array usando cycle sort
#include <stdio.h>

// Função para realizar o cycle sort
void cycleSort(int arr[], int n)
{
  // Variáveis para armazenar o elemento atual, sua posição correta e o elemento temporário
  int item, pos, tmp;
  // Variáveis para percorrer o array
  int i, j, k;
  // Loop para cada elemento do array
  for (i = 0; i < n - 1; i++)
  {
    // Inicializa o elemento atual com o elemento na posição i
    item = arr[i];
    // Inicializa a posição correta com i
    pos = i;
    // Loop para comparar o elemento atual com todos os elementos à sua direita
    for (j = i + 1; j < n; j++)
    {
      // Se o elemento à direita for menor que o elemento atual, incrementa a posição correta
      if (arr[j] < item)
        pos++;
    }
    // Se a posição correta for igual à posição atual, ignora o elemento e continua o loop
    if (pos == i)
      continue;
    // Loop para evitar elementos repetidos na posição correta
    while (item == arr[pos])
      pos++;
    // Troca o elemento atual com o elemento na posição correta
    tmp = arr[pos];
    arr[pos] = item;
    item = tmp;
    // Loop para continuar o ciclo até que o elemento atual volte à sua posição original
    while (pos != i)
    {
      // Reinicializa a posição correta com i
      pos = i;
      // Loop para comparar o elemento atual com todos os elementos à sua direita
      for (j = i + 1; j < n; j++)
      {
        // Se o elemento à direita for menor que o elemento atual, incrementa a posição correta
        if (arr[j] < item)
          pos++;
      }
      // Loop para evitar elementos repetidos na posição correta
      while (item == arr[pos])
        pos++;
      // Troca o elemento atual com o elemento na posição correta
      tmp = arr[pos];
      arr[pos] = item;
      item = tmp;
    }
  }
}

// Função para imprimir um array
void printArray(int arr[], int n)
{
  int i;
  for (i = 0; i < n; i++)
    printf("%d ", arr[i]);
  printf("\n");
}

// Função principal para testar o código
int main()
{
  // Array de teste
  int arr[] = {5, 3, 4, 1, 2};
  // Tamanho do array
  int n = sizeof(arr) / sizeof(arr[0]);
  // Imprime o array original
  printf("Array original: ");
  printArray(arr, n);
  // Ordena o array usando cycle sort
  cycleSort(arr, n);
  // Imprime o array ordenado
  printf("Array ordenado: ");
  printArray(arr, n);
  return 0;
}