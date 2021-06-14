package cz.edu.upce.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "cinema")
class Cinema(
    var name: String = "",
    var address: String = "",
    var telephone: String = "",
    var email: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}