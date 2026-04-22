/*
Descripción: Sistema de gestión de biblioteca con materiales, usuarios y préstamos.
Autor: Facundo Sanz Palomino
Fecha creación: 04-04-2026
Fecha última modificación: 04-04-2026
*/

// Clase base
abstract class Material(
    val titulo: String,
    val autor: String,
    val anio: Int
) {
    abstract fun mostrarDetalles()
}

class Libro(
    titulo: String,
    autor: String,
    anio: Int,
    val genero: String,
    val paginas: Int
) : Material(titulo, autor, anio) {

    override fun mostrarDetalles() {
        println("📖 $titulo - $autor ($anio)")
    }
}

class Revista(
    titulo: String,
    autor: String,
    anio: Int,
    val issn: String,
    val volumen: Int
) : Material(titulo, autor, anio) {

    override fun mostrarDetalles() {
        println("📰 $titulo - Vol $volumen")
    }
}

data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
) {
    fun nombreCompleto() = "$nombre $apellido"
}

// Interfaz
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestar(usuario: Usuario, material: Material)
    fun devolver(usuario: Usuario, material: Material)
    fun verDisponibles()
    fun verPrestamos(usuario: Usuario)
}

// Implementación
class Biblioteca : IBiblioteca {

    private val disponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        disponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        prestamos.putIfAbsent(usuario, mutableListOf())
    }

    override fun prestar(usuario: Usuario, material: Material) {
        if (usuario !in prestamos || material !in disponibles) {
            println("No se puede prestar")
            return
        }

        disponibles.remove(material)
        prestamos[usuario]!!.add(material)
        println("Prestado: ${material.titulo}")
    }

    override fun devolver(usuario: Usuario, material: Material) {
        if (material in prestamos[usuario]!!) {
            prestamos[usuario]!!.remove(material)
            disponibles.add(material)
            println("Devuelto: ${material.titulo}")
        }
    }

    override fun verDisponibles() {
        println("\nMaterial disponible:")
        disponibles.forEach { it.mostrarDetalles() }
    }

    override fun verPrestamos(usuario: Usuario) {
        println("\nPréstamos de ${usuario.nombreCompleto()}:")
        prestamos[usuario]?.forEach { it.mostrarDetalles() }
    }
}

// MAIN
fun main() {

    val biblioteca = Biblioteca()

    val libro = Libro("Clean Code", "Robert Martin", 2008, "Programación", 400)
    val revista = Revista("Nature", "Varios", 2024, "1234", 10)

    val usuario = Usuario("Ana", "García", 22)

    biblioteca.registrarMaterial(libro)
    biblioteca.registrarMaterial(revista)
    biblioteca.registrarUsuario(usuario)

    biblioteca.verDisponibles()

    biblioteca.prestar(usuario, libro)
    biblioteca.verDisponibles()

    biblioteca.verPrestamos(usuario)

    biblioteca.devolver(usuario, libro)
    biblioteca.verDisponibles()
}