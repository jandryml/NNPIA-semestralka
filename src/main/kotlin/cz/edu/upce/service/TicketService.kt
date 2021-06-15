package cz.edu.upce.service

import cz.edu.upce.model.Ticket
import cz.edu.upce.repository.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TicketService : ITicketService {

    @Autowired
    lateinit var ticketRepository: TicketRepository

    override fun getAll(paging: Pageable): Page<Ticket> {
        return ticketRepository.findAll(paging)
    }

    override fun getById(id: Long): Ticket {
        return ticketRepository.getOne(id)
    }

    override fun getByUserId(userId: Long, paging: Pageable): Page<Ticket> {
        return ticketRepository.findByUserId(userId, paging)
    }

    override fun save(ticket: Ticket): Ticket {
        return ticketRepository.save(ticket)
    }

    override fun removeById(ticketId: Long) {
        return ticketRepository.deleteById(ticketId)
    }
}