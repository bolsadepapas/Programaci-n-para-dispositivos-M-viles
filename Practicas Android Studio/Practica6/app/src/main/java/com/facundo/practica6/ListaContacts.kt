/*
 * Descripción: Pantalla principal que muestra la lista de contactos con opciones
 *              de favorito y eliminación.
 * Autor: Facundo
 * Fecha creación: 01/05/2026
 * Fecha última modificación: 01/05/2026
 */

package com.facundo.practica6

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListaScreen(
    contactos: List<Contacto>,
    onToggleFavorito: (Contacto) -> Unit,
    onEliminar: (Contacto) -> Unit,
    onAgregarContacto: () -> Unit
) {
    val contactosOrdenados = contactos.sortedByDescending { it.favorito }

    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(
                title = { Text("Mis Contactos") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAgregarContacto) {
                Icon(Icons.Default.Add, contentDescription = "Agregar contacto")
            }
        }
    ) { padding ->
        if (contactosOrdenados.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("No hay contactos. ¡Agrega uno!", color = Color.Gray)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(contactosOrdenados, key = { it.id }) { contacto ->
                    ContactoItem(
                        contacto = contacto,
                        onToggleFavorito = onToggleFavorito,
                        onEliminar = onEliminar
                    )
                }
            }
        }
    }
}

@Composable
fun ContactoItem(
    contacto: Contacto,
    onToggleFavorito: (Contacto) -> Unit,
    onEliminar: (Contacto) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = contacto.nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = contacto.telefono,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            // Botón favorito
            IconButton(onClick = { onToggleFavorito(contacto) }) {
                Icon(
                    imageVector = if (contacto.favorito) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = "Favorito",
                    tint = if (contacto.favorito) Color(0xFFFFC107) else Color.Gray
                )
            }

            // Botón eliminar
            IconButton(onClick = { onEliminar(contacto) }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    tint = Color.Red
                )
            }
        }
    }
}