#include <stdio.h>
#include <string.h>

int main() {
    char nome1[50], nome2[50];
    int idade1, idade2;
    int ano_nascimento;

    printf("Digite o nome da primeira pessoa: ");
    scanf("%s", nome1);
    printf("Digite a idade da primeira pessoa: ");
    scanf("%d", &idade1);

    printf("Digite o nome da segunda pessoa: ");
    scanf("%s", nome2);
    printf("Digite a idade da segunda pessoa: ");
    scanf("%d", &idade2);

    if (idade1 < idade2) {
        printf("A pessoa mais nova é %s.\n", nome1);
        ano_nascimento = 2023 - idade1;
        printf("O ano de nascimento é %d.\n", ano_nascimento);
    } else if (idade2 < idade1) {
        printf("A pessoa mais nova é %s.\n", nome2);
        ano_nascimento = 2023 - idade2;
        printf("O ano de nascimento é %d.\n", ano_nascimento);
    }
}
