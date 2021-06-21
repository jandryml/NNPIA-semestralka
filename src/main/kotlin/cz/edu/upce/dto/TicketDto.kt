package cz.edu.upce.dto

import cz.edu.upce.model.Ticket

class TicketDto(
    var id: Long?,
    var user: UserDto?,
    var program: ProgramDto?,
    var isUsed: Boolean
) {
    fun toModel() = Ticket(id, user?.toModel(), program?.toModel(), isUsed)
}