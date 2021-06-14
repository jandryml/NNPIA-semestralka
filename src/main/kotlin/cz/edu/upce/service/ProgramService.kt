package cz.edu.upce.service

import cz.edu.upce.model.Program
import cz.edu.upce.repository.ProgramRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class ProgramService : IProgramService {

    @Autowired
    lateinit var programRepository: ProgramRepository

    override fun getAll(): List<Program> {
        return programRepository.findAll()
    }

    override fun getById(id: Long): Program {
        return programRepository.getOne(id)
    }

    override fun getByCinemaId(hallId: Long): List<Program> {
        return programRepository.findByHallId(hallId)
    }

    override fun getByFilmId(filmId: Long): List<Program> {
        return programRepository.findByFilmId(filmId)
    }

    override fun getForDay(date: LocalDate): List<Program> {
        val dayStart = date.atStartOfDay()
        return getForDateInterval(dayStart, dayStart.plusHours(24))
    }

    private fun getForDateInterval(start: LocalDateTime, end: LocalDateTime): List<Program> {
        return programRepository.findByTimeStampBetween(start, end)
    }

    override fun save(program: Program): Program {
        return programRepository.save(program)
    }

    override fun removeById(programId: Long) {
        return programRepository.deleteById(programId)
    }
}