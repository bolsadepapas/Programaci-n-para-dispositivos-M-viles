/**
Descripción: El usuario debe adivinar un número aleatorio entre 1 y 30 en máximo 5 intentos
Autor: Facundo Sanz Palomino
Fecha creación: 2026-03-29
Fecha última modificación: 2026-03-29
 */

import kotlin.random.Random

// Función para leer los enteros
fun leerEntero(mensaje: String): Int {
    while (true) {
        print(mensaje)
        val input = readln().toIntOrNull()

        if (input != null) return input

        println("Error, Ingrese un número válido")
    }
}
// definimos una variable que usara el random pero solo tolerando numeros de 1 al 31
fun adivinaNumero() {
    val numeroSecreto = Random.nextInt(1, 31)
    var intentos = 5 // establecemos los intentos
    var ganado = false // esta en false hasta que gane

    while (intentos > 0) {
        val intento = leerEntero("Adivina el número (1-30): ")

        // Validación de rango
        if (intento !in 1..30) {
            println(" El número que ingreses debe estar entre 1 y 30")
            continue
        }

        if (intento == numeroSecreto) {
            println("Bien hecho adivinaste el número")
            ganado = true
            break // cuando el estado de ganado cambia a true lo que hara es parar el programa
        } else if (intento < numeroSecreto) {
            println("El número es mayor")
        } else {
            println("El número es menor")
        }

        intentos--
        println("Intentos restantes: $intentos")
    }

    if (!ganado) { // si "ganado" sigue con el atributo en False y los intentos estan acabados pues muestra el menasje
        println("Game Over. El número era: $numeroSecreto")
    }
}

fun main() {
    adivinaNumero()
}