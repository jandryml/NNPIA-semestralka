package cz.edu.upce.model

import javax.persistence.*
@Entity(name = "hall")
class Hall(
    var name: String = "",
    var capacity: Int = 0,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinema_id")
    val cinema: Cinema? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}