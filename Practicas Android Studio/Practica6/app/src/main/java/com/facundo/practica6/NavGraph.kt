/*
 * Descripción: Configuración de navegación entre pantallas con NavHost.
 * Autor: Facundo
 * Fecha creación: 01/05/2026
 * Fecha última modificación: 01/05/2026
 */

package com.facundo.practica6

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    var contactos by remember {
        mutableStateOf(
            listOf(
                Contacto(1, "Ana García", "987654321"),
                Contacto(2, "Carlos López", "912345678"),
                Contacto(3, "María Torres", "923456789"),
                Contacto(4, "Juan Pérez", "934567890")
            )
        )
    }

    NavHost(navController = navController, startDestination = "lista") {
        composable("lista") {
            ListaScreen(
                contactos = contactos,
                onToggleFavorito = { contacto ->
                    contactos = contactos.map {
                        if (it.id == contacto.id) it.copy(favorito = !it.favorito) else it
                    }
                },
                onEliminar = { contacto ->
                    contactos = contactos.filter { it.id != contacto.id }
                },
                onAgregarContacto = { navController.navigate("formulario") }
            )
        }
        composable("formulario") {
            FormularioScreen(
                onGuardar = { nombre, telefono ->
                    val nuevoId = (contactos.maxOfOrNull { it.id } ?: 0) + 1
                    contactos = contactos + Contacto(nuevoId, nombre, telefono)
                    navController.popBackStack()
                },
                onCancelar = { navController.popBackStack() }
            )
        }
    }
}