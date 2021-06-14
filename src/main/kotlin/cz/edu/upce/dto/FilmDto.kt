package cz.edu.upce.dto

import cz.edu.upce.model.Film

data class FilmDto(
    var id: Long?,
    var name: String?,
    var description: String?,
    var durationMinute: Int?,
    var language: String?
) {
    fun toModel(): Film {
        return Film(
            id,
            name ?: "",
            description ?: "",
            durationMinute ?: 0,
            language ?: ""
        )
    }
}