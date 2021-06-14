package cz.edu.upce.controller

import cz.edu.upce.dto.FilmDto
import cz.edu.upce.service.FilmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/film")
class FilmController {
    @Autowired
    lateinit var filmService: FilmService

    @GetMapping
    fun getAll(): List<FilmDto> {
        return filmService.getAll()
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: String): FilmDto {
        return filmService.getById(id.toLong())
    }

    @PostMapping
    fun add(@RequestBody filmDto: FilmDto): FilmDto {
        return filmService.add(filmDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        return filmService.removeById(id.toLong())
    }
}