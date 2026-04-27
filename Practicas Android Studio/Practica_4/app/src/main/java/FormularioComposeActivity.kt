/*
 * Descripción: Actividad principal que aloja el formulario Compose con arquitectura MVI.
 * Autor: Facundo
 * Fecha creación: 26/04/2026
 * Fecha última modificación: 26/04/2026
 */

package com.facundo.Practica4.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

class FormularioComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    FormularioScreen()
                }
            }
        }
    }
}