package com.example.pupps.data

data class score(val value : Int){
    var status = getStatus(value)

    private fun getStatus(value : Int){
        when(value){
            in 0..30 -> "low"
            in 31..60 -> "moderate"
            in 61..10 -> "high"
        }
    }
}