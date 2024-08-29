package hospital

open class Persona(val nroDni: Int,
                   val nombre: String,
                   val apellido:String,
                   val fecNacimiento: String,
                   val direccion: String,
                   var ciudadOrig: String)

class Paciente(nroDni: Int,
               nombre: String,
               apellido:String,
               fecNacimiento: String,
               direccion: String,
               ciudadOrig: String,
               val nroHistClinica: Int,
               val sexo: String,
               val grupSangre: String,
               val medicAlergico: String) : Persona(nroDni, nombre, apellido, fecNacimiento, direccion, ciudadOrig)