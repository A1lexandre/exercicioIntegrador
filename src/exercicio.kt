import classes.*

fun main() {
   // criando três livros
    val livro1 = Livro("001", "Uma aventura louca")
    val livro2 = Livro("002", "Uma corrida gelada")
    val livro3 = Livro("003", "Fogo na brasa")

    // Criando uma coleção de livros
    val livroDaColecao1 = Livro("004", "Harry Potter e a Pedra Filosofal")
    val livroDaColecao2 = Livro("005", "Harry Potter e a Câmara Secreta")
    val livroDaColecao3 = Livro("006", "Harry Potter e o Prisioneiro de Askaban")
    val livroDaColecao4 = Livro("007", "Harry Potter e o Cálice de Fogo")
    val colecaoHP = Colecao("101", "Harry Potter")
    colecaoHP.adicionarLivro(livroDaColecao1)
    colecaoHP.adicionarLivro(livroDaColecao2)
    colecaoHP.adicionarLivro(livroDaColecao3)
    colecaoHP.adicionarLivro(livroDaColecao4)

    // criando a libroteca
    val libroteca = Libroteca("Saraiva")

    // cadastrando livros e a coleção
    libroteca.cadastrarObra(livro1)
    libroteca.cadastrarObra(livro2)
    libroteca.cadastrarObra(livro3)
    libroteca.cadastrarObra(colecaoHP)

    // buscando um livro pelo codigo
    libroteca.consultaLivroPorCodigo("001")

    // buscando uma colecao por codigo
    libroteca.consultaColecaoPorCodigo("101")

    // alugando um livro
    libroteca.alugarObra(livro2, Funcionario("Roger", "123"), Cliente("Patricia", "3333"))

    // Verificando o estoque após o aluguel
    libroteca.verificarEstoque()
}