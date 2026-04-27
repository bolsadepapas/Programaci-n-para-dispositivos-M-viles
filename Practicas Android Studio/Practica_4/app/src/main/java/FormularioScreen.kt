/*
 * Descripción: Vista usando compose de el trabajo numero 5?, formulario, aplicamos MVI.
 * Autor: Facundo
 * Fecha creación: 26/04/2026
 * Fecha última modificación: 26/04/2026
 */

package com.facundo.Practica4.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.facundo.Practica4.mvi.FormularioIntent
import com.facundo.Practica4.mvi.FormularioViewModel

@Composable
fun FormularioScreen(
    viewModel: FormularioViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Registro de Usuario", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        // Nombre
        OutlinedTextField(
            value = state.nombre,
            onValueChange = { viewModel.processIntent(FormularioIntent.NombreCambiado(it)) },
            label = { Text("Nombre") },
            supportingText = {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(state.errorNombre, color = MaterialTheme.colorScheme.error)
                    Text("${state.nombre.length}/30")
                }
            },
            isError = state.errorNombre.isNotEmpty(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Edad
        OutlinedTextField(
            value = state.edad,
            onValueChange = { viewModel.processIntent(FormularioIntent.EdadCambiada(it)) },
            label = { Text("Edad") },
            supportingText = {
                Text(state.errorEdad, color = MaterialTheme.colorScheme.error)
            },
            isError = state.errorEdad.isNotEmpty(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Correo
        OutlinedTextField(
            value = state.correo,
            onValueChange = { viewModel.processIntent(FormularioIntent.CorreoCambiado(it)) },
            label = { Text("Correo electrónico") },
            supportingText = {
                Text(state.errorCorreo, color = MaterialTheme.colorScheme.error)
            },
            isError = state.errorCorreo.isNotEmpty(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Género
        Text("Género", fontWeight = FontWeight.Medium)
        Row(verticalAlignment = Alignment.CenterVertically) {
            listOf("Masculino", "Femenino", "Otro").forEach { opcion ->
                RadioButton(
                    selected = state.genero == opcion,
                    onClick = { viewModel.processIntent(FormularioIntent.GeneroCambiado(opcion)) }
                )
                Text(opcion, modifier = Modifier.padding(end = 12.dp))
            }
        }
        if (state.errorGenero.isNotEmpty()) {
            Text(state.errorGenero, color = MaterialTheme.colorScheme.error, fontSize = 12.sp)
        }

        // Slider
        Text("Nivel de experiencia: ${state.nivel.toInt()}", fontWeight = FontWeight.Medium)
        Slider(
            value = state.nivel,
            onValueChange = { viewModel.processIntent(FormularioIntent.NivelCambiado(it)) },
            valueRange = 1f..10f,
            steps = 8,
            modifier = Modifier.fillMaxWidth()
        )

        // Switch
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Usuario activo", fontWeight = FontWeight.Medium)
            Switch(
                checked = state.usuarioActivo,
                onCheckedChange = { viewModel.processIntent(FormularioIntent.UsuarioActivoCambiado(it)) }
            )
        }

        // Checkbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = state.aceptaTerminos,
                onCheckedChange = { viewModel.processIntent(FormularioIntent.TerminosAceptados(it)) }
            )
            Text("Acepto los términos y condiciones")
        }
        if (state.errorTerminos.isNotEmpty()) {
            Text(state.errorTerminos, color = MaterialTheme.colorScheme.error, fontSize = 12.sp)
        }

        // Botón Registrar
        Button(
            onClick = { viewModel.processIntent(FormularioIntent.Registrar) },
            enabled = state.formularioValido,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }

        // Botón Limpiar
        OutlinedButton(
            onClick = { viewModel.processIntent(FormularioIntent.Limpiar) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpiar")
        }

        // Resultado
        if (state.resultado.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text(
                    text = state.resultado,
                    modifier = Modifier.padding(16.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}