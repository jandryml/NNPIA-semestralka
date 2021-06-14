package cz.edu.upce.model

import cz.edu.upce.dto.TicketDto
import javax.persistence.*

@Entity(name = "ticket")
class Ticket(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    val user: User? = null,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "program_id")
    val program: Program? = null
) {
    fun toDto(): TicketDto = TicketDto(
        id, user?.toDto(), program?.toDto()
    )
}