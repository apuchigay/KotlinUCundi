package hospital

// Clase base Persona que contiene información general de una persona.
open class Empleado(
    nroCC: Int,
    nombre: String,
    apellido: String,
    fecNacimiento: String,
    direccion: String,
    ciudadOrig: String,
    val codEmpleado: Int,
    val nroHorasExtra: Int,
    val fecIngreso: String,
    val area: String,
    val cargo: String
) : Persona(nroCC, nombre, apellido, fecNacimiento, direccion, ciudadOrig)

// Clase Empleadoxplanilla hereda de Empleado y añade detalles específicos de empleados contratados por planilla.
open class Empleadoxplanilla(
    nroCC: Int,
    nombre: String,
    apellido: String,
    fecNacimiento: String,
    direccion: String,
    ciudadOrig: String,
    codEmpleado: Int,
    nroHorasExtra: Int,
    fecIngreso: String,
    area: String,
    cargo: String,
    val salarioMensual: Double,
    val porcentajeAdicional: Double
) : Empleado(nroCC, nombre, apellido, fecNacimiento, direccion, ciudadOrig, codEmpleado, nroHorasExtra, fecIngreso, area, cargo)

// Clase EmpleadoEventual hereda de Empleado y añade detalles específicos de empleados contratados de manera temporal.
class EmpleadoEventual(
    nroCC: Int,
    nombre: String,
    apellido: String,
    fecNacimiento: String,
    direccion: String,
    ciudadOrig: String,
    codEmpleado: Int,
    nroHorasExtra: Int,
    fecIngreso: String,
    area: String,
    cargo: String,
    val honorariosxHora: Double,
    val nroHorasTotales: Int,
    val fechaFinContrato: String
) : Empleado(nroCC, nombre, apellido, fecNacimiento, direccion, ciudadOrig, codEmpleado, nroHorasExtra, fecIngreso, area, cargo)

// Clase Medico hereda de Empleadoxplanilla y añade detalles específicos de los médicos.
class Medico(
    nroCC: Int,
    nombre: String,
    apellido: String,
    fecNacimiento: String,
    direccion: String,
    ciudadOrig: String,
    codEmpleado: Int,
    nroHorasExtra: Int,
    fecIngreso: String,
    area: String,
    cargo: String,
    salarioMensual: Double,
    porcentajeAdicional: Double,
    val especialidad: String,
    val servicio: String,
    val nroConsultorio: Int
) : Empleadoxplanilla(nroCC, nombre, apellido, fecNacimiento, direccion, ciudadOrig, codEmpleado, nroHorasExtra, fecIngreso, area, cargo, salarioMensual, porcentajeAdicional)
