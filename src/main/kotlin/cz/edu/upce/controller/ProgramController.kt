package cz.edu.upce.controller

import cz.edu.upce.dto.ProgramDto
import cz.edu.upce.service.IProgramService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RestController
@RequestMapping("/api/program")
class ProgramController {

    @Autowired
    lateinit var programService: IProgramService

    @GetMapping
    fun getAll(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): Page<ProgramDto> {
        return programService.getAll(PageRequest.of(page, size)).map { it.toDto() }
    }

    @GetMapping(params = ["hallId"])
    fun getAllByHallId(
        @RequestParam hallId: Long,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): Page<ProgramDto> {
        return programService.getByCinemaId(hallId, PageRequest.of(page, size)).map { it.toDto() }
    }

    @GetMapping(params = ["filmId"])
    fun getAllByFilmId(
        @RequestParam filmId: Long,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): Page<ProgramDto> {
        return programService.getByFilmId(filmId, PageRequest.of(page, size)).map { it.toDto() }
    }

    @GetMapping(params = ["date"])
    fun getAllByDate(
        @RequestParam date: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): Page<ProgramDto> {
        val localDate =  LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        return programService.getForDay(localDate, PageRequest.of(page, size)).map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ProgramDto {
        return programService.getById(id).toDto()
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    fun save(@RequestBody programDto: ProgramDto): ProgramDto {
        return programService.save(programDto.toModel()).toDto()
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    fun delete(@PathVariable id: Long) {
        return programService.removeById(id)
    }
}