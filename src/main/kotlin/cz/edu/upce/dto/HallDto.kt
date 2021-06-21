package cz.edu.upce.dto

import cz.edu.upce.model.Hall

class HallDto(
    var id: Long?,
    var name: String?,
    var capacity: Int?,
    var cinema: CinemaDto?
) {
    fun toModel() = Hall(id, name ?: "", capacity ?: 0, cinema?.toModel())
}