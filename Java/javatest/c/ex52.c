#include <stdio.h>

int main() {
    int total_alunos = 40;
    float nota1, nota2, nota3, media;

    for (int i = 1; i <= total_alunos; i++) {
        printf("Digite a primeira nota do aluno %d: ", i);
        scanf("%f", &nota1);

        printf("Digite a segunda nota do aluno %d: ", i);
        scanf("%f", &nota2);

        printf("Digite a terceira nota do aluno %d: ", i);
        scanf("%f", &nota3);

        media = (nota1 + nota2 + nota3) / 3;

        printf("Média do aluno %d: %.2f\n\n", i, media);
    }

}
