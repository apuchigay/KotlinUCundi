fun main() {
    // Variables de datos de usuario
    var nombre: String
    var telefono: String
    var nit: String
    var prod: Int = 0

    // Variables de valor de los productos
    val mouse: Int = 52000
    val teclado: Int = 84000
    val monitor: Int = 79000
    val discoDuro: Int = 24000

    // Variables de cantidad productos
    var cantMou: Int = 0
    var cantTecl: Int = 0
    var cantMoni: Int = 0
    var cantDisc: Int = 0

    println("/***** TIENDA *****/")
    println("Ingrese su nombre:")
    nombre = readln()
    println("Ingrese su Telefono:")
    telefono = readln()
    println("Ingrese su NIT:")
    nit = readln()

    println("A continuación se listarán los productos:\n" +
            "1. Mouse -> \$52,000\n" +
            "2. Teclado -> \$84,000\n" +
            "3. Monitor -> \$79,000\n" +
            "4. Disco Duro -> \$24,000\n" +
            "5. Factura")

    while (prod != 5) {
        println("Por favor, ingrese una de las opciones antes mencionadas: ")
        prod = readln().toInt()
        when (prod) {
            1 -> {
                println("Ingrese la cantidad deseada")
                cantMou += readln().toInt()
            }
            2 -> {
                println("Ingrese la cantidad deseada")
                cantTecl += readln().toInt()
            }
            3 -> {
                println("Ingrese la cantidad deseada")
                cantMoni += readln().toInt()
            }
            4 -> {
                println("Ingrese la cantidad deseada")
                cantDisc += readln().toInt()
            }
            5 -> continue
            else -> println("Ingrese un valor válido")
        }
    }

    // Cálculo del totales
    val subtotal = (mouse * cantMou) + (teclado * cantTecl) + (monitor * cantMoni) + (discoDuro * cantDisc)
    val iva = (subtotal*0.16).toInt()
    val total = subtotal+iva

    // Imprimir factura
    println("/*********** Factura ***********/")
    println("Nombre: $nombre          NIT: $nit")
    println("Telefono: $telefono\n")
    println("Producto       Cant        v/uni     v/total")
    if (cantMou > 0) {
        println("Mouse          ${cantMou.toString().padStart(3)}       \$${mouse.toString().padStart(6)}   \$${(mouse * cantMou).toString().padStart(8)}")
    }
    if (cantTecl > 0) {
        println("Teclado        ${cantTecl.toString().padStart(3)}       \$${teclado.toString().padStart(6)}   \$${(teclado * cantTecl).toString().padStart(8)}")
    }
    if (cantMoni > 0) {
        println("Monitor        ${cantMoni.toString().padStart(3)}       \$${monitor.toString().padStart(6)}   \$${(monitor * cantMoni).toString().padStart(8)}")
    }
    if (cantDisc > 0) {
        println("Disco Duro     ${cantDisc.toString().padStart(3)}       \$${discoDuro.toString().padStart(6)}   \$${(discoDuro * cantDisc).toString().padStart(8)}")
    }
    println("\n                      Subtotal:  \$${subtotal.toString().padStart(10)} "+
            "\n                      IVA (16%): \$${iva.toString().padStart(10)} "+
            "\n                      Total:     \$${total.toString().padStart(10)}")
}
