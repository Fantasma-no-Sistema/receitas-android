package com.fantasma.receitas.domain

class Receita(
    val id: String,
    val titulo: String,
    val favorite: Boolean = false,
    val imgUri: String
)
