import kotlin.random.Random

fun main(){
    var dado1: Int
    var dado2: Int

    var contDado1: Int = 0
    var contDado2: Int = 0

    println("/***** Lanzamiento dados, 5 rondas *****/")
    for (i in 1..5){
        dado1=Random.nextInt(1,6)
        dado2=Random.nextInt(1,6)

        println("\nLanzamiento #$i")
        println("Dado 1    Dado 2")
        println("${dado1.toString().padStart(3)}        ${dado2.toString().padStart(2)}")

        if (dado1>dado2){
            println("\n¡Gana el dado 1!")
            contDado1 += 1
            println("Dado 1: $contDado1  Dado 2: $contDado2")
        }else if(dado2>dado1){
            println("\n¡Gana el dado 2!")
            contDado2 += 1
            println("Dado 1: $contDado1  Dado 2: $contDado2")
        }else if (dado1 == dado2){
            println("Empate")
            println("Dado 1: $contDado1  Dado 2: $contDado2")
        }
    }

    println("\nResultado final")
    if(contDado1>contDado2){
        println("El ganador es el dado 1 con $contDado1 victorias")
    }else if (contDado2>contDado1){
        println("El ganador es el dado 2 con $contDado2 victorias")
    }else if (contDado1 == contDado2){
        println("Es un empate")
    }
}