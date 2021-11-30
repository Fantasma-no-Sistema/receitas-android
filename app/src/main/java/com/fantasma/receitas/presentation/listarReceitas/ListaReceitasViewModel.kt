package com.fantasma.receitas.presentation.listarReceitas

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fantasma.receitas.domain.Receita
import com.fantasma.receitas.domain.listaReceitas.useCase.ListaReceitaUseCase
import com.fantasma.receitas.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class ListaReceitasViewModel: ViewModel() {

    private val mUseCase = ListaReceitaUseCase()

    fun listaReceitas(): LiveData<Result<ArrayList<Receita>>> {
        return runBlocking {
            withContext(Dispatchers.IO) {
                mUseCase.listaReceitas().onStart {
                    emit(Result.Loading)
                }
            }
        }.asLiveData(viewModelScope.coroutineContext)
    }
}