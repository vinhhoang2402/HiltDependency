package com.example.hiltdependency.model

data class Genress(
    val genres: List<Genres>
){
    data class Genres(
        val id: Int,
        val name: String
    )
}