package cz.edu.upce.model

import cz.edu.upce.dto.FilmDto
import javax.persistence.*

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
    fun toDto(): FilmDto {
        return FilmDto(
            this.id,
            this.name,
            this.description,
            this.durationMinute,
            this.language
        )
    }
}