package classes

import java.sql.Date

class Libroteca(var nome: String) {

    val data: String = Date(System.currentTimeMillis()).toString()

    val listaDeLivros: MutableList<Livro> = mutableListOf()
    val listaDeColecoes: MutableList<Colecao> = mutableListOf()
    // lista com histórico de venda e alguel que envolve o funcionário e o cliente
    val listaDeVendaAluguel: MutableList<AluguelVenda> = mutableListOf()

    // método para adicionar livro ou coleção
    fun cadastrarObra(obra: ObraLiteraria) {
        if (obra is Livro) {
            listaDeLivros.add(obra)
        } else {
            listaDeColecoes.add(obra as Colecao)
        }
    }

    fun consultaLivroPorCodigo(codigo: String) {
        encontrarLivro(codigo)?.let {
            println("---------- Informações do livro ------------")
            println("Titulo: ${it.titulo}")
            println("Autor: ${it.autor}")
            println("Ano de lançamento: ${it.anoLancamento}")
            println("Preço de aluguel (Por dia): ${it.precoaluguel}")
            println("Preço de venda: ${it.precoVenda}")
        } ?: println("Não há lvro com esse código.")
    }

    fun consultaColecaoPorCodigo(codigo: String) {
        encontrarColecao(codigo)?.let {
            println("---------- Informações da coleção ------------")
            println("Titulo: ${it.titulo}")
            println("Autor: ${it.autor}")
            println("Ano de lançamento: ${it.anoLancamento}")
            println("Preço de aluguel (Por dia): ${it.precoaluguel}")
            println("Preço de venda: ${it.precoVenda}")

            println("Livros da coleção:")
            it.livrosDaColecao.forEach {
                println(it.titulo)
            }
        }  ?: println("Não há coleção com esse código")
    }

    // Aluguel de livro ou coleção
    fun alugarObra(obra: ObraLiteraria, func: Funcionario, cliente: Cliente) {
        if (obra.status == "Disponível") {
            obra.alterarStatus(2)
            listaDeVendaAluguel.add(AluguelVenda(func, cliente, "Aluguel"))
        } else {
            println("Essa obra não está disponível.")
        }
    }

    // Venda de obra ou coleção, sendo necessário passar o tipo da obra por
    // parâmetro
    fun venderObra(codigo: String, tipoObra: String, func: Funcionario, cliente: Cliente) {
      when (tipoObra.toUpperCase()) {
           "COLEÇÃO" -> {
               val colecao = encontrarColecao(codigo)
               colecao?.let {
                   colecao.alterarStatus(3)
                   listaDeVendaAluguel.add(AluguelVenda(func, cliente, "Venda"))
               }
          }
           "LIVRO" -> {
              val livro = encontrarLivro(codigo)
               livro?.let {
                   livro.alterarStatus(3)
                   listaDeVendaAluguel.add(AluguelVenda(func, cliente, "Venda"))
               }
           }
          else -> println("Digite um tipo de obra válido.")
      }

    }

    fun verificarEstoque() {
        var contDisp = 0
        var contAlug = 0
        var contVend = 0
        var valorTotalAluguel = 0.0
        var valorTotalVenda = 0.0

        if (listaDeLivros.size > 0) {
            listaDeLivros.forEach {
                valorTotalAluguel += it.precoaluguel
                valorTotalVenda += it.precoVenda
                when (it.status) {
                    "Disponível" -> contDisp++
                    "Alugado" -> contAlug++
                    "Vendido" -> contVend++
                }
            }
            println("O libroteca tem o seguinte status de seus livros:")
            println("$contDisp disponível(is)")
            println("$contAlug alugado(s)")
            println("$contVend vendido(s)")
            println("Valor total de venda dos livros: ${valorTotalVenda}")
            println("Valor total de aluguel dos livros: ${valorTotalAluguel}")
        } else {
            println("Não há livros cadastrados.")
        }

    }


    private fun encontrarLivro(codigo: String): Livro? {
        var livro: Livro? = null
        listaDeLivros.forEach {
            if (it.codigo == codigo) {
                livro = it
            }
        }
        return livro
    }

    private fun encontrarColecao(codigo: String): Colecao? {
        var colecao: Colecao? = null
        listaDeColecoes.forEach {
            if (it.codigo == codigo) {
                colecao = it
            }
        }
        return colecao
    }

}