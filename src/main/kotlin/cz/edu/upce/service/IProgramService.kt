package cz.edu.upce.service

import cz.edu.upce.model.Program
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.time.LocalDate

interface IProgramService {
    fun getAll(paging: Pageable): Page<Program>
    fun getById(id: Long): Program
    fun getByCinemaId(hallId: Long, paging: Pageable): Page<Program>
    fun getByFilmId(filmId: Long, paging: Pageable): Page<Program>
    fun getForDay(date: LocalDate, paging: Pageable): Page<Program>
    fun save(program: Program): Program
    fun removeById(programId: Long)
}