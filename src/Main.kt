fun main(){
    val operaciones = OperacionesMat(5.0, 7.2)

    val operacionesLista: MutableList<() -> Unit> = mutableListOf(
        operaciones::suma,
        operaciones::resta
    )

    val operacionesRetornoFlotante: MutableList<()-> Double> = mutableListOf(
        operaciones::multipli,
        operaciones::div
    )

    for(operacion in operacionesLista){
        println("Resultado operacion ${operacion()}")
    }

    for(operacion in operacionesRetornoFlotante){
        println("Resultado operacion ${operacion()}")
    }
}