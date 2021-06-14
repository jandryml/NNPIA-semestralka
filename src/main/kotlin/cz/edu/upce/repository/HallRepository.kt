package cz.edu.upce.repository

import cz.edu.upce.model.Hall
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HallRepository : JpaRepository<Hall, Long> {
    fun findByCinemaId(cinemaId: Long): List<Hall>
}