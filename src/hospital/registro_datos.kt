import hospital.Empleado
import hospital.Medico
import hospital.Paciente

// Clase que gestiona el registro de datos en el sistema
class RegistroServicio {

    // Listado de valores por defecto para evitar errores de entrada y garantizar consistencia en los datos
    val especialidades = listOf("Cirugía", "Oftalmología", "Pediatría", "Cardiología", "Neurología", "Dermatología")
    val tipoSangre = listOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")
    val sexos = listOf("Masculino", "Femenino")
    val alergiaMedicamentos = listOf("Penicilinas", "Cefalosporinas", "Aspirina", "Ibuprofeno", "Sulfamidas", "Anestésicos")
    val ciudadOrigen = listOf("Bogotá", "Chía", "Zipaquira", "Cajica", "Sesquile", "Cota", "Sopó")

    // Listado de entidades manejadas por el sistema. Los listados son mutables
    val empleados = mutableListOf<Empleado>()
    val medicos = mutableListOf<Medico>()
    val pacientes = mutableListOf<Paciente>()
    val citas = mutableListOf<CitaMedica>()

    // Metodo para registrar un nuevo empleado en el sistema
    fun registrarEmpleado(empleado: Empleado) {
        empleados.add(empleado)
    }

    // Metodo para registrar un nuevo paciente en el sistema
    fun registrarPaciente(paciente: Paciente) {
        pacientes.add(paciente)
    }

    // Metodo para registrar un nuevo médico en el sistema
    fun registrarMedico(medico: Medico) {
        medicos.add(medico)
    }

    // Metodo para listar médicos por especialidad
    fun listarMedicosPorEspecialidad(especialidad: String) {
        val medicosPorEspecialidad = medicos.filter { it.especialidad == especialidad }  // Filtra médicos por especialidad

        if (medicosPorEspecialidad.isEmpty()) {
            println("No se encontraron médicos con la especialidad: $especialidad")
        } else {
            println("Médicos con especialidad $especialidad:")
            medicosPorEspecialidad.forEach { println("${it.nombre} ${it.apellido}") }
        }
    }

    // Metodo para registrar una nueva cita médica en el sistema
    fun registrarCita(paciente: Paciente, medico: Medico, fechaCita: String, horaCita: String) {
        val cita = CitaMedica(paciente, medico, fechaCita, horaCita)  // Crea una nueva instancia de CitaMedica
        citas.add(cita)
    }

    // Metodo para listar pacientes atendidos por un médico específico
    fun listarPacientesPorMedico(medico: Medico) {
        val pacientesPorMedico = citas.filter { it.medico == medico }.map { it.paciente }  // Filtra citas por médico y obtiene los pacientes

        if (pacientesPorMedico.isEmpty()) {
            println("No se encontraron pacientes para el médico: ${medico.nombre} ${medico.apellido}")
        } else {
            println("Pacientes atendidos por el Dr. ${medico.nombre} ${medico.apellido}:")
            pacientesPorMedico.forEach { println("${it.nombre} ${it.apellido}") }
        }
    }
}

// Clase de datos para representar una cita médica
data class CitaMedica(
    val paciente: Paciente,  // Paciente asociado a la cita
    val medico: Medico,      // Médico que atiende la cita
    val fecha: String,       // Fecha de la cita
    val hora: String         // Hora de la cita
)
