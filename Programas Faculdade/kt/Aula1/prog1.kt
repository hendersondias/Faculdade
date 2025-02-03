fun main(){
    println("Digite um texto:")
    var texto = readLine() // lê o texto do teclado
    var invertido = texto?.reversed() // inverte o texto
    println("O texto invertido é: $invertido") // imprime o texto invertido
}