package cz.edu.upce.service

import cz.edu.upce.model.Ticket

interface ITicketService {
    fun getAll(): List<Ticket>
    fun getById(id: Long): Ticket
    fun getByUserId(userId: Long): List<Ticket>
    fun save(ticket: Ticket): Ticket
    fun removeById(ticketId: Long)
}