/*
 * Descripción: UI del formulario.
 * Autor: Facundo
 * Fecha creación: 26/04/2026
 * Fecha última modificación: 26/04/2026
 */

package com.facundo.Practica4.mvi

data class FormularioState(
    val nombre: String = "",
    val edad: String = "",
    val correo: String = "",
    val genero: String = "",
    val aceptaTerminos: Boolean = false,
    val usuarioActivo: Boolean = false,
    val nivel: Float = 1f,

    val errorNombre: String = "",
    val errorEdad: String = "",
    val errorCorreo: String = "",
    val errorGenero: String = "",
    val errorTerminos: String = "",

    val resultado: String = "",
    val formularioValido: Boolean = false
)