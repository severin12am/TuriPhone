package com.turi.languagelearning.core.util

/**
 * A generic wrapper for handling success and error states
 */
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

/**
 * Extension functions for Result
 */
inline fun <T> Result<T>.onSuccess(action: (value: T) -> Unit): Result<T> {
    if (this is Result.Success) action(data)
    return this
}

inline fun <T> Result<T>.onError(action: (exception: Throwable) -> Unit): Result<T> {
    if (this is Result.Error) action(exception)
    return this
}

inline fun <T> Result<T>.onLoading(action: () -> Unit): Result<T> {
    if (this is Result.Loading) action()
    return this
}

/**
 * Maps the success value to another type
 */
inline fun <T, R> Result<T>.map(transform: (value: T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> Result.Success(transform(data))
        is Result.Error -> Result.Error(exception)
        is Result.Loading -> Result.Loading
    }
}

/**
 * Returns the data if success, null otherwise
 */
fun <T> Result<T>.getOrNull(): T? {
    return if (this is Result.Success) data else null
}

/**
 * Returns the data if success, default value otherwise
 */
fun <T> Result<T>.getOrDefault(defaultValue: T): T {
    return if (this is Result.Success) data else defaultValue
}