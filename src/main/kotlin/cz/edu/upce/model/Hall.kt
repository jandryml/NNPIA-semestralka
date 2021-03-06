package cz.edu.upce.model

import cz.edu.upce.dto.HallDto
import javax.persistence.*

@Entity(name = "hall")
class Hall(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String = "",
    var capacity: Int = 0,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinema_id")
    val cinema: Cinema? = null
) {
    fun toDto() = HallDto(id, name, capacity, cinema?.toDto())
}