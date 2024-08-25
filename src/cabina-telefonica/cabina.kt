import cabinaArte
// Se crea la clase Cabina que inicializa el id en cada instancia de la cabina
// (Funciona como identificador de cada una)
class Cabina(val id: Int) {
    // Define las variables de los principales registros de una llamada
    var numeroLlamadas: Int = 0
    var duracionTotal: Int = 0
    var costoTotal: Int = 0

    // Funcion para registra los tipos de llamada
    fun registrarLlamada(tipo: Int, duracion: Int) {
        numeroLlamadas += 1 // Incrementa el contador de llamadas
        duracionTotal += duracion // Acumulador de llamadas
        costoTotal += when (tipo) { // Uso del condicional when para acumular el costo total en funcion del tipo de llamada
            1 -> duracion * 50  // Llamada Local
            2 -> duracion * 350 // Llamada Larga Distancia
            3 -> duracion * 150 // Llamada a Celular
            else -> 0
        }
    }

    // Funcion para mostrar la informacion en base a una cabina en especifico
    fun mostrarInfo() {
        println("Cabina #$id")
        println("Número de llamadas: $numeroLlamadas")
        println("Duración total de llamadas: $duracionTotal minutos")
        println("Costo total de llamadas: $costoTotal pesos")
    }

    // Funcion para reiniciar todos los valores de una cabina en especifico
    fun reiniciar() {
        numeroLlamadas = 0
        duracionTotal = 0
        costoTotal = 0
    }
}

// Función principal que ejecuta el programa
fun main() {
    cabinaArte()
    println("Ingrese el número de cabinas:")
    val n = readln().toInt()

    // Crear una lista mutable de cabinas. Almacena según la cantidad definida al iniciar el programa
    val cabinas = mutableListOf<Cabina>()
    for (i in 1..n) {
        cabinas.add(Cabina(i)) //add es una funcion para añadir una nueva cabina dentro de la lista según su identificador i
    }

    // Ejecuta el programa mientras la condicion sea verdadera
    while (true) {
        println("""
                Opciones:
                1. Registrar una llamada
                2. Mostrar información detallada de una cabina
                3. Mostrar consolidado total
                4. Reiniciar una cabina
                5. Salir
            """.trimIndent()) // Eimina los espacios en blanco al principio de una nueva linea
        print("Seleccione una opción: ")

        when (readln().toInt()) { // Inicia el condicional según la eleccion del usuario
            1 -> {
                println("Ingrese el número de cabina:")
                val cabinaId = readln().toInt()
                println("Ingrese el tipo de llamada (1: Local, 2: Larga Distancia, 3: Celular):")
                val tipo = readln().toInt()
                println("Ingrese la duración de la llamada en minutos:")
                val duracion = readln().toInt()

                // Registrar la llamada en la cabina seleccionada
                // Se ubica un indice detras el id de la cabina y luego llama la funcion. Pasando dentro de ella las variables
                cabinas[cabinaId - 1].registrarLlamada(tipo, duracion)
            }
            2 -> {
                println("Ingrese el número de cabina para mostrar detalles:")
                val cabinaId = readln().toInt()

                // Muestra información de la cabina
                // Se ubica un indice detras el id de la cabina y luego llama la funcion para imprimir la información
                cabinas[cabinaId - 1].mostrarInfo()
            }
            3 -> {
                // Se definen las variables que funcionan para almacenar los valores totales de la llamada e info necesaria
                var numeroTotalLlamadas = 0
                var duracionTotalLlamadas = 0
                var costoTotalLlamadas = 0

                // Bucle que itera sobre la lista cabinas. cabina sirve para tomar el valor del elemento de la lista en la que itera
                for (cabina in cabinas) {
                    numeroTotalLlamadas += cabina.numeroLlamadas
                    duracionTotalLlamadas += cabina.duracionTotal
                    costoTotalLlamadas += cabina.costoTotal
                }

                println("Consolidado Total:")
                println("Número total de llamadas: $numeroTotalLlamadas")
                println("Duración total de llamadas: $duracionTotalLlamadas minutos")
                println("Costo total de llamadas: $costoTotalLlamadas pesos")

                // Calcula el costo promedio por minuto de la cabina
                if (duracionTotalLlamadas > 0) {
                    val costoPromedioPorMinuto = costoTotalLlamadas / duracionTotalLlamadas
                    println("Costo promedio por minuto: $costoPromedioPorMinuto pesos")
                } else {
                    println("No se realizaron llamadas.")
                }
            }
            4 -> {
                println("Ingrese el número de cabina para reiniciar:")
                val cabinaId = readln().toInt()

                // Reiniciar la cabina seleccionada
                cabinas[cabinaId - 1].reiniciar() //Llama a la funcion reiniciar y deja los valores en 0
                println("Cabina #$cabinaId reiniciada.")
            }
            5 -> break  // Sale del bucle y finaliza el programa
            else -> println("Opción no válida.")
        }
    }

    println("Gracias por usar nuestros servicios. Adios")
}
