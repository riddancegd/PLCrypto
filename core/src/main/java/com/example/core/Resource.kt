package com.example.core


//out T restricts the type to only be produced by the types, not consumed
sealed interface Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>
    data class Error(val message: String) : Resource<Nothing>
    data object Loading : Resource<Nothing>
}
