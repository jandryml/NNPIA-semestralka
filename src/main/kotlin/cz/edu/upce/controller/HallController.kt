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
        val allHalls = hallService.getAll()
        return allHalls.map { it.toDto() }
    }

    @GetMapping(params = ["cinemaId"])
    fun getAllByCinemaId(@RequestParam cinemaId: String): List<HallDto> {
        return hallService.getByCinemaId(cinemaId.toLong()).map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: String): HallDto {
        return hallService.getById(id.toLong()).toDto()
    }

    @PostMapping
    fun save(@RequestBody hallDto: HallDto): HallDto {
        val addedHall = hallService.save(hallDto.toModel())
        return addedHall.toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        return hallService.removeById(id.toLong())
    }
}