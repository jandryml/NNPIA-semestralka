package cz.edu.upce.controller

import cz.edu.upce.dto.HallDto
import cz.edu.upce.service.IHallService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hall")
class HallController {

    @Autowired
    lateinit var hallService: IHallService

    @GetMapping
    fun getAll(): List<HallDto> {
        return hallService.getAll().map { it.toDto() }
    }

    @GetMapping(params = ["cinemaId"])
    fun getAllByCinemaId(@RequestParam cinemaId: Long): List<HallDto> {
        return hallService.getByCinemaId(cinemaId).map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): HallDto {
        return hallService.getById(id).toDto()
    }

    @PostMapping
    fun save(@RequestBody hallDto: HallDto): HallDto {
        return hallService.save(hallDto.toModel()).toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return hallService.removeById(id)
    }
}