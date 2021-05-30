package com.piashcse.currencyconverter.utils.network

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
class Resource<out T>(val status: Status, val data: T?, val msg: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, null)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
