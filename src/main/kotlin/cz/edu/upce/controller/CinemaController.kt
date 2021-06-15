package cz.edu.upce.controller

import cz.edu.upce.dto.CinemaDto
import cz.edu.upce.service.ICinemaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cinema")
class CinemaController {

    @Autowired
    lateinit var cinemaService: ICinemaService

    @GetMapping
    fun getAll(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): Page<CinemaDto> {
        return cinemaService.getAll(PageRequest.of(page, size)).map { it.toDto() }
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