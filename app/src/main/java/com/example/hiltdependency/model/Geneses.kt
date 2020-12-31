package com.example.hiltdependency.model

data class Geneses(
    val result: List<Genres>
){
    data class Genres(
        val id: Int,
        val name: String
    )
}