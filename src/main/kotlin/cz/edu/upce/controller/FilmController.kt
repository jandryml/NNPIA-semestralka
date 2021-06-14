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
        val allFilms = filmService.getAll()
        return allFilms.map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: String): FilmDto {
        return filmService.getById(id.toLong()).toDto()
    }

    @PostMapping
    fun save(@RequestBody filmDto: FilmDto): FilmDto {
        val addedFilm = filmService.save(filmDto.toModel())
        return addedFilm.toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        return filmService.removeById(id.toLong())
    }
}