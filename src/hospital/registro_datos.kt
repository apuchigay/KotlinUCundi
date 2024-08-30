import hospital.Empleado
import hospital.Medico
import hospital.Paciente

// Clase para el registro de datos
class RegistroServicio {
    // Listado definido de especialidades
    val especialidades = listOf("Cirugía", "Oftalmología", "Pediatría", "Cardiología", "Neurología", "Dermatología")
    val tipoSangre = listOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")
    val sexos = listOf("Masculino", "Femenino")
    val alergiaMedicamentos = listOf("Penicilinas", "Cefalosporinas", "Aspirina", "Ibuprofeno", "Sulfamidas", "Anestésicos")
    val ciudadOrigen = listOf("Bogotá", "Chía", "Zipaquira", "Cajica", "Sesquile", "Cota", "Sopó")
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

    fun listarPacientesPorMedico(medico: Medico) {
        val pacientesPorMedico = citas.filter { it.medico == medico }.map { it.paciente }

        if (pacientesPorMedico.isEmpty()) {
            println("No se encontraron pacientes para el médico: ${medico.nombre} ${medico.apellido}")
        } else {
            println("Pacientes atendidos por el Dr. ${medico.nombre} ${medico.apellido}:")
            pacientesPorMedico.forEach { println("${it.nombre} ${it.apellido}") }
        }
    }
}

data class CitaMedica(val paciente: Paciente, val medico: Medico, val fecha: String, val hora: String)