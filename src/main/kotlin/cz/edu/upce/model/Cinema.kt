package cz.edu.upce.model

import cz.edu.upce.dto.CinemaDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "cinema")
class Cinema(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String = "",
    var address: String = "",
    var telephone: String = "",
    var email: String = ""
) {
    fun toDto() = CinemaDto(id, name, address, telephone, email)
}