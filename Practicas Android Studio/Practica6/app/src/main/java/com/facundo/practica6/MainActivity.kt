/*
 * Descripción: Actividad principal que inicializa la navegación de la app.
 * Autor: Facundo
 * Fecha creación: 01/05/2026
 * Fecha última modificación: 01/05/2026
 */

package com.facundo.practica6

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.facundo.practica6.NavGraph
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.facundo.practica6.ui.theme.Practica6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica6Theme {
                Surface {
                    NavGraph()
                }
            }
        }
    }
}