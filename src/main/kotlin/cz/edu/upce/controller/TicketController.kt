package cz.edu.upce.controller

import cz.edu.upce.dto.TicketDto
import cz.edu.upce.service.ITicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ticket")
class TicketController {

    @Autowired
    lateinit var ticketService: ITicketService

    @GetMapping
    fun getAll(): List<TicketDto> {
        val allTickets = ticketService.getAll()
        return allTickets.map { it.toDto() }
    }

    @GetMapping(params = ["userId"])
    fun getAllByUserId(@RequestParam userId: String): List<TicketDto> {
        return ticketService.getByUserId(userId.toLong()).map { it.toDto() }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: String): TicketDto {
        return ticketService.getById(id.toLong()).toDto()
    }

    @PostMapping
    fun save(@RequestBody ticketDto: TicketDto): TicketDto {
        val addedTicket = ticketService.save(ticketDto.toModel())
        return addedTicket.toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        return ticketService.removeById(id.toLong())
    }
}