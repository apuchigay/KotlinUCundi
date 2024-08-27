# Gestión de Gastos Telefónicos en Cabinas

## Descripción

El siguiente programa permite gestionar a una empresa ficticia los gastos telefonicos de esta. Inicia con una cabina la ejecución del programa y posteriormente se le da la opción de añadir n cantidad de cabinas si así lo requiere
## Funcionalidades

- **Registrar una llamada:** Permite seleccionar una cabina y el tipo de llamada (local, larga distancia o celular). La duración de la llamada será un valor aleatorio entre 1 y 60 (en minutos)
- **Mostrar información detallada:** Muestra el número de llamadas realizadas, la duración total de las llamadas y el costo total para todas las cabinas dentro del listado de estas.
- **Consolidado total:** Proporciona un resumen de todas las cabinas, incluyendo el costo total, el número total de llamadas y la duración total.
- **Reiniciar cabina:** Permite restablecer todos los valores de una cabina en especifico a cero. El usuario escoge la cabina.
- **Añadir cabina**: Permite al usuario añadir más cabinas en caso de ser necesario. Digitará cuantas cabinas desea añadir nuevas 

## Tarifas

Las tarifas para cada tipo de llamada son las siguientes:
- **Llamada Local:** $50 COP por minuto.
- **Llamada Larga Distancia:** $350 COP por minuto.
- **Llamada Celular:** $150 COP por minuto.

## Instalación

1. Clonar el siguiente repositorio en la maquina local:
   ```bash
   git clone https://github.com/apuchigay/KotlinUCundi.git
2. ingresar a la ruta `src/cabina-telefonica` y ejecutar el programa en IntelliJ IDEA o en cualquier IDE compatible con el lenguaje Kotlin