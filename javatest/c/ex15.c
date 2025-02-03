#include <stdio.h>

int main() {
    int ano_nascimento, idade;
    printf("Digite o ano de nascimento: ");
    scanf("%d", &ano_nascimento);
    idade = 2023 - ano_nascimento;
    if (idade >= 18) {
        printf("Você é maior de idade e pode entrar na boate.\n");
    } else {
        printf("Você é menor de idade e não pode entrar na boate.\n");
    }
    return 0;
}
