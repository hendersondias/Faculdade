// Nome: Henderson Dias Matias da Silva RA 0973/23-1

class Veiculo (
    var marca = "hyundai"
    var modelo = "hb20"

    var acelerar = new Acelerar(modelo)
    var frear = new Frear(modelo



    class carro(
        var portas = 4
        var abrirporta = new abrirPorta(portas)
    )
    class moto(
        var cilindradas = (1000cc)
        var empinar = new Empinar(cilindradas)
    )
)

        fun main(
            var carro = new Carro("HB20")
            var moto = new Moto("Cb1000")

            var acelerar = new Acelerar()
            var frear = new frear()
                    println("o veiculo $modelo está freando")
                    println("o veiculo $modelo está acelerando")
                    println("Abrindo $portas do carro")
                    println("Empinando a moto de $cilindradas")

        )