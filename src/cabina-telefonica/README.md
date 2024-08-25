# Gestión de Gastos Telefónicos en Cabinas

## Descripción

El siguiente programa permite gestionar a una empresa ficticia los gastos telefonicos de esta. Cuenta con la cantidad N de cabinas (dadas por el usuario) y la cual permite realizar ciertas funciones.
## Funcionalidades

- **Registrar una llamada:** Permite ingresar la duración y el tipo de llamada (local, larga distancia o celular) para cada cabina.
- **Mostrar información detallada:** Muestra el número de llamadas realizadas, la duración total de las llamadas y el costo total para una cabina específica.
- **Consolidado total:** Proporciona un resumen de todas las cabinas, incluyendo el costo total, el número total de llamadas y la duración total.
- **Reiniciar cabina:** Permite restablecer todos los valores de una cabina en especifico a cero. El usuario escoge la cabina

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