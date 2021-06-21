package cz.edu.upce.dto

import cz.edu.upce.model.Cinema

class CinemaDto(
    var id: Long?,
    var name: String?,
    var address: String?,
    var telephone: String?,
    var email: String?
) {
    fun toModel() = Cinema(id, name ?: "", address ?: "", telephone ?: "", email ?: "")
}