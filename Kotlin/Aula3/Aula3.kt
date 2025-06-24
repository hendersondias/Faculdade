class Calculadora {

    fun somar(a: Int, b: Int): Int {
        return a + b
    }

    fun somar(a: Double, b: Double): Double {
        return a + b
    }

    fun subtrair(a: Int, b: Int): Int {
        return a - b
    }

    fun subtrair(a: Double, b: Double): Double {
        return a - b
    }

    fun dividir(a: Int, b: Int): Int {
        return a / b
    }

    fun dividir(a: Double, b: Double): Double {
        return a / b
    }

    fun multiplicar(a: Int, b: Int): Int {
        return a * b
    }

    fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }

    fun interagir() {
        val scanner = java.util.Scanner(System.`in`)

        println("Qual operação você deseja realizar?")
        println("1 - Soma")
        println("2 - Subtração")
        println("3 - Divisão")
        println("4 - Multiplicação")
        println("Digite o número da operação:")

        val operacao = scanner.nextInt()

        if (operacao < 1 || operacao > 4) {
            println("Operação inválida")
            return
        }

        println("Os números são inteiros ou double?")
        println("1 - Inteiros")
        println("2 - Double")
        println("Digite o número do tipo:")

        val tipo = scanner.nextInt()

        if (tipo < 1 || tipo > 2) {
            println("Tipo inválido")
            return
        }

        println("Digite o primeiro número:")
        val a = scanner.nextDouble()
        println("Digite o segundo número:")
        val b = scanner.nextDouble()
        var resultado: Double

        when (operacao) {
            1 -> resultado = if (tipo == 1) somar(a.toInt(), b.toInt()) else somar(a, b)
            2 -> resultado = if (tipo == 1) subtrair(a.toInt(), b.toInt()) else subtrair(a, b)
            3 -> resultado = if (tipo == 1) dividir(a.toInt(), b.toInt()) else dividir(a, b)
            4 -> resultado = if (tipo == 1) multiplicar(a.toInt(), b.toInt()) else multiplicar(a, b)
            else -> resultado = 0.0 
        }

        println("O resultado é: $resultado")
    }
}
