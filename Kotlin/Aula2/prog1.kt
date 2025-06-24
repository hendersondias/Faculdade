
class Pessoas(val nome: String, val idade: Int, val peso: Double, val altura: Double) {
    
    fun mostrarNome() {
        println("O nome da pessoa é $nome")
    }

 
    fun mostrarIdade() {
        println("A idade da pessoa é $idade anos")
    }

    
    fun mostrarPeso() {
        println("O peso da pessoa é $peso kg")
    }

   
    fun mostrarAltura() {
        println("A altura da pessoa é $altura m")
    }

   
    fun calcularIMC(): Double {
        
        return peso / (altura * altura)
    }

    fun mostrarIMC() {
       
        val imc = calcularIMC()

        println("O IMC da pessoa é ${"%.2f".format(imc)}")
        when {
            imc < 18.5 -> println("A pessoa está abaixo do peso")
            imc in 18.5..24.9 -> println("A pessoa está com peso normal")
            imc in 25.0..29.9 -> println("A pessoa está com sobrepeso")
            imc in 30.0..34.9 -> println("A pessoa está com obesidade grau I")
            imc in 35.0..39.9 -> println("A pessoa está com obesidade grau II")
            imc >= 40.0 -> println("A pessoa está com obesidade grau III")
        }
    }
}

fun main() {
    val pessoa1 = Pessoas("João", 25, 70.0, 1.75)
    val pessoa2 = Pessoas("Maria", 30, 60.0, 1.60)

    println("Dados da primeira pessoa:")
    pessoa1.mostrarNome()
    pessoa1.mostrarIdade()
    pessoa1.mostrarPeso()
    pessoa1.mostrarAltura()
    pessoa1.mostrarIMC()
    println()

    println("Dados da segunda pessoa:")
    pessoa2.mostrarNome()
    pessoa2.mostrarIdade()
    pessoa2.mostrarPeso()
    pessoa2.mostrarAltura()
    pessoa2.mostrarIMC()
    println()
}
