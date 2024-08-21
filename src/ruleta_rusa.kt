import kotlin.random.Random

fun main(){
    val camaraBala: Int = Random.nextInt(1,6)
    var posJugador = Random.nextInt(1,6)

    for(i in 1..6){

        if (posJugador == camaraBala){
            println("El jugador $i disparó la camara $posJugador")
            println("La bala estaba en la camara $camaraBala")
            println("El jugador $i ha muerto\n")
            break
        }else{
            println("El jugador $i disparó la camara $posJugador. Estaba vacia\n")
            posJugador += 1
        }

        if(posJugador==7){
            posJugador = 1
        }
    }
}