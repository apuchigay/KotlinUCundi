import kotlin.random.Random
// Función principal que ejecuta el programa
fun main() {
    cabinaArte()
    // Crear una lista mutable de cabinas. Almacena según la cantidad definida al iniciar el programa
    val cabinas = mutableListOf<Cabina>()
    cabinas.add(Cabina(1))

    // Ejecuta el programa mientras la condicion sea verdadera
    while (true) {
        println("""
                Opciones:
                1. Registrar una llamada
                2. Mostrar información detallada de una cabina
                3. Mostrar consolidado total
                4. Reiniciar una cabina
                5. Añadir más cabinas
                6. Salir
            """.trimIndent()) // Eimina los espacios en blanco al principio de una nueva linea
        print("Seleccione una opción: ")

        when (readln().toInt()) { // Inicia el condicional según la eleccion del usuario
            1 -> {
                println("Ingrese el número de cabina (1 de ${cabinas.size}):")
                val cabinaId = readln().toInt()
                if (cabinaId in 1..cabinas.size) {
                    println("Ingrese el tipo de llamada (1: Local, 2: Larga Distancia, 3: Celular):")
                    val tipo = readln().toInt()

                    // Generar duración aleatoria entre 1 y 60 minutos
                    val duracion = Random.nextInt(1, 61)

                    // Registrar la llamada en la cabina seleccionada
                    // Se ubica un indice detras el id de la cabina y luego llama la funcion. Pasando dentro de ella las variables
                    cabinas[cabinaId - 1].registrar(tipo, duracion)
                    println("Duración de la llamada: $duracion minutos")
                } else {
                    println("Número de cabina no válido.")
                }
            }
            2 -> {
                // Mostrar información de todas las cabinas
                for (cabina in cabinas) {
                    cabina.informacion()
                    println() // Separador entre cabinas
                }
            }
            3 -> {
                // Se definen las variables que funcionan para almacenar los valores totales de la llamada e info necesaria
                var totalLlamadas = 0
                var duracionLlamadas = 0
                var costoTotalLlamadas = 0

                // Bucle que itera sobre la lista cabinas. cabina sirve para tomar el valor del elemento de la lista en la que itera
                for (cabina in cabinas) {
                    totalLlamadas += cabina.nroLlamadas
                    duracionLlamadas += cabina.duracionTotal
                    costoTotalLlamadas += cabina.costoTotal
                }

                println("Consolidado Total:")
                println("Número total de llamadas: $totalLlamadas")
                println("Duración total de llamadas: $duracionLlamadas minutos")
                println("Costo total de llamadas: $costoTotalLlamadas pesos")

                // Calcula el costo promedio por minuto de la cabina
                if (duracionLlamadas > 0) {
                    val costoxminuto = costoTotalLlamadas / duracionLlamadas
                    println("Costo promedio por minuto: $costoxminuto pesos")
                } else {
                    println("No se realizaron llamadas.")
                }
            }
            4 -> {
                println("Ingrese el número de cabina para reiniciar:")
                val cabinaId = readln().toInt()

                // Reinicia la cabina seleccionada
                if (cabinaId in 1..cabinas.size) {
                    cabinas[cabinaId - 1].reiniciar()
                    println("Cabina #$cabinaId reiniciada.")
                } else {
                    println("Número de cabina no válido.")
                }
            }
            5 -> {
                // Añadir nuevas cabinas
                println("¿Cuántas cabinas desea añadir?")
                val cantidad = readln().toInt()

                for (i in 1..cantidad) {
                    val nuevaCabinaId = cabinas.size + 1
                    cabinas.add(Cabina(nuevaCabinaId))
                    println("Cabina #$nuevaCabinaId añadida.")
                }
            }
            6 -> break  // Sale del bucle y finaliza el programa
            else -> println("Opción no válida.")
        }
    }

    println("Gracias por usar nuestros servicios. Adios")
}

// Aleatorio para minutos
// consolidado cabina por cabina