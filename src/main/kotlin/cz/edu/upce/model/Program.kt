package cz.edu.upce.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "program")
class Program(
    @Column(columnDefinition = "TIMESTAMP") var timeStamp: LocalDateTime = LocalDateTime.now(),
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hall_id")
    val hall: Hall? = null,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id")
    val film: Film? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}