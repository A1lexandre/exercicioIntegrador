package classes

abstract class ObraLiteraria(var codigo: String,var titulo: String, var status: String = "Disponível") {

    var autor: String = ""
    var anoLancamento: String = ""
    var precoVenda: Double = 0.0
    var precoaluguel: Double = 0.0

    fun alterarStatus(estado: Int) {
        when (estado) {
            1 -> status = "Disponível"
            2 -> status = "Alugado"
            3 -> status = "Vendido"
            else -> println("Digite uma opção válida: 1 - Disponível | 2 - Alugado | 3 - Vendido.")
        }
    }

}