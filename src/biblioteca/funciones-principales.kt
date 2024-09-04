package biblioteca

// Clase que maneja una colección de medios digitales (Libros electrónicos y Audiolibros).
class LibrosDigitales {
    // Lista mutable que contiene los medios digitales en la colección
    val medios = mutableListOf<MedioDigital>()

    // Función para agregar un medio digital a la colección.
    fun agregarMedios(medioDigital: MedioDigital) {
        medios.add(medioDigital)
        println("Elemento agregado exitosamente")
    }

    // Función para mostrar toda la colección de medios.
    fun mostrarTodo() {
        // Verifica si la lista de medios está vacía.
        if (medios.isEmpty()) {
            println("No tienes nada añadido aun")
        } else {
            println("Libros electronicos")
            // Filtra y muestra solo los libros electrónicos.
            medios.filterIsInstance<LibroElectronico>().forEachIndexed { index, libro ->
                println("${index + 1}. Titulo: ${libro.titulo}. Autor: ${libro.autor}. Año: ${libro.anioPublicacion}. Paginas: ${libro.nroPaginas}")
            }

            println("Audiolibros")
            // Filtra y muestra solo los audiolibros.
            medios.filterIsInstance<Audiolibro>().forEachIndexed { index, audioLibro ->
                println("${index + 1}. Titulo: ${audioLibro.titulo}. Autor: ${audioLibro.autor}. Año: ${audioLibro.anioPublicacion}. Narrador: ${audioLibro.narrador}")
            }
        }
    }

    // Función para mostrar la información de un medio específico.
    fun mostrarInformacion(indice: Int) {
        // Verifica si el índice está dentro del rango válido de la lista.
        if (indice in 1..medios.size) {
            medios[indice - 1].mostrarInformacion()
        } else {
            println("Indice invalido")
        }
    }

    // Función para eliminar un medio de la colección.
    fun eliminar(indice: Int) {
        // Verifica si el índice está dentro del rango válido de la lista.
        if (indice in 1..medios.size) {
            val medio = medios.removeAt(indice - 1) // Elimina el medio dentro de la posición indicada
            println("Elemento eliminado con exito")
        } else {
            println("Indice invalido")
        }
    }
}
