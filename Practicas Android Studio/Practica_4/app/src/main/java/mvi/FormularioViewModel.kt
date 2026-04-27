/*
 * Descripción: ViewModel que gestiona el estado y la lógica MVI del formulario.
 * Autor: Facundo
 * Fecha creación: 26/04/2026
 * Fecha última modificación: 26/04/2026
 */

package com.facundo.Practica4.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormularioViewModel : ViewModel() {

    private val _state = MutableStateFlow(FormularioState())
    val state: StateFlow<FormularioState> = _state.asStateFlow()

    fun processIntent(intent: FormularioIntent) {
        when (intent) {
            is FormularioIntent.NombreCambiado -> updateNombre(intent.valor)
            is FormularioIntent.EdadCambiada -> updateEdad(intent.valor)
            is FormularioIntent.CorreoCambiado -> updateCorreo(intent.valor)
            is FormularioIntent.GeneroCambiado -> updateGenero(intent.valor)
            is FormularioIntent.TerminosAceptados -> updateTerminos(intent.valor)
            is FormularioIntent.UsuarioActivoCambiado -> updateUsuarioActivo(intent.valor)
            is FormularioIntent.NivelCambiado -> updateNivel(intent.valor)
            is FormularioIntent.Registrar -> registrar()
            is FormularioIntent.Limpiar -> limpiar()
        }
    }

    private fun updateNombre(valor: String) {
        val error = when {
            valor.isBlank() -> "El nombre no puede estar vacío"
            valor.length > 30 -> "Máximo 30 caracteres"
            else -> ""
        }
        val nuevo = _state.value.copy(
            nombre = valor.take(30),
            errorNombre = error
        )
        _state.value = nuevo.copy(formularioValido = validar(nuevo))
    }

    private fun updateEdad(valor: String) {
        val error = when {
            valor.isBlank() -> "La edad no puede estar vacía"
            !valor.all { it.isDigit() } -> "Solo se permiten números"
            valor.toIntOrNull()?.let { it < 1 || it > 120 } == true -> "Edad debe ser entre 1 y 120"
            else -> ""
        }
        val nuevo = _state.value.copy(edad = valor, errorEdad = error)
        _state.value = nuevo.copy(formularioValido = validar(nuevo))
    }

    private fun updateCorreo(valor: String) {
        val error = if (!valor.contains("@")) "El correo debe contener @" else ""
        val nuevo = _state.value.copy(correo = valor, errorCorreo = error)
        _state.value = nuevo.copy(formularioValido = validar(nuevo))
    }

    private fun updateGenero(valor: String) {
        val nuevo = _state.value.copy(genero = valor, errorGenero = "")
        _state.value = nuevo.copy(formularioValido = validar(nuevo))
    }

    private fun updateTerminos(valor: Boolean) {
        val error = if (!valor) "Debes aceptar los términos" else ""
        val nuevo = _state.value.copy(aceptaTerminos = valor, errorTerminos = error)
        _state.value = nuevo.copy(formularioValido = validar(nuevo))
    }

    private fun updateUsuarioActivo(valor: Boolean) {
        _state.value = _state.value.copy(usuarioActivo = valor)
    }

    private fun updateNivel(valor: Float) {
        _state.value = _state.value.copy(nivel = valor)
    }

    private fun validar(state: FormularioState): Boolean {
        return state.nombre.isNotBlank() &&
                state.errorNombre.isEmpty() &&
                state.edad.isNotBlank() &&
                state.errorEdad.isEmpty() &&
                state.correo.contains("@") &&
                state.errorCorreo.isEmpty() &&
                state.genero.isNotBlank() &&
                state.aceptaTerminos
    }

    private fun registrar() {
        val s = _state.value
        if (!s.formularioValido) return
        val resultado = "Usuario ${s.nombre}, ${s.edad} años, " +
                "${s.genero}, ${if (s.usuarioActivo) "activo" else "inactivo"}, " +
                "nivel ${s.nivel.toInt()}"
        _state.value = s.copy(resultado = resultado)
    }

    private fun limpiar() {
        _state.value = FormularioState()
    }
}