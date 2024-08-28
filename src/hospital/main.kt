package hospital
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val registroServicio = RegistroServicio()
    while (true) {
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

        when (readln().toInt()) {
            1 -> registrarEmpleado(registroServicio)
            2 -> registrarMedico(registroServicio)
            3 -> println("\nSe vienen cositas proximamente. Tu espera\n")
            4 -> println("\nSe vienen cositas proximamente. Tu espera\n")
            5 -> println("\nSe vienen cositas proximamente. Tu espera\n")
            6 -> break
        }
    }
}

fun registrarEmpleado(registroServicio: RegistroServicio) {
    println("Ingrese los datos del empleado:")
    print("Número de DNI: ")
    val nroDni = readln().toInt()
    print("Nombre: ")
    val nombre = readln()
    print("Apellido: ")
    val apellido = readln()
    print("Fecha de nacimiento (DD/MM/YYYY): ")
    val fecNacimiento = readln()
    print("Dirección: ")
    val direccion = readln()
    print("Ciudad de origen: ")
    val ciudadOrig = readln()
    print("Código de empleado: ")
    val codEmpleado = readln().toInt()
    print("Número de horas extras: ")
    val nroHorasExtra = readln().toInt()
    print("Fecha de ingreso (DD/MM/YYYY): ")
    val fecIngreso = readln()
    print("Área: ")
    val area = readln()
    print("Cargo: ")
    val cargo = readln()

    // Crear empleado por plantilla
    print("¿El empleado es por planilla? (si/no): ")
    val esPorPlanilla = readln().lowercase() == "si"

    if (esPorPlanilla) {
        print("Salario mensual: ")
        val salarioMensual = readln().toDouble()
        print("Porcentaje adicional por hora extra: ")
        val porcentajeAdicional = readln().toDouble()

        // Crear un nuevo empleado por planilla
        val empleado = Empleadoxplanilla(nroDni, nombre, apellido, fecNacimiento, direccion, ciudadOrig,
            codEmpleado, nroHorasExtra, fecIngreso, area, cargo,
            salarioMensual, porcentajeAdicional)
        registroServicio.registrarEmpleado(empleado)
    } else {
        print("Honorarios por hora: ")
        val honorariosxHora = readln().toDouble()
        print("Número de horas totales (normales + extras) trabajadas: ")
        val nroHorasTotales = readln().toInt()
        print("Fecha de término del contrato (DD/MM/YYYY): ")
        val fechaFinContrato = readln()

        // Crear un nuevo empleado eventual
        val empleado = EmpleadoEventual(nroDni, nombre, apellido, fecNacimiento, direccion, ciudadOrig,
            codEmpleado, nroHorasExtra, fecIngreso, area, cargo,
            honorariosxHora, nroHorasTotales, fechaFinContrato)
        registroServicio.registrarEmpleado(empleado)
    }

    println("Empleado registrado exitosamente.")
}

fun registrarMedico(registroServicio: RegistroServicio) {
    println("Ingrese los datos del médico:")
    print("Número de DNI: ")
    val nroDni = readln().toInt()
    print("Nombre: ")
    val nombre = readln()
    print("Apellido: ")
    val apellido = readln()
    print("Fecha de nacimiento (DD/MM/YYYY): ")
    val fecNacimiento = readln()
    print("Dirección: ")
    val direccion = readln()
    print("Ciudad de origen: ")
    val ciudadOrig = readln()
    print("Código de empleado: ")
    val codEmpleado = readln().toInt()
    print("Número de horas extras: ")
    val nroHorasExtra = readln().toInt()
    print("Fecha de ingreso (DD/MM/YYYY): ")
    val fecIngreso = readln()
    print("Área: ")
    val area = readln()
    print("Cargo: ")
    val cargo = readln()
    print("Salario mensual: ")
    val salarioMensual = readln().toDouble()
    print("Porcentaje adicional por hora extra: ")
    val porcentajeAdicional = readln().toDouble()
    print("Especialidad (cirujano, oftalmólogo, etc.): ")
    val especialidad = readln()
    print("Servicio (cirugía, oftalmología, etc.): ")
    val servicio = readln()
    print("Número de consultorio: ")
    val nroConsultorio = readln().toInt()

    // Crear un nuevo médico
    val medico = Medico(nroDni, nombre, apellido, fecNacimiento, direccion, ciudadOrig,
        codEmpleado, nroHorasExtra, fecIngreso, area, cargo,
        salarioMensual, porcentajeAdicional, especialidad, servicio, nroConsultorio)

    registroServicio.registrarMedico(medico)

    println("Médico registrado exitosamente.")
}