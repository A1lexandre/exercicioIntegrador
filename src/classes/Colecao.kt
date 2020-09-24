package classes

class Colecao(codigo: String,
              titulo: String,
              status: String = "Disponível") : ObraLiteraria(codigo, titulo, status) {

    val livrosDaColecao: MutableList<Livro> = mutableListOf()

   fun adicionarLivro(livro: Livro) {
        livrosDaColecao.add(livro)
    }

}