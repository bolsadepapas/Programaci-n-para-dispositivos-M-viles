/**
Descripcion del ejercicio, lo que nos pide es que calcular el rendimiento y el dinero que se recibe según la puntuación
Autor: Facundo Sanz Palomino
Fecha de Creacion: 29/03/2026
*/

// Funcion para el nombre de la persona
fun obtenernombre() {

fun nivel(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación no valida"
    }
}
// Aqui lo que vamos a hacer es que dependiendo de la puntuacion vamos a obtener el salario meritorio
fun dinero(salario: Double, puntuacion: Int): Double {
    return salario * (puntuacion/ 10.0)
}

    println("Ingrese su nombre: ")
    val nm = readLine()

    println("Ingrese su salario mensual: ")
    val salario = readln().toDouble()

    print("Ingrese su puntuacion (0-10): ")
    val puntuacion = readln().toInt()

    val vl = nivel(puntuacion)
    val dnr = dinero(salario, puntuacion)

    println("EL nivel de rendimiento de $nm es: $vl")
    println("La cantidad de dinero que recibira: $${dnr}")
}

fun main() {
    obtenernombre()
}