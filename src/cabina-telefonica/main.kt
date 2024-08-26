// Función principal que ejecuta el programa
fun main() {
    cabinaArte()
    print("Ingrese el número de cabinas: ")
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
                cabinas[cabinaId - 1].registrar(tipo, duracion)
            }
            2 -> {
                println("Ingrese el número de cabina para mostrar detalles:")
                val cabinaId = readln().toInt()

                // Muestra información de la cabina
                // Se ubica un indice detras el id de la cabina y luego llama la funcion para imprimir la información
                if (cabinaId in 1..cabinas.size) {
                    cabinas[cabinaId - 1].informacion()
                } else {
                    println("Número de cabina no válido.")
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
            5 -> break  // Sale del bucle y finaliza el programa
            else -> println("Opción no válida.")
        }
    }

    println("Gracias por usar nuestros servicios. Adios")
}