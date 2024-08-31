package hospital

// Clase base Persona que contiene información general de una persona.
open class Persona(
    val nroCC: Int,
    val nombre: String,
    val apellido: String,
    val fecNacimiento: String,
    val direccion: String,
    var ciudadOrig: String
)

// Clase Paciente hereda de Persona y añade detalles específicos de un paciente.
class Paciente(
    nroCC: Int,
    nombre: String,
    apellido: String,
    fecNacimiento: String,
    direccion: String,
    ciudadOrig: String,
    val nroHistClinica: Int,
    val sexo: String,
    val grupSangre: String,
    val medicAlergico: String
) : Persona(nroCC, nombre, apellido, fecNacimiento, direccion, ciudadOrig)
