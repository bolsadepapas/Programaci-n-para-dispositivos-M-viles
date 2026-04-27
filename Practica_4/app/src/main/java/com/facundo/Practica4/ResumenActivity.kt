/*
 * Descripción: Actividad 2 - Muestra el resumen del perfil y permite confirmar o volver a editar.
 * Autor: Facundo
 * Fecha creación: 22/04/2026
 * Fecha última modificación: 22/04/2026
 */

package com.facundo.Practica4

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val tvResumen    = findViewById<TextView>(R.id.tvResumen)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)
        val btnVolver    = findViewById<Button>(R.id.btnVolver)

        val usuario = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("usuario", Usuario::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("usuario") as? Usuario
        }

        usuario?.let { u ->
            tvResumen.text = getString(R.string.resumen_completo, u.nombre, u.edad, u.ciudad, u.correo)
        }

        // Confirmar: devuelve RESULT_OK a FormularioActivity
        btnConfirmar.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        // Volver a editar: cierra sin enviar resultado
        btnVolver.setOnClickListener {
            finish()
        }
    }
}