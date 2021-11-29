package com.fantasma.receitas.presentation.listarReceitas

import androidx.lifecycle.ViewModel
import com.fantasma.receitas.domain.Receita

class ListaReceitasViewModel: ViewModel() {

    private val list: ArrayList<Receita> = arrayListOf(
        Receita(0, "Feijao", false, )
    )
}