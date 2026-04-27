/*
 * Descripción:Aqui tenemos las acciones del usuario en el formulario.
 * Autor: Facundo
 * Fecha creación: 26/04/2026
 * Fecha última modificación: 26/04/2026
 */

package com.facundo.Practica4.mvi

sealed class FormularioIntent {
    data class NombreCambiado(val valor: String) : FormularioIntent()
    data class EdadCambiada(val valor: String) : FormularioIntent()
    data class CorreoCambiado(val valor: String) : FormularioIntent()
    data class GeneroCambiado(val valor: String) : FormularioIntent()
    data class TerminosAceptados(val valor: Boolean) : FormularioIntent()
    data class UsuarioActivoCambiado(val valor: Boolean) : FormularioIntent()
    data class NivelCambiado(val valor: Float) : FormularioIntent()
    object Registrar : FormularioIntent()
    object Limpiar : FormularioIntent()
}