package cz.edu.upce.controller

import cz.edu.upce.dto.FilmDto
import cz.edu.upce.service.IFilmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/film")
class FilmController {
    @Autowired
    lateinit var filmService: IFilmService

    @GetMapping
    fun getAll(): List<FilmDto> {
        return filmService.getAll().map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): FilmDto {
        return filmService.getById(id).toDto()
    }

    @PostMapping
    fun save(@RequestBody filmDto: FilmDto): FilmDto {
        return filmService.save(filmDto.toModel()).toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return filmService.removeById(id)
    }
}