/**
Descripción: Juego Piedra, Papel o Tijera contra la computadora con validación de entrada
Autor: Facundo Sanz Palomino
Fecha creación: 2026-03-29
Fecha última modificación: 2026-03-29
 */

import kotlin.random.Random

// Genera elección aleatoria de la computadora
fun obtenerselectcompu(): String {
    val opciones = listOf("piedra", "papel", "tijera")
    return opciones.random()
}

// Lee y valida el texto introducido por el usuario
fun opcionusuario(): String {
    val opcionesValidas = listOf("piedra", "papel", "tijera")

    while (true) {
        print("Elige piedra, papel o tijera: ")
        val entrada = readln().lowercase()

        if (entrada in opcionesValidas) {
            return entrada
        }

        println("Opción inválida. Intente nuevamente.")
    }
}

// Logica central, establece los escenarios y determian en cuales nosotros ganamos
fun determinarGanador(usuario: String, computadora: String): String {
    return when {
        usuario == computadora -> "Empate"
        usuario == "piedra" && computadora == "tijera" -> "Ganaste"
        usuario == "papel" && computadora == "piedra" -> "Ganaste"
        usuario == "tijera" && computadora == "papel" -> "Ganaste"
        else -> "Perdiste"
    }
}

// Ejecuta el juego
fun ejecutarJuego() {
    val usuario = opcionusuario()
    val computadora = obtenerselectcompu()

    println("Computadora eligió: $computadora")
    println(determinarGanador(usuario, computadora))
}

fun main() {
    ejecutarJuego()
}