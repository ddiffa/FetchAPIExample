package dev.hellodiffa.fetchapiexampel.common

class ResultState<T>(val status : Status, val data : T?, val errorMessage : String?) {

    companion object{
        fun <T> success(data : T?) : ResultState<T> = ResultState(Status.SUCCESS, data, null)
        fun <T> error(message : String) : ResultState<T> = ResultState(Status.ERROR, null, message)
        fun <T> loading() : ResultState<T> = ResultState(Status.LOADING, null,null)
    }

    enum class Status{
        LOADING,
        SUCCESS,
        ERROR
    }
}