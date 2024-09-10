package primerparcial

fun main() {
    val listaCandidatos = listOf<Candidato>(
        Candidato("Candidato A"),
        Candidato("Candidato B"),
        Candidato("Candidato C")
    )

    while (true) {
        println("/******** Votaciones municipales - Premier ********/")
        print(
            """
        1. Elegir un candidato
        2. Calcular el costo de campaña por candidato
        3. Limpiar urnas de votación
        4. Conocer el número total de votos por candidato
        5. Porcentaje de votos por candidato
        6. Mostrar costo promedio de campaña en las elecciones
        7. Mostrar al candidato ganador
        8. Salir

        Elige una de las opciones: 
    """.trimIndent()
        )

        when (readln().toInt()) {
            1 -> {
                print(
                    """
                Elige uno de los siguientes candidatos (digita el número):
                1. Candidato A
                2. Candidato B
                3. Candidato C
                
                Digita tu opción aquí -> 
            """.trimIndent()
                )

                val nroCandidato = readln().toInt()
                // Valida si la opción esta dentro de los 3 candidatos. Valida igualmente para los medios influenciados
                if (nroCandidato in 1..3) {
                    print(
                        """
                        Elige uno de los medios por los cuales supiste del candidato (digita el número)
                        1. Internet
                        2. Radio
                        3. Televisión
                        
                        Digita tu respuesta aquí -> 
                    """.trimIndent()
                    )
                    val medio = readln().toInt()
                    if (medio in 1..3) {
                        // Le resta un numero al valor del indice para añadir el voto real
                        listaCandidatos[nroCandidato - 1].registrarVoto(medio)
                        println("¡Voto registrado con éxito!")
                    } else {
                        println("El medio ingresado no es válido")
                    }
                } else {
                    println("El candidato ingresado no existe")
                }
            }

            // Bucle que itera segun la longitud de los candidatos y muestra la información de este
            2 -> {
                for (candidato in listaCandidatos) {
                    candidato.mostrarInfo()
                    println()
                }
            }

            // Bucle que itera segun la longitud de los candidatos y reinicia las urnas
            3 -> {
                for (candidato in listaCandidatos) {
                    candidato.reiniciarUrnas()
                }
                println("Todas las urnas de votación han sido limpiadas.")
            }

            // Bucle que itera segun la longitud de los candidatos y miestra el total de votos de cada uno
            4 -> {
                for (candidato in listaCandidatos) {
                    println("${candidato.nombre} tiene un total de ${candidato.totalVotos()} votos.")
                }
            }

            5 -> {
                // Realiza la accion sobre cada candidato y suma su total de votos
                val totalVotos = listaCandidatos.sumOf { it.totalVotos() }
                if (totalVotos > 0) {
                    for (candidato in listaCandidatos) {
                        // Porcentaje de votos segun el total
                        val porcentaje = (candidato.totalVotos() * 100) / totalVotos
                        println("${candidato.nombre}: $porcentaje% de los votos")
                    }
                } else {
                    println("No hay votos registrados.")
                }
            }
            6 -> {
                val totalVotos = listaCandidatos.sumOf { it.totalVotos() }
                val totalCostos = listaCandidatos.sumOf { it.costosCampana() }
                if (totalVotos > 0) {
                    val costoPromedio = totalCostos / totalVotos
                    println("El costo promedio de campaña por voto es: $costoPromedio pesos")
                } else {
                    println("No hay votos registrados para calcular el costo promedio.")
                }
            }
            7 -> {
                val maxVotos = listaCandidatos.maxOfOrNull { it.totalVotos() } // Busca el valor maximo de los votos
                if (maxVotos != null && maxVotos > 0) {
                    val ganador = listaCandidatos.find { it.totalVotos() == maxVotos }
                    println("El candidato ganador es: ${ganador?.nombre} con $maxVotos votos.")
                } else {
                    println("No hay votos registrados.")
                }
            }
            8 -> {
                println("Gracias por participar en las elecciones. Adios")
                break
            }
            else -> println("Opción no válida.")
        }
    }
}

// Total IA: 40% aprox (Busqueda de metodos de lista no vistos y en manejo de nulls)