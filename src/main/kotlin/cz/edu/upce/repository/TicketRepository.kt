package cz.edu.upce.repository

import cz.edu.upce.model.Ticket
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TicketRepository: JpaRepository<Ticket, Long> {
    fun findByUserId(userId: Long, paging: Pageable): Page<Ticket>
}