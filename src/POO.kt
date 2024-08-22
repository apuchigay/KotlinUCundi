class OperacionesMat(var n1: Double, var n2:Double){
    fun suma(){
        val suma = n1+n2
        println("Suma: $suma")
    }

    fun resta(){
        val resta = n1-n2
        println("Resta: $resta")
    }

    fun multipli():Double{
        return n1*n2
    }

    fun div():Double{
        return n1/n2
    }

    fun raiz(): Double {
        val r = Math.sqrt(this.n1)
        println("Raiz: $r")
        return r
    }

    fun cuadrado(): Double {
        return Math.pow(this.n2, 2.0)
    }

    override fun toString(): String {
        return "operaciones_mat(n1=$n1, n2=$n2)"
    }

}