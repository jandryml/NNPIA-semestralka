package cz.edu.upce.model

import cz.edu.upce.dto.FilmDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "film")
class Film(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var name: String = "",
    var description: String = "",
    var durationMinute: Int = 0,
    var language: String = ""
) {
    fun toDto(): FilmDto = FilmDto(
        id, name, description, durationMinute, language
    )
}