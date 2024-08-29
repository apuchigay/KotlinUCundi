package hospital
import RegistroServicio
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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
            5 -> println("\nSe vienen cositas proximamente. Tu espera\n")
            6 -> println("\nSe vienen cositas proximamente. Tu espera\n")
            7 -> break
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
    print("Fecha de nacimiento (dd/mm/yyyy): ")
    val fecNacimiento = readln()
    print("Dirección: ")
    val direccion = readln()
    print("Ciudad de procedencia: ")
    val ciudadOrig = readln()
    print("Código de Empleado: ")
    val codEmpleado = readln().toInt()
    print("Número de horas extra: ")
    val nroHorasExtra = readln().toInt()
    print("Fecha de ingreso (dd/mm/yyyy): ")
    val fecIngreso = readln()
    print("Área: ")
    val area = readln()
    print("Cargo: ")
    val cargo = readln()

    // Mostrar las especialidades disponibles
    println("Seleccione la especialidad del médico:")
    registroServicio.especialidades.forEachIndexed { index, especialidad ->
        println("${index + 1}. $especialidad")
    }
    val opcionEspecialidad = readln().toInt()
    val especialidadSeleccionada = registroServicio.especialidades[opcionEspecialidad - 1]

    print("Servicio: ")
    val servicio = readln()
    print("Número de consultorio: ")
    val nroConsultorio = readln().toInt()
    print("Salario Mensual: ")
    val salarioMensual = readln().toDouble()
    print("Porcentaje adicional por hora extra: ")
    val porcentajeAdicional = readln().toDouble()

    // Crear el objeto Medico y registrarlo
    val medico = Medico(nroDni, nombre, apellido, fecNacimiento, direccion, ciudadOrig, codEmpleado, nroHorasExtra, fecIngreso, area, cargo, salarioMensual, porcentajeAdicional, especialidadSeleccionada, servicio, nroConsultorio)
    registroServicio.registrarMedico(medico)
    println("Médico registrado exitosamente.")
}

fun registrarCitaMedica(registroServicio: RegistroServicio) {
    if (registroServicio.pacientes.isEmpty()) {
        println("No hay pacientes registrados.")
        return
    }

    if (registroServicio.medicos.isEmpty()) {
        println("No hay médicos registrados.")
        return
    }

    println("Ingrese el número de DNI del paciente:")
    val dniPaciente = readln().toIntOrNull()

    val paciente = registroServicio.pacientes.find { it.nroDni == dniPaciente }
    if (paciente == null) {
        println("Paciente no encontrado.")
        return
    }

    println("Seleccione el código del médico:")
    registroServicio.medicos.forEach { medico ->
        println("Código: ${medico.codEmpleado}, Nombre: ${medico.nombre} ${medico.apellido}, Especialidad: ${medico.especialidad}")
    }

    val codigoMedico = readln().toIntOrNull()
    val medico = registroServicio.medicos.find { it.codEmpleado == codigoMedico }
    if (medico == null) {
        println("Médico no encontrado.")
        return
    }

    println("Ingrese la fecha de la cita (DD/MM/YYYY):")
    val fechaCita = readln()
    println("Ingrese la hora de la cita (HH:MM):")
    val horaCita = readln()

    // Registro de la cita
    registroServicio.registrarCita(paciente, medico, fechaCita, horaCita)

    println("Cita médica registrada exitosamente.")
}

fun registrarPaciente(registroServicio: RegistroServicio) {
    println("Ingrese los datos del paciente:")
    print("Número de DNI: ")
    val nroDni = readln().toInt()
    print("Nombre: ")
    val nombre = readln()
    print("Apellido: ")
    val apellido = readln()
    print("Fecha de nacimiento (dd/mm/yyyy): ")
    val fecNacimiento = readln()
    print("Dirección: ")
    val direccion = readln()
    print("Ciudad de procedencia: ")
    val ciudadOrig = readln()
    print("Número de historia clínica: ")
    val nroHistClinica = readln().toInt()
    print("Sexo: ")
    val sexo = readln()
    print("Grupo sanguíneo: ")
    val grupSangre = readln()
    print("Lista de medicamentos a los que es alérgico: ")
    val medicAlergico = readln()

    // Crear el objeto Paciente y registrarlo
    val paciente = Paciente(nroDni, nombre, apellido, fecNacimiento, direccion, ciudadOrig, nroHistClinica, sexo, grupSangre, medicAlergico)
    registroServicio.registrarPaciente(paciente)
    println("Paciente registrado exitosamente.")
}