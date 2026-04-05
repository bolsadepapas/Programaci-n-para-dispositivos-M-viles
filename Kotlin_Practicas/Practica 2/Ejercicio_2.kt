/*
Descripción: diseño e implementación de una jerarquía de clases en Kotlin para representar diferentes figuras geométricas
Autor: Facundo Sanz Palomino
Fecha: 04-01-2026
Fecha última modificación: 04-04-2026
*/

import kotlin.math.PI

// Clase base
abstract class Shape {

    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun mostrarInfo() {
        println("Figura     : ${this::class.simpleName}")
        println("Area       : ${"%.2f".format(calcularArea())}")
        println("Perimetro  : ${"%.2f".format(calcularPerimetro())}")
    }
}


class Cuadrado(private val lado: Double) : Shape() {

    init {
        require(lado > 0) { "El lado debe ser mayor que 0" }
    }

    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}


class Circulo(private val radio: Double) : Shape() {

    init {
        require(radio > 0) { "El radio debe ser mayor que 0" }
    }

    override fun calcularArea(): Double {
        return PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * PI * radio
    }
}

class Rectangulo(
    private val base: Double,
    private val altura: Double
) : Shape() {

    init {
        require(base > 0 && altura > 0) { "Base y altura deben ser mayores que 0" }
    }

    override fun calcularArea(): Double {
        return base * altura
    }

    override fun calcularPerimetro(): Double {
        return 2 * (base + altura)
    }
}

fun main() {

    println(" Calculo de figuras \n")

    val cuadrado = Cuadrado(5.0)
    println("Cuadrado (lado = 5)")
    cuadrado.mostrarInfo()

    val circulo = Circulo(7.0)
    println("\nCírculo (radio = 7)")
    circulo.mostrarInfo()

    val rectangulo = Rectangulo(8.0, 4.0)
    println("\nRectángulo (base = 8, altura = 4)")
    rectangulo.mostrarInfo()

    println("\n Listado de las figuras \n")

    val listaFiguras = listOf(
        Cuadrado(3.0),
        Circulo(2.5),
        Rectangulo(6.0, 3.0),
        Cuadrado(10.0),
        Circulo(1.0)
    )

    listaFiguras.forEach {
        it.mostrarInfo()
        println()
    }
}