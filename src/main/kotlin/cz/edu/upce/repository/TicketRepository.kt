package cz.edu.upce.repository

import cz.edu.upce.model.Ticket
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TicketRepository : JpaRepository<Ticket, Long> {
    @Query(value = "SELECT * FROM ticket t WHERE t.user_id = :userId", nativeQuery = true)
    fun findByUserId(userId: Long, paging: Pageable): Page<Ticket>
}