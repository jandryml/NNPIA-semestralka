package cz.edu.upce.repository

import cz.edu.upce.model.Program
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface ProgramRepository : JpaRepository<Program, Long> {
    fun findByHallId(cinemaId: Long): List<Program>
    fun findByFilmId(filmId: Long): List<Program>
    fun findByTimeStampBetween(start: LocalDateTime, end: LocalDateTime): List<Program>
}