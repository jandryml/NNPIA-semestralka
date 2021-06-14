package cz.edu.upce.controller

import cz.edu.upce.dto.CinemaDto
import cz.edu.upce.service.ICinemaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cinema")
class CinemaController {

    @Autowired
    lateinit var cinemaService: ICinemaService

    @GetMapping
    fun getAll(): List<CinemaDto> {
        val allCinemas = cinemaService.getAll()
        return allCinemas.map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: String): CinemaDto {
        return cinemaService.getById(id.toLong()).toDto()
    }

    @PostMapping
    fun save(@RequestBody cinemaDto: CinemaDto): CinemaDto {
        val addedCinema = cinemaService.save(cinemaDto.toModel())
        return addedCinema.toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        return cinemaService.removeById(id.toLong())
    }

}