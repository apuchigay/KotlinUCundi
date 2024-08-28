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

open class Empleado(nroDni: Int,
                    nombre: String,
                    apellido:String,
                    fecNacimiento: String,
                    direccion: String,
                    ciudadOrig: String,
                    val codEmpleado: Int,
                    val nroHorasExtra: Int,
                    val fecIngreso: String,
                    val area: String,
                    val cargo:String) : Persona(nroDni, nombre, apellido, fecNacimiento, direccion, ciudadOrig)

open class Empleadoxplanilla(nroDni: Int,
                             nombre: String,
                             apellido:String,
                             fecNacimiento: String,
                             direccion: String,
                             ciudadOrig: String,
                             codEmpleado: Int,
                             nroHorasExtra: Int,
                             fecIngreso: String,
                             area: String,
                             cargo:String,
                             val salarioMensual: Double,
                             val porcentajeAdicional: Double) : Empleado(nroDni, nombre, apellido, fecNacimiento, direccion, ciudadOrig, codEmpleado, nroHorasExtra, fecIngreso, area, cargo)

class EmpleadoEventual(nroDni: Int,
                       nombre: String,
                       apellido:String,
                       fecNacimiento: String,
                       direccion: String,
                       ciudadOrig: String,
                       codEmpleado: Int,
                       nroHorasExtra: Int,
                       fecIngreso: String,
                       area: String,
                       cargo:String,
                       val honorariosxHora: Double,
                       val nroHorasTotales: Int,
                       val fechaFinContrato: String) : Empleado(nroDni, nombre, apellido, fecNacimiento, direccion, ciudadOrig, codEmpleado, nroHorasExtra, fecIngreso, area, cargo)

class Medico(nroDni: Int,
             nombre: String,
             apellido:String,
             fecNacimiento: String,
             direccion: String,
             ciudadOrig: String,
             codEmpleado: Int,
             nroHorasExtra: Int,
             fecIngreso: String,
             area: String,
             cargo:String,
             salarioMensual: Double,
             porcentajeAdicional: Double,
             val especialidad: String,
             val servicio: String,
             val nroConsultorio: Int) : Empleadoxplanilla(nroDni, nombre, apellido, fecNacimiento, direccion, ciudadOrig, codEmpleado, nroHorasExtra, fecIngreso, area, cargo, salarioMensual, porcentajeAdicional)

// Clase para el registro de datos
class RegistroServicio {
    // Listado de las entidades del sistema
    private val empleados = mutableListOf<Empleado>()
    private val medicos = mutableListOf<Medico>()
    private val pacientes = mutableListOf<Paciente>()
    private val citas = mutableListOf<Pair<Paciente, Medico>>() // Tupla para paciente y médico

    fun registrarEmpleado(empleado: Empleado) {
        empleados.add(empleado)
    }

    fun registrarPaciente(paciente: Paciente) {
        pacientes.add(paciente)
    }

    fun registrarMedico(medico: Medico) {
        medicos.add(medico)
    }
}