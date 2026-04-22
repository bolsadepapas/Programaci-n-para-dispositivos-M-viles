/*
Descripción: Clase Producto que permite manejar precio y descuento,
calculando el precio final con validaciones.
Autor: Facundo Sanz Palomino
Fecha creación: 04-04-2026
Fecha última modificación: 04-04-2026
*/

class Producto {

    private var precio: Double = 0.0
    private var descuento: Double = 0.0

    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio > 0) {
            precio = nuevoPrecio
        } else {
            println("El precio debe ser mayor a 0")
        }
    }

    fun getPrecio(): Double = precio

    // Funcion que settea descuento con validación
    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento in 0.0..100.0) {
            descuento = nuevoDescuento
        } else {
            println("El escuento debe estar entre 0 y 100")
        }
    }

    // Funcuion getter descuento
    fun getDescuento(): Double = descuento

    // Funcion para calcular el precio final
    fun calcularPrecioFinal(): Double {
        return precio - (precio * descuento / 100)
    }
}


fun main() {
    val producto = Producto()

    producto.setPrecio(100.0)
    producto.setDescuento(20.0)

    println("Precio original: ${producto.getPrecio()}")
    println("Descuento: ${producto.getDescuento()}%")
    println("Precio final: ${producto.calcularPrecioFinal()}")
}