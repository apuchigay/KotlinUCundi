package hospital
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main(){
    val registroServicio = RegistroServicio()
    while(true){
        print("""
            ---------------- // Menu del hospital // ----------------
            1. Registrar un paciente
            2. Registrar un medico
            3. Registrar cita medica
            4. Listar medicos por especialidad
            5. Listar pacientes por medico
            6. Salir
            
            Seleccione una opción:
        """.trimIndent())

        when(readln().toInt()){
            1->{

            }
        }
    }
}