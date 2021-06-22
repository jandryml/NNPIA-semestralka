package cz.edu.upce.service

import cz.edu.upce.model.RoleType
import cz.edu.upce.model.Ticket
import cz.edu.upce.repository.TicketRepository
import cz.edu.upce.security.jwt.JwtUtils
import cz.edu.upce.security.service.UserDetailsImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class TicketService : ITicketService {

    @Autowired
    private lateinit var jwtUtils: JwtUtils

    @Autowired
    lateinit var ticketRepository: TicketRepository

    override fun getAll(paging: Pageable) = ticketRepository.findAll(paging)

    override fun getById(id: Long) = ticketRepository.getOne(id)

    override fun getByUserId(userId: Long, paging: Pageable) = ticketRepository.findByUserId(userId, paging)

    override fun getByProgramId(programId: Long, paging: Pageable) = ticketRepository.findByProgramId(programId, paging)

    override fun save(ticket: Ticket): Ticket {
        if((!jwtUtils.currentUserContainsRole(RoleType.ROLE_ADMIN) && !jwtUtils.currentUserContainsRole(RoleType.ROLE_MODERATOR))
            && jwtUtils.getUserId() != ticket.id){
            throw Exception("User without moderator or admin role can't assign ticket with id which is not his.")
        }
        return ticketRepository.save(ticket)
    }

    override fun removeById(ticketId: Long) {
        val ticket = getById(ticketId)
        if((!jwtUtils.currentUserContainsRole(RoleType.ROLE_ADMIN) && !jwtUtils.currentUserContainsRole(RoleType.ROLE_MODERATOR))
            && jwtUtils.getUserId() != ticket.user!!.id){
            throw Exception("User without moderator or admin role can't delete ticket that is not his.")
        }
        ticketRepository.deleteById(ticketId)
    }
}