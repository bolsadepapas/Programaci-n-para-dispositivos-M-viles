/*
 * Descripción: Pantalla de formulario para agregar un nuevo contacto.
 * Autor: Facundo
 * Fecha creación: 01/05/2026
 * Fecha última modificación: 01/05/2026
 */

package com.facundo.practica6

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioScreen(
    onGuardar: (String, String) -> Unit,
    onCancelar: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var errorNombre by remember { mutableStateOf("") }
    var errorTelefono by remember { mutableStateOf("") }

    val formularioValido = nombre.isNotBlank() && telefono.isNotBlank()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nuevo Contacto") },
                navigationIcon = {
                    IconButton(onClick = onCancelar) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Datos del contacto", fontSize = 18.sp, fontWeight = FontWeight.Bold)

            OutlinedTextField(
                value = nombre,
                onValueChange = {
                    nombre = it
                    errorNombre = if (it.isBlank()) "El nombre es obligatorio" else ""
                },
                label = { Text("Nombre") },
                supportingText = { Text(errorNombre, color = MaterialTheme.colorScheme.error) },
                isError = errorNombre.isNotEmpty(),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = {
                    telefono = it
                    errorTelefono = if (it.isBlank()) "El teléfono es obligatorio" else ""
                },
                label = { Text("Teléfono") },
                supportingText = { Text(errorTelefono, color = MaterialTheme.colorScheme.error) },
                isError = errorTelefono.isNotEmpty(),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { onGuardar(nombre, telefono) },
                enabled = formularioValido,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }

            OutlinedButton(
                onClick = onCancelar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancelar")
            }
        }
    }
}