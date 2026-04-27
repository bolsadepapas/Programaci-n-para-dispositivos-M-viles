/*
 * Descripción: Actividad 1 - Formulario para llenar datos del perfil de usuario.
 * Autor: Facundo
 * Fecha creación: 22/04/2026
 * Fecha última modificación: 22/04/2026
 */

package com.facundo.Practica4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText

    // registerForActivityResult para recibir resultado de ResumenActivity
    private val lanzarResumen = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            Toast.makeText(this, getString(R.string.perfil_guardado), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        etNombre = findViewById(R.id.etNombre)
        etEdad   = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)

        // Restaurar datos si se giró la pantalla
        savedInstanceState?.let {
            etNombre.setText(it.getString("nombre", ""))
            etEdad.setText(it.getString("edad", ""))
            etCiudad.setText(it.getString("ciudad", ""))
            etCorreo.setText(it.getString("correo", ""))
        }

        val btnContinuar = findViewById<Button>(R.id.btnContinuar)

        btnContinuar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val edadStr = etEdad.text.toString()
            val ciudad = etCiudad.text.toString()
            val correo = etCorreo.text.toString()

            // Validación
            if (nombre.isBlank() || edadStr.isBlank() || ciudad.isBlank() || correo.isBlank()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = Usuario(
                nombre = nombre,
                edad = edadStr.toInt(),
                ciudad = ciudad,
                correo = correo
            )

            val intent = Intent(this, ResumenActivity::class.java)
            intent.putExtra("usuario", usuario)
            lanzarResumen.launch(intent)
        }
    }

    // Guardar datos al girar la pantalla
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre", etNombre.text.toString())
        outState.putString("edad", etEdad.text.toString())
        outState.putString("ciudad", etCiudad.text.toString())
        outState.putString("correo", etCorreo.text.toString())
    }
}