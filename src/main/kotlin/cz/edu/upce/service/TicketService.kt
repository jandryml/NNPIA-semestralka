package cz.edu.upce.service

import cz.edu.upce.model.Ticket
import cz.edu.upce.repository.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TicketService : ITicketService {

    @Autowired
    lateinit var ticketRepository: TicketRepository

    override fun getAll(paging: Pageable) = ticketRepository.findAll(paging)

    override fun getById(id: Long) = ticketRepository.getOne(id)

    override fun getByUserId(userId: Long, paging: Pageable) = ticketRepository.findByUserId(userId, paging)

    override fun getByProgramId(programId: Long, paging: Pageable) = ticketRepository.findByProgramId(programId, paging)

    override fun save(ticket: Ticket) = ticketRepository.save(ticket)

    override fun removeById(ticketId: Long) = ticketRepository.deleteById(ticketId)
}