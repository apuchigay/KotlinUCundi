import kotlin.random.Random

fun main(){

    // Definir jugadores
    var j1: Int
    var j2: Int

    // Define el contador
    var contador: Int = 0
    var rondas: Int = 0

    // Contador victorias
    var v1: Int = 0
    var v2: Int = 0

    println("Juego de piedra, papel o tijeras\n1. Piedra\n2. Papel\n3. Tijera\n")

    while (contador < 1){
        j1 = Random.nextInt(1,3)
        j2 = Random.nextInt(1,3)

        rondas += 1
        println("Ronda #$rondas")

        if ((j1==1 && j2 == 3)||(j1==2 && j2==1)||(j1==3 && j2==2)){
            v1 += 1
            when(j1){
                1 -> println("J1: piedra J2: tijera")
                2 -> println("J1: papel J2: piedra")
                3 -> println("J1: tijera J2: papel")
            }
            println("Gana el jugaror 1. Lleva $v1 victoria(s)")
            println("El jugaror 2. Lleva $v2 victoria(s)\n")
        }else if((j1==3 && j2 == 1)||(j1==1 && j2==2)||(j1==2 && j2==3)){
            when(j2){
                1 -> println("J1: piedra J2: tijera")
                2 -> println("J1: papel J2: piedra")
                3 -> println("J1: tijera J2: papel")
            }
            v2 += 1
            println("Gana el jugador 2. Lleva $v2 victoria(s)")
            println("El jugaror 1. Lleva $v1 victoria(s)\n")
        }else if (j1==j2){
            when(j1){
                1 -> println("J2: piedra J1: piedra")
                2 -> println("J2: papel J1: papel")
                3 -> println("J2: tijera J1: tijera")
            }
            println("Empate. EL puntaje va en J1: $v1 y J2: $v2\n")
        }

        if (v1 == 2 || v2 == 2){
            contador += 1
        }
    }

    if (v1 > v2){
        println("Gana el jugador 1")
    }else{
        println("Gana el jugador 2")
    }
}