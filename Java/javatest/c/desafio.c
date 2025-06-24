#include <stdio.h>
#include <stdlib.h>

// Função que ordena os dígitos de um número em ordem decrescente
int ordenarDec(int n) {
    int d[4]; // vetor para armazenar os dígitos
    int i, j, aux; // variáveis auxiliares
    // Separar os dígitos do número e colocar no vetor
    for (i = 0; i < 4; i++) {
        d[i] = n % 10;
        n = n / 10;
    }
    // Ordenar o vetor em ordem decrescente usando o método da bolha
    for (i = 0; i < 3; i++) {
        for (j = i + 1; j < 4; j++) {
            if (d[i] < d[j]) {
                aux = d[i];
                d[i] = d[j];
                d[j] = aux;
            }
        }
    }
    // Reconstruir o número a partir do vetor ordenado
    n = 0;
    for (i = 0; i < 4; i++) {
        n = n * 10 + d[i];
    }
    return n;
}

// Função que ordena os dígitos de um número em ordem crescente
int ordenarCres(int n) {
    int d[4]; // vetor para armazenar os dígitos
    int i, j, aux; // variáveis auxiliares
    // Separar os dígitos do número e colocar no vetor
    for (i = 0; i < 4; i++) {
        d[i] = n % 10;
        n = n / 10;
    }
    // Ordenar o vetor em ordem crescente usando o método da bolha
    for (i = 0; i < 3; i++) {
        for (j = i + 1; j < 4; j++) {
            if (d[i] > d[j]) {
                aux = d[i];
                d[i] = d[j];
                d[j] = aux;
            }
        }
    }
    // Reconstruir o número a partir do vetor ordenado
    n = 0;
    for (i = 0; i < 4; i++) {
        n = n * 10 + d[i];
    }
    return n;
}

// Função que calcula o número de Kaprekar para um dado número
int kaprekar(int n) {
    int maior, menor, dif, ite;
    ite = 0; // contador de iterações
    do {
        maior = ordenarDec(n); // obter o maior número formado pelos dígitos
        menor = ordenarCres(n); // obter o menor número formado pelos dígitos
        dif = maior - menor; // calcular a diferença entre eles
        ite++; // incrementar o contador de iterações
        printf("Numero: %04d - Maior %04d - Menor %04d - Res: %04d - Ite: %d\n", n, maior, menor, dif, ite); // imprimir os resultados parciais
        n = dif; // atualizar o valor de n com a diferença obtida
    } while (n != 6174 && n != 0); // repetir até chegar ao número de Kaprekar ou a zero
    return ite; // retornar o número de iterações
}

// Função principal do programa
int main() {
    int n, m, i, k;
    printf("Digite o numero inicial de 4 algarismos: "); // pedir ao usuário o número inicial
    scanf("%d", &n); // ler o número inicial
    printf("Digite o numero final de 4 algarismos: "); // pedir ao usuário o número final
    scanf("%d", &m); // ler o número final
    for (i = n; i <= m; i++) { // percorrer todos os números entre o inicial e o final
        printf("\nCalculando o numero de Kaprekar para %04d:\n", i); // imprimir o número atual
        k = kaprekar(i); // chamar a função que calcula o número de Kaprekar e retorna as iterações
        printf("\nO numero de Kaprekar para %04d e 6174, obtido em %d iteracoes.\n", i, k); // imprimir o resultado final
    }
    return 0; // encerrar o programa
}
