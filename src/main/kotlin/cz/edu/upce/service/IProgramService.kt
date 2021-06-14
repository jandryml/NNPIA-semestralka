package cz.edu.upce.service

import cz.edu.upce.model.Program
import java.time.LocalDate

interface IProgramService {
    fun getAll(): List<Program>
    fun getById(id: Long): Program
    fun getByCinemaId(hallId: Long): List<Program>
    fun getByFilmId(filmId: Long): List<Program>
    fun getForDay(date: LocalDate): List<Program>
    fun save(program: Program): Program
    fun removeById(programId: Long)
}