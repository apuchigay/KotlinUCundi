# Sistema de Gestión Hospitalaria

## Descripción

Este proyecto es un sistema de gestión para un hospital que permite registrar y gestionar la información de las personas asociadas a la institución, incluyendo empleados, médicos y pacientes. Además, facilita el proceso de registro de citas médicas y la organización de los servicios médicos.

## Funcionalidades

El sistema incluye las siguientes funcionalidades:

1. **Registro de Empleados**:
    - Los empleados pueden ser registrados como empleados por Planilla o Eventuales.
    - Se registran atributos como código de empleado, número de horas extras, fecha de ingreso, área, cargo, salario mensual, honorarios por hora, entre otros.

2. **Registro de Médicos**:
    - Los médicos, como un tipo especial de empleados por Planilla, se registran con su especialidad, servicio, y número de consultorio.

3. **Registro de Pacientes**:
    - Los pacientes se registran con datos como número de historia clínica, sexo, grupo sanguíneo y alergias.

4. **Registro de Citas Médicas**:
    - Permite registrar citas médicas, donde un empleado atiende al paciente y coordina con el médico para agendar la fecha y hora de la consulta.

5. **Listado de Médicos por Especialidad**:
    - Muestra una lista de médicos agrupados por su especialidad.

6. **Listado de Pacientes por Médico**:
    - Permite listar los nombres y apellidos de los pacientes atendidos por un médico específico, ingresando su código.

## Estructura de Datos

### Persona
- **DNI:** Número de documento nacional de identidad.
- **Nombre:** Nombre de la persona.
- **Apellido:** Apellido de la persona.
- **Fecha de nacimiento:** Fecha de nacimiento.
- **Dirección:** Dirección de residencia.
- **Ciudad de procedencia:** Ciudad de origen.

### Paciente
- **Número de historia clínica:** Identificador único del paciente.
- **Sexo:** Género del paciente.
- **Grupo sanguíneo:** Tipo de sangre.
- **Lista de medicamentos alérgicos:** Medicamentos a los que el paciente es alérgico.

### Empleado
- **Código de empleado:** Identificador único del empleado.
- **Número de horas extras:** Cantidad de horas extras trabajadas.
- **Fecha de ingreso:** Fecha de ingreso al hospital.
- **Área:** Área en la que trabaja el empleado.
- **Cargo:** Cargo que ocupa el empleado.

### Empleado por Planilla
- **Salario mensual:** Salario base mensual.
- **Porcentaje adicional por hora extra:** Adicional por horas extras trabajadas.

### Empleado Eventual
- **Honorarios por hora:** Pago por hora trabajada.
- **Número de horas totales:** Total de horas trabajadas (normales + extras).
- **Fecha de término del contrato:** Fecha en la que finaliza el contrato.

### Médico
- **Especialidad:** Especialidad médica (ej. cirujano, oftalmólogo).
- **Servicio:** Servicio hospitalario al que pertenece (ej. cirugía, oftalmología).
- **Número de consultorio:** Identificación del consultorio donde atiende.

## Instalación

Para ejecutar el proyecto, sigue estos pasos:

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu_usuario/sistema-gestion-hospitalaria.git
