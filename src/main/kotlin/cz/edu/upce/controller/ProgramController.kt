package cz.edu.upce.controller

import cz.edu.upce.dto.ProgramDto
import cz.edu.upce.service.IProgramService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/api/program")
class ProgramController {

    @Autowired
    lateinit var programService: IProgramService

    @GetMapping
    fun getAll(): List<ProgramDto> {
        val allPrograms = programService.getAll()
        return allPrograms.map { it.toDto() }
    }

    @GetMapping(params = ["hallId"])
    fun getAllByHallId(@RequestParam hallId: String): List<ProgramDto> {
        return programService.getByCinemaId(hallId.toLong()).map { it.toDto() }
    }

    @GetMapping(params = ["filmId"])
    fun getAllByFilmId(@RequestParam filmId: String): List<ProgramDto> {
        return programService.getByFilmId(filmId.toLong()).map { it.toDto() }
    }

    @GetMapping(params = ["date"])
    fun getAllByDate(@RequestParam date: String): List<ProgramDto> {
        // TODO change to use real param
        return programService.getForDay(LocalDate.now()).map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: String): ProgramDto {
        return programService.getById(id.toLong()).toDto()
    }

    @PostMapping
    fun save(@RequestBody programDto: ProgramDto): ProgramDto {
        val addedProgram = programService.save(programDto.toModel())
        return addedProgram.toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        return programService.removeById(id.toLong())
    }
}