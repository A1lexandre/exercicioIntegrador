package classes

class Livro(codigo: String,
            titulo: String,
            status: String = "Disponível") : ObraLiteraria(codigo, titulo, status) {

}