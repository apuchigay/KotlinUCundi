package hospital
import RegistroServicio

fun main() {
    val registroServicio = RegistroServicio()
    while (true) {
        print("""
            ---------------- // Menu del hospital // ----------------
            1. Registrar un empleado
            2. Registrar un medico
            3. Registar un paciente
            4. Registrar cita medica
            5. Listar medicos por especialidad
            6. Listar pacientes por medico
            7. Salir
            
            Seleccione una opción:
        """.trimIndent())

        when (readln().toInt()) {
            1 -> registrarEmpleado(registroServicio)
            2 -> registrarMedico(registroServicio)
            3 -> registrarPaciente(registroServicio)
            4 -> registrarCitaMedica(registroServicio)
            5 -> listarMedicosPorEspecialidad(registroServicio)
            6 -> listarPacientesPorMedico(registroServicio)
            7 -> break
        }
    }
}