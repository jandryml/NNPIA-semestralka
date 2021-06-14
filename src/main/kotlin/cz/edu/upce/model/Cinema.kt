package cz.edu.upce.model

import cz.edu.upce.dto.CinemaDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "cinema")
class Cinema(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var name: String = "",
    var address: String = "",
    var telephone: String = "",
    var email: String = ""
) {
    fun toDto(): CinemaDto {
        return CinemaDto(
            this.id,
            this.name,
            this.address,
            this.telephone,
            this.email
        )
    }
}