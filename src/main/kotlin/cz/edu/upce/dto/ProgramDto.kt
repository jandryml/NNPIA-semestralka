package cz.edu.upce.dto

import cz.edu.upce.model.Program
import java.time.LocalDateTime

class ProgramDto(
    var id: Long?,
    var timestamp: String?,
    var hall: HallDto?,
    var film: FilmDto?
) {
    fun toModel(): Program {
        return Program(
            id,
            LocalDateTime.parse(timestamp, Program.dateTimeFormatter),
            hall?.toModel(),
            film?.toModel()
        )
    }
}