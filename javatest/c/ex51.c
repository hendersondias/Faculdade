#include <stdio.h>

int main() {
    int voto, total_eleitores = 20;
    int count_candidato1 = 0, count_candidato2 = 0, count_candidato3 = 0, count_candidato4 = 0;
    int count_nulos = 0, count_brancos = 0;

    for (int i = 1; i <= total_eleitores; i++) {
        printf("Digite o código do candidato para o voto do eleitor %d: ", i);
        scanf("%d", &voto);

        switch (voto) {
            case 1:
                count_candidato1++;
                break;
            case 2:
                count_candidato2++;
                break;
            case 3:
                count_candidato3++;
                break;
            case 4:
                count_candidato4++;
                break;
            case 5:
                count_nulos++;
                break;
            case 6:
                count_brancos++;
                break;
        }
    }

    printf("\nTotal de votos para o candidato 1: %d\n", count_candidato1);
    printf("Total de votos para o candidato 2: %d\n", count_candidato2);
    printf("Total de votos para o candidato 3: %d\n", count_candidato3);
    printf("Total de votos para o candidato 4: %d\n", count_candidato4);
    printf("Total de votos nulos: %d\n", count_nulos);
    printf("Total de votos em branco: %d\n", count_brancos);
}
