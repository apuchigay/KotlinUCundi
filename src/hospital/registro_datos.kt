import hospital.Empleado
import hospital.Medico
import hospital.Paciente

// Clase para el registro de datos
class RegistroServicio {
    // Listado definido de especialidades
    val especialidades = listOf("Cirugía", "Oftalmología", "Pediatría", "Cardiología", "Neurología", "Dermatología")
    // Listado de las entidades del sistema
    val empleados = mutableListOf<Empleado>()
    val medicos = mutableListOf<Medico>()
    val pacientes = mutableListOf<Paciente>()
    val citas = mutableListOf<CitaMedica>()

    fun registrarEmpleado(empleado: Empleado) {
        empleados.add(empleado)
    }

    fun registrarPaciente(paciente: Paciente) {
        pacientes.add(paciente)
    }

    fun registrarMedico(medico: Medico) {
        medicos.add(medico)
    }

    fun listarMedicosPorEspecialidad(especialidad: String) {
        val medicosPorEspecialidad = medicos.filter { it.especialidad == especialidad }
        if (medicosPorEspecialidad.isEmpty()) {
            println("No se encontraron médicos con la especialidad: $especialidad")
        } else {
            println("Médicos con especialidad $especialidad:")
            medicosPorEspecialidad.forEach { println("${it.nombre} ${it.apellido}") }
        }
    }

    fun registrarCita(paciente: Paciente, medico: Medico, fechaCita: String, horaCita: String) {
        val cita = CitaMedica(paciente, medico, fechaCita, horaCita)
        citas.add(cita)
    }
}

data class CitaMedica(val paciente: Paciente, val medico: Medico, val fecha: String, val hora: String)