package com.facundo.Practica4.model

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val edad: Int,
    val ciudad: String,
    val correo: String
) : Serializable