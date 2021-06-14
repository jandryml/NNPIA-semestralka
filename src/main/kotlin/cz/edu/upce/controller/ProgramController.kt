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
        return programService.getAll().map { it.toDto() }
    }

    @GetMapping(params = ["hallId"])
    fun getAllByHallId(@RequestParam hallId: Long): List<ProgramDto> {
        return programService.getByCinemaId(hallId).map { it.toDto() }
    }

    @GetMapping(params = ["filmId"])
    fun getAllByFilmId(@RequestParam filmId: Long): List<ProgramDto> {
        return programService.getByFilmId(filmId).map { it.toDto() }
    }

    @GetMapping(params = ["date"])
    fun getAllByDate(@RequestParam date: String): List<ProgramDto> {
        // TODO change to use real param
        return programService.getForDay(LocalDate.now()).map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ProgramDto {
        return programService.getById(id).toDto()
    }

    @PostMapping
    fun save(@RequestBody programDto: ProgramDto): ProgramDto {
        return programService.save(programDto.toModel()).toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return programService.removeById(id)
    }
}