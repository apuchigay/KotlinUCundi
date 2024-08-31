package hospital
import RegistroServicio

// Funcion para registrar un empleado
fun registrarEmpleado(registroServicio: RegistroServicio) {
    // Solicitud de datos del empleado
    println("Ingrese los datos del empleado:")
    print("Número de C.C.: ")
    val nroCC = readln().toInt()
    print("Nombre: ")
    val nombre = readln()
    print("Apellido: ")
    val apellido = readln()
    print("Fecha de nacimiento (DD/MM/YYYY): ")
    val fecNacimiento = readln()
    print("Dirección: ")
    val direccion = readln()

    // Validador de ciudad origen
    println("Seleccione la ciudad de origen:")
    registroServicio.ciudadOrigen.forEachIndexed { index, ciudad ->
        println("${index + 1}. $ciudad")
    }
    val ciudadIndex = readln().toInt() - 1
    val ciudadOrig = registroServicio.ciudadOrigen[ciudadIndex]

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
        val empleado = Empleadoxplanilla(nroCC, nombre, apellido, fecNacimiento, direccion, ciudadOrig,
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
        val empleado = EmpleadoEventual(nroCC, nombre, apellido, fecNacimiento, direccion, ciudadOrig,
            codEmpleado, nroHorasExtra, fecIngreso, area, cargo,
            honorariosxHora, nroHorasTotales, fechaFinContrato)
        registroServicio.registrarEmpleado(empleado)
    }

    println("Empleado registrado exitosamente.")
}

// Funcion para registar un medico
fun registrarMedico(registroServicio: RegistroServicio) {
    println("Ingrese los datos del médico:")
    print("Número de C.C.: ")
    val nroCC = readln().toInt()
    print("Nombre: ")
    val nombre = readln()
    print("Apellido: ")
    val apellido = readln()
    print("Fecha de nacimiento (dd/mm/yyyy): ")
    val fecNacimiento = readln()
    print("Dirección: ")
    val direccion = readln()

    // Validador de ciudad origen
    println("Seleccione la ciudad de origen:")
    registroServicio.ciudadOrigen.forEachIndexed { index, ciudad ->
        println("${index + 1}. $ciudad")
    }
    val ciudadIndex = readln().toInt() - 1
    val ciudadOrig = registroServicio.ciudadOrigen[ciudadIndex]

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
    val medico = Medico(nroCC, nombre, apellido, fecNacimiento, direccion, ciudadOrig, codEmpleado, nroHorasExtra, fecIngreso, area, cargo, salarioMensual, porcentajeAdicional, especialidadSeleccionada, servicio, nroConsultorio)
    registroServicio.registrarMedico(medico)
    println("Médico registrado exitosamente.")
}

// Funcion para registrar cita medica
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

    val paciente = registroServicio.pacientes.find { it.nroCC == dniPaciente }
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

// Funcion para registrar paciente
fun registrarPaciente(registroServicio: RegistroServicio) {
    println("Ingrese los datos del paciente:")
    print("Número de C.C.: ")
    val nroCC = readln().toInt()
    print("Nombre: ")
    val nombre = readln()
    print("Apellido: ")
    val apellido = readln()
    print("Fecha de nacimiento (dd/mm/yyyy): ")
    val fecNacimiento = readln()
    print("Dirección: ")
    val direccion = readln()

    //Validador ciudad origen
    println("Seleccione la ciudad de origen:")
    registroServicio.ciudadOrigen.forEachIndexed { index, ciudad ->
        println("${index + 1}. $ciudad")
    }
    val ciudadIndex = readln().toInt() - 1
    val ciudadOrig = registroServicio.ciudadOrigen[ciudadIndex]

    print("Número de historia clínica: ")
    val nroHistClinica = readln().toInt()

    // Validador listado sexo del paciente
    println("Seleccionar sexo:")
    registroServicio.sexos.forEachIndexed { index, sexo ->
        println("${index + 1}. $sexo")
    }
    val sexo = registroServicio.sexos[readln().toInt() - 1]

    // Validador listado grupo sanguineo
    println("Seleccione el grupo sanguíneo del paciente:")
    registroServicio.tipoSangre.forEachIndexed { index, tipo ->
        println("${index + 1}. $tipo")
    }
    val grupoSangre = registroServicio.tipoSangre[readln().toInt() - 1]

    // Validador de medicamentos alergico
    println("Seleccione un medicamento al que sea alergico: ")
    registroServicio.alergiaMedicamentos.forEachIndexed { index, tipo ->
        println("${index+1}. $tipo")
    }
    val medicamentoAlergico = registroServicio.alergiaMedicamentos[readln().toInt()-1]

    // Crear el objeto Paciente y registrarlo
    val paciente = Paciente(nroCC, nombre, apellido, fecNacimiento, direccion, ciudadOrig, nroHistClinica, sexo, grupoSangre, medicamentoAlergico)
    registroServicio.registrarPaciente(paciente)
    println("Paciente registrado exitosamente.")
}

fun listarMedicosPorEspecialidad(registroServicio: RegistroServicio) {
    println("Seleccione la especialidad para listar médicos:")
    registroServicio.especialidades.forEachIndexed { index, especialidad ->
        println("${index + 1}. $especialidad")
    }
    val opcionEspecialidad = readln().toInt()
    val especialidadSeleccionada = registroServicio.especialidades[opcionEspecialidad - 1]

    registroServicio.listarMedicosPorEspecialidad(especialidadSeleccionada)
}

// Funcion para listar paciente por medico
fun listarPacientesPorMedico(registroServicio: RegistroServicio) {
    if (registroServicio.medicos.isEmpty()) {
        println("No hay médicos registrados en el sistema.")
        return
    }

    println("Seleccione un médico para listar sus pacientes:")
    registroServicio.medicos.forEachIndexed { index, medico ->
        println("${index + 1}. Dr. ${medico.nombre} ${medico.apellido} - Especialidad: ${medico.especialidad}")
    }

    val opcionMedico = readln().toInt()
    if (opcionMedico in 1..registroServicio.medicos.size) {
        val medicoSeleccionado = registroServicio.medicos[opcionMedico - 1]
        registroServicio.listarPacientesPorMedico(medicoSeleccionado)
    } else {
        println("Opción inválida, por favor intente de nuevo.")
    }
}
