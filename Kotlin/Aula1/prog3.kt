
fun media(lista: List<Int>): Double {
    if (lista.isEmpty()) return 0.0

    return lista.sum().toDouble() / lista.size
}

val numeros = mutableListOf<Int>()


do {
    val numero = readLine()!!.toInt()

    if (numero > 0) numeros.add(numero)

    else if (numero < 0) println("Digite apenas números positivos!")
    else break
} while (true)

println("A soma de todos os números digitados é ${numeros.sum()}")
println("A quantidade de números digitados é ${numeros.size}")
println("A média dos números digitados é ${media(numeros)}")
println("O maior número digitado é ${numeros.maxOrNull()}")
println("O menor número digitado é ${numeros.minOrNull()}")

val pares = numeros.filter { it % 2 == 0 }
println("A média dos números pares digitados é ${media(pares)}")
println("A quantidade de números ímpares digitados é ${numeros.size - pares.size}")