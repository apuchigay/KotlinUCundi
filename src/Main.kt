fun main(){
    val op1 = operaciones_mat(5.0, 7.2)
    val op2 = operaciones_mat(5.0, 7.2)
    val op3 = operaciones_mat(5.0, 7.2)
    val op4 = operaciones_mat(5.0, 7.2)
    val op5 = operaciones_mat(5.0, 7.2)
    val op6 = operaciones_mat(5.0, 7.2)

    val nuevaLista: MutableList<operaciones_mat> = mutableListOf()
    nuevaLista.add(op1.suma())
    nuevaLista.add(op2)
    nuevaLista.add(op3)
    nuevaLista.add(op4)
    nuevaLista.add(op5)
    nuevaLista.add(op6)

    for(i in nuevaLista){
        println(i)
    }
}