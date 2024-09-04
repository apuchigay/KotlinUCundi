package biblioteca

fun main() {
    val coleccion = LibrosDigitales() // Inicializa la colección de libros digitales.
    while (true) {
        // Menú de opciones de la biblioteca digital
        print("""
            /************ Biblioteca digital ************/
            1. Agregar un medio (Libro / Audiolibro)
            2. Mostrar colección
            3. Mostrar información del medio
            4. Eliminar Medio (Libro / Audiolibro)
            5. Salir
            
            Elige una de las opciones disponibles: 
        """.trimIndent())

        // Condicionales que ejecutarán según la opción digitada
        when (readln().toInt()) {
            1 -> {
                print("""
                    ¿Que tipo de medio quieres añadir?
                    1. Libro electronico
                    2. Audiolibro
                    
                    Digita tu opcion: 
                """.trimIndent())
                val tipo = readln().toInt()
                if (tipo == 1) {
                    agregarLibro(coleccion)
                } else if (tipo == 2) {
                    agregarAudioLibro(coleccion)
                } else {
                    println("La opcion ingresada no es valida")
                }
            }
            2 -> coleccion.mostrarTodo() // Muestra todos los medios en la colección.
            3 -> {
                print("Digita el indice del libro que deseas ver: ")
                val indice = readln().toInt()
                // Verifica si el indice es nulo. De serlo, retorna el mensaje de error (hecho tambien en la funcion solo por asegurar)
                if (indice != null) {
                    coleccion.mostrarInformacion(indice)
                } else {
                    println("Indice invalido")
                }
            }
            4 -> {
                print("Digita el indice que deseas eliminar: ")
                val indice = readln().toInt()
                if (indice != null) {
                    coleccion.eliminar(indice)
                } else {
                    println("Indice invalido")
                }
            }
            5 -> {
                println("Gracias por usar nuestros servicios. Adios")
                break
            }
        }
    }
}

// Función para agregar un libro a la colección.
fun agregarLibro(coleccion: LibrosDigitales) {
    print("Ingresa el titulo del libro: ")
    val titulo = readln()
    print("Ingresa el autor: ")
    val autor = readln()
    print("Ingresa el año de publicacion: ")
    val anioPublicacion = readln().toInt()
    print("Ingresa el numero de paginas: ")
    val nroPaginas = readln().toInt()

    // Crea una instancia de LibroElectronico con los datos ingresados.
    val libro = LibroElectronico(titulo, autor, anioPublicacion, nroPaginas)
    coleccion.agregarMedios(libro) // Agrega el libro a la colección.
}

// Función para agregar un audiolibro a la colección.
fun agregarAudioLibro(coleccion: LibrosDigitales) {
    print("Ingresa el titulo del AudioLibro: ")
    val titulo = readln()
    print("Ingresa el autor: ")
    val autor = readln()
    print("Ingresa el año de publicacion: ")
    val anioPublicacion = readln().toInt()
    print("Ingresa el nombre del narrador: ")
    val narrador = readln()

    // Crea una instancia de Audiolibro con los datos ingresados.
    val audioLibro = Audiolibro(titulo, autor, anioPublicacion, narrador)
    coleccion.agregarMedios(audioLibro) // Añade el audiolibro a la colección.
}
