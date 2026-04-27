/*
 * Descripción: Clase de datos para representar un perfil de usuario serializable.
 * Autor: Facundo
 * Fecha creación: 22/04/2026
 * Fecha última modificación: 22/04/2026
 */

package com.facundo.Practica4

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val edad: Int,
    val ciudad: String,
    val correo: String
) : Serializable