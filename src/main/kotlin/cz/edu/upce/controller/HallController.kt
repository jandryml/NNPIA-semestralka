package cz.edu.upce.controller

import cz.edu.upce.dto.HallDto
import cz.edu.upce.service.IHallService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hall")
class HallController {

    @Autowired
    lateinit var hallService: IHallService

    @GetMapping
    fun getAll(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): Page<HallDto> {
        return hallService.getAll(PageRequest.of(page, size)).map { it.toDto() }
    }

    @GetMapping(params = ["cinemaId"])
    fun getAllByCinemaId(
        @RequestParam cinemaId: Long,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): Page<HallDto> {
        return hallService.getByCinemaId(cinemaId, PageRequest.of(page, size)).map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): HallDto {
        return hallService.getById(id).toDto()
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    fun save(@RequestBody hallDto: HallDto): HallDto {
        return hallService.save(hallDto.toModel()).toDto()
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    fun delete(@PathVariable id: Long) {
        return hallService.removeById(id)
    }
}