package biblioteca

// Clase principal MedioDigital
// Tiene informacion basica de los medios digitales
open class MedioDigital(val titulo: String,
                        val autor: String,
                        val anioPublicacion: Int) {
                        open fun mostrarInformacion(){
                            println("""
                                Titulo:          $titulo
                                Autor:           $autor
                                Año Publicacion: $anioPublicacion
                            """.trimIndent())
                        }
}

// Clase LibroElectronico. Hereda de MedioDigital
// Muestra informacion de libros electronicos
class LibroElectronico(titulo: String,
                       autor: String,
                       anioPublicacion: Int,
                       val nroPaginas: Int): MedioDigital(titulo, autor, anioPublicacion){
                           override fun mostrarInformacion(){
                               println("""
                                   Titulo:          $titulo
                                   Autor:           $autor
                                   Año Publicacion: $anioPublicacion
                                   Nro. de paginas: $nroPaginas
                               """.trimIndent())
                  }
}

// Clase Audiolibro. Hereda de MedioDigital
// Muestra informacion de audiolibros
class Audiolibro(titulo: String,
                 autor: String,
                 anioPublicacion: Int,
                 val narrador: String): MedioDigital(titulo, autor, anioPublicacion){
                     override fun mostrarInformacion(){
                         println("""
                             Titulo:          $titulo
                             Autor:           $autor
                             Año Publicacion: $anioPublicacion
                             Narrador:        $narrador
                         """.trimIndent())
                     }
}