package cz.edu.upce.model

import cz.edu.upce.dto.ProgramDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity(name = "program")
class Program(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    @Column(columnDefinition = "TIMESTAMP") var timeStamp: LocalDateTime = LocalDateTime.now(),
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hall_id")
    val hall: Hall? = null,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id")
    val film: Film? = null
) {
    companion object {
        val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    }

    fun toDto(): ProgramDto = ProgramDto(
        id, timeStamp.format(dateTimeFormatter), hall?.toDto(), film?.toDto()
    )
}