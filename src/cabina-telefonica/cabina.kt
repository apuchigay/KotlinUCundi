import cabinaArte
// Se crea la clase Cabina que inicializa el id en cada instancia de la cabina
// (Funciona como identificador de cada una)
class Cabina(val id: Int) {
    // Define las variables de los principales registros de una llamada
    var nroLlamadas: Int = 0
    var duracionTotal: Int = 0
    var costoTotal: Int = 0

    // Funcion para registra los tipos de llamada
    fun registrar(tipo: Int, duracion: Int) {
        nroLlamadas += 1 // Incrementa el contador de llamadas
        duracionTotal += duracion // Acumulador de llamadas
        costoTotal += when (tipo) { // Uso del condicional when para acumular el costo total en funcion del tipo de llamada
            1 -> duracion * 50  // Llamada Local
            2 -> duracion * 350 // Llamada Larga Distancia
            3 -> duracion * 150 // Llamada a Celular
            else -> 0
        }
    }

    // Funcion para mostrar la informacion en base a una cabina en especifico
    fun informacion() {
        println("Cabina #$id")
        println("Número de llamadas: $nroLlamadas")
        println("Duración total de llamadas: $duracionTotal minutos")
        println("Costo total de llamadas: $costoTotal pesos")
    }

    // Funcion para reiniciar todos los valores de una cabina en especifico
    fun reiniciar() {
        nroLlamadas = 0
        duracionTotal = 0
        costoTotal = 0
    }
}
