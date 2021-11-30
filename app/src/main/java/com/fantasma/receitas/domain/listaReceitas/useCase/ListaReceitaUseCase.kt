package com.fantasma.receitas.domain.listaReceitas.useCase

import com.fantasma.receitas.domain.Receita
import com.fantasma.receitas.utils.Result
import kotlinx.coroutines.flow.flow

class ListaReceitaUseCase {
    /**
     * Retorna uma lista de receitas
     */
    suspend fun listaReceitas() = flow {
        val list: ArrayList<Receita> = arrayListOf(
            Receita("0", "Feijao", true, "https://patriciahelu.com/wp-content/uploads/2019/09/feijao.jpg"),
            Receita("1", "Macarrão", false, "https://www.sabornamesa.com.br/media/k2/items/cache/665e96c29d55b13435d7a8d39deafe53_XL.jpg"),
            Receita("2", "Lasanha", true, "https://img.itdg.com.br/tdg/images/recipes/000/000/876/324587/324587_original.jpg"),
            Receita("3", "Costela Assada", false, "https://www.receiteria.com.br/wp-content/uploads/costela-assada-no-forno.jpg"),
            Receita("4", "Arroz", false, "https://vivareceita-cdn.s3.amazonaws.com/uploads/2020/11/Aprenda-como-fazer-um-arroz-dos-deuses.-Fonte-Pinterest.jpg")
        )

        if (list.isNullOrEmpty()) {
            emit(Result.Error("Lista está vazia"))
        }

        emit(Result.Success(list))

    }
}