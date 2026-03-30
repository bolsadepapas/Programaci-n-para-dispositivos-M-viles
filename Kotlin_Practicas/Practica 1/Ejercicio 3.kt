/**
Descripción: Calculadora básica con menú interactivo y validación de errores
Autor: Facundo Sanz Palomino
Fecha creación: 2026-03-29

 */

// Funciones matemáticas
fun sumar(a: Double, b: Double) = a + b
fun restar(a: Double, b: Double) = a - b
fun multiplicar(a: Double, b: Double) = a * b


fun dividir(a: Double, b: Double): Double? {
    if (b == 0.0) return null
    return a / b
}

// funcion que lee los enteros
fun leerenteros(mensaje: String): Int {
    while (true) {
        print(mensaje)
        val input = readln().toIntOrNull()
        if (input != null) return input
        println("Ingrese un número entero válido")
    }
}

// funcion que lee los decimales
fun leerdecimal(mensaje: String): Double {
    while (true) {
        print(mensaje)
        val input = readln().toDoubleOrNull()
        if (input != null) return input
        println("Ingrese un número válido")
    }
}

// Muestra el menú principal
fun mostrarMenu() {
    println("\n--- MENÚ ---")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
}

// Lógica principal de la calculadora
fun calculadora() {
    var opcion: Int

    do {
        mostrarMenu()
        opcion = leerenteros("Seleccione una opción: ")

        if (opcion in 1..4) {
            val a = leerdecimal("Ingrese primer número: ")
            val b = leerdecimal("Ingrese segundo número: ")

            val resultado = when (opcion) {
                1 -> sumar(a, b)
                2 -> restar(a, b)
                3 -> multiplicar(a, b)
                4 -> dividir(a, b)
                else -> null
            }

            if (resultado == null) {
                println("Error,No se puede dividir entre 0")
            } else {
                println("Resultado: $resultado")
            }

        } else if (opcion != 5) {
            println("opción inválida")
        }

    } while (opcion != 5)

    println("Saliendo")
}

fun main() {
    calculadora()
}