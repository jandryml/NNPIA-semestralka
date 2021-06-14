package cz.edu.upce.service

import cz.edu.upce.model.Ticket
import cz.edu.upce.repository.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TicketService : ITicketService {

    @Autowired
    lateinit var ticketRepository: TicketRepository

    override fun getAll(): List<Ticket> {
        return ticketRepository.findAll()
    }

    override fun getById(id: Long): Ticket {
        return ticketRepository.getOne(id)
    }

    override fun getByUserId(userId: Long): List<Ticket> {
        return ticketRepository.findByUserId(userId)
    }

    override fun save(ticket: Ticket): Ticket {
        return ticketRepository.save(ticket)
    }

    override fun removeById(ticketId: Long) {
        return ticketRepository.deleteById(ticketId)
    }
}