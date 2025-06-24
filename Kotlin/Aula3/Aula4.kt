object Calculadora {

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

    object Extra {
        fun raiz(a: Int): Double {
            return Math.sqrt(a.toDouble())
        }

        fun raiz(a: Double): Double {
            return Math.sqrt(a)
        }

        fun potencia(a: Int, b: Int): Int {
            return Math.pow(a.toDouble(), b.toDouble()).toInt()
        }

        fun potencia(a: Double, b: Double): Double {
            return Math.pow(a, b)
        }
    }

    fun interagir() {
        val scanner = java.util.Scanner(System.`in`)

        println("Qual operação você deseja realizar?")
        println("1 - Soma")
        println("2 - Subtração")
        println("3 - Divisão")
        println("4 - Multiplicação")
        println("5 - Raiz Quadrada")
        println("6 - Potência")
        println("Digite o número da operação:")

        val operacao = scanner.nextInt()

        if (operacao < 1 || operacao > 6) {
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

        var resultado: Double

        when (operacao) {
            1 -> resultado = if (tipo == 1) somar(a.toInt(), a.toInt()) else somar(a, a)
            2 -> resultado = if (tipo == 1) subtrair(a.toInt(), a.toInt()) else subtrair(a, a)
            3 -> resultado = if (tipo == 1) dividir(a.toInt(), a.toInt()) else dividir(a, a)
            4 -> resultado = if (tipo == 1) multiplicar(a.toInt(), a.toInt()) else multiplicar(a, a)
            5 -> resultado = if (tipo == 1) Extra.raiz(a.toInt()) else Extra.raiz(a)
            6 -> {
                println("Digite o segundo número:")
                val b = scanner.nextDouble()
                resultado = if (tipo == 1) Extra.potencia(a.toInt(), b.toInt()) else Extra.potencia(a, b)
            }
            else -> resultado = 0.0 
        }

        println("O resultado é: $resultado")
    }
}
