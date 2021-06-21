package cz.edu.upce.repository

import cz.edu.upce.model.Program
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface ProgramRepository : JpaRepository<Program, Long> {
    fun findByHallId(hallId: Long, paging: Pageable): Page<Program>
    fun findByFilmId(filmId: Long, paging: Pageable): Page<Program>
    fun findByTimeStampBetween(start: LocalDateTime, end: LocalDateTime, paging: Pageable): Page<Program>
}