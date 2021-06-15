package cz.edu.upce.service

import cz.edu.upce.model.Ticket
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ITicketService {
    fun getAll(paging: Pageable): Page<Ticket>
    fun getById(id: Long): Ticket
    fun getByUserId(userId: Long, paging: Pageable): Page<Ticket>
    fun save(ticket: Ticket): Ticket
    fun removeById(ticketId: Long)
}