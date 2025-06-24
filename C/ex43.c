#include <stdio.h>

int main() {
    int total_alunos = 50;
    float n1, n2, n3, media_ponderada, soma_medias = 0, media_geral;

    for (int i = 1; i <= total_alunos; i++) {
        printf("Digite a primeira nota do aluno %d: ", i);
        scanf("%f", &n1);

        printf("Digite a segunda nota do aluno %d: ", i);
        scanf("%f", &n2);

        printf("Digite a terceira nota do aluno %d: ", i);
        scanf("%f", &n3);

        media_ponderada = (n1 * 2 + n2 * 4 + n3 * 3) / 10;
        soma_medias += media_ponderada;

        printf("Média do aluno %d: %.2f - %s\n\n", i, media_ponderada, media_ponderada >= 7 ? "Aprovado" : "Reprovado");
    }

    media_geral = soma_medias / total_alunos;

    printf("\nMédia geral da turma: %.2f\n", media_geral);
}
