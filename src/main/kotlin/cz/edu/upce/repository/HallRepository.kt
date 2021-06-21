package cz.edu.upce.repository

import cz.edu.upce.model.Hall
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface HallRepository : JpaRepository<Hall, Long> {
    fun findByCinemaId(@Param("cinemaId") cinemaId: Long, paging: Pageable): Page<Hall>
}