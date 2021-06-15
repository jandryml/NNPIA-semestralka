package cz.edu.upce.service

import cz.edu.upce.model.Program
import cz.edu.upce.repository.ProgramRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class ProgramService : IProgramService {

    @Autowired
    lateinit var programRepository: ProgramRepository

    override fun getAll(paging: Pageable): Page<Program> {
        return programRepository.findAll(paging)
    }

    override fun getById(id: Long): Program {
        return programRepository.getOne(id)
    }

    override fun getByCinemaId(hallId: Long, paging: Pageable): Page<Program> {
        return programRepository.findByHallId(hallId, paging)
    }

    override fun getByFilmId(filmId: Long, paging: Pageable): Page<Program> {
        return programRepository.findByFilmId(filmId, paging)
    }

    override fun getForDay(date: LocalDate, paging: Pageable): Page<Program> {
        val dayStart = date.atStartOfDay()
        return getForDateInterval(dayStart, dayStart.plusHours(24), paging)
    }

    private fun getForDateInterval(start: LocalDateTime, end: LocalDateTime, paging: Pageable): Page<Program> {
        return programRepository.findByTimeStampBetween(start, end, paging)
    }

    override fun save(program: Program): Program {
        return programRepository.save(program)
    }

    override fun removeById(programId: Long) {
        return programRepository.deleteById(programId)
    }
}