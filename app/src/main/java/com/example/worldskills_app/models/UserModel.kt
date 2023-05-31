package com.example.worldskills_app.models

data class User(
    val firstname: String = "",
    val lastname: String = "",
    val middlename: String = "",
    val bith: String = "",
    val pol: String = "",
    val image: String = "",
){
    fun getUserForParameters():Map<String, List<String>>{
        return mapOf(
            "firstname" to listOf(firstname),
            "lastname" to listOf(lastname),
            "middlename" to listOf(middlename),
            "bith" to listOf(bith),
            "pol" to listOf(pol),
            "image" to listOf(image),
        )
    }
}