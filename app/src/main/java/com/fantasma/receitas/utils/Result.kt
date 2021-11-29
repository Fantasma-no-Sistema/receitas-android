package com.fantasma.receitas.utils

sealed class Result<out R> {

    /**
     * Loading - Status do Result quando a requisição é inicializada
     */
    object Loading : Result<Nothing>()

    /**
     * Success - Status do Result quando o esperado é atingido
     * @param data - Resultado da requisição
     */
    data class Success<out T>(val data: T) : Result<T>()

    /**
     * Error - Status do Result quando a esperado não for atingido
     * @param error - Mensagem de erro
     */
    data class Error(val error: String) : Result<Nothing>()
}
