/*
 * Descripción: Modelo de datos para representar un contacto.
 * Autor: Facundo
 * Fecha creación: 01/05/2026
 * Fecha última modificación: 01/05/2026
 */

package com.facundo.practica6

data class Contacto(
    val id: Int,
    val nombre: String,
    val telefono: String,
    val favorito: Boolean = false
)