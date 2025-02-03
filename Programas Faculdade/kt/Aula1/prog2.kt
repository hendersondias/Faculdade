fun main() {
    val inicio = 1 // valor inicial do intervalo
    val fim = 300 // valor final do intervalo
    var soma = 0 // variável para armazenar a soma
    for (i in inicio..fim) { // loop de inicio até fim
        soma += i // soma cada número ao total
    }
    println("A soma de todos os números de $inicio até $fim é $soma") // imprime o resultado
} 