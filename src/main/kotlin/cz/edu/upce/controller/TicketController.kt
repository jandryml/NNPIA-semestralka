package cz.edu.upce.controller

import cz.edu.upce.dto.TicketDto
import cz.edu.upce.service.ITicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ticket")
class TicketController {

    @Autowired
    lateinit var ticketService: ITicketService

    @GetMapping
    fun getAll(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): Page<TicketDto> {
        return ticketService.getAll(PageRequest.of(page, size)).map { it.toDto() }
    }

    @GetMapping(params = ["userId"])
    fun getAllByUserId(
        @RequestParam userId: Long,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): Page<TicketDto> {
        return ticketService.getByUserId(userId, PageRequest.of(page, size)).map { it.toDto() }
    }

    @GetMapping(params = ["programId"])
    fun getAllByProgramId(
        @RequestParam programId: Long,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): Page<TicketDto> {
        return ticketService.getByProgramId(programId, PageRequest.of(page, size)).map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): TicketDto {
        return ticketService.getById(id).toDto()
    }

    @PostMapping
    fun save(@RequestBody ticketDto: TicketDto): TicketDto {
        return ticketService.save(ticketDto.toModel()).toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return ticketService.removeById(id)
    }
}