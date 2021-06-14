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
        return cinemaService.getAll().map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): CinemaDto {
        return cinemaService.getById(id).toDto()
    }

    @PostMapping
    fun save(@RequestBody cinemaDto: CinemaDto): CinemaDto {
        return cinemaService.save(cinemaDto.toModel()).toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return cinemaService.removeById(id)
    }
}