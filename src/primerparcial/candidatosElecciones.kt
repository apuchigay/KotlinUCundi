package primerparcial

// Clase principal con los candidatos
class Candidato(var nombre: String) {
    var votosPubliInternet = 0
    var votosPubliRadio = 0
    var votosPubliTv = 0

    // Funcion para registrar el voto segun el medio influenciado
    fun registrarVoto(medio: Int) {
        when (medio) {
            1 -> votosPubliInternet += 1
            2 -> votosPubliRadio += 1
            3 -> votosPubliTv += 1
            else -> println("Medio no valido")
        }
        println("Voto registrado exitosamente")
    }

    // Funcion que retorna la suma total de los votos
    fun totalVotos(): Int {
        return votosPubliInternet + votosPubliTv + votosPubliRadio
    }

    // Funcion para calcular los costos totales de la campaña
    fun costosCampana(): Int {
        val costoInternet = votosPubliInternet * 700_000
        val costoRadio = votosPubliRadio * 200_000
        val costoTv = votosPubliTv * 600_000

        return costoInternet + costoRadio + costoTv
    }

    // Funcion para mostrar la informaión total de los candidatos
    fun mostrarInfo() {
        println(
            """
            - Candidato: $nombre
            - Votos influenciados por internet: $votosPubliInternet
            - Votos influenciados por radio:    $votosPubliRadio
            - Votos influenciados por TV:       $votosPubliTv
            - Nro. total de votos:              ${totalVotos()}
            - Costo total de la publicidad:     ${costosCampana()}
        """.trimIndent()
        )
    }

    fun reiniciarUrnas() {
        votosPubliInternet = 0
        votosPubliRadio = 0
        votosPubliTv = 0
    }
}
