package cz.edu.upce.service

import cz.edu.upce.Creator
import cz.edu.upce.model.Cinema
import cz.edu.upce.model.Film
import cz.edu.upce.model.Hall
import cz.edu.upce.model.Program
import cz.edu.upce.repository.CinemaRepository
import cz.edu.upce.repository.FilmRepository
import cz.edu.upce.repository.HallRepository
import cz.edu.upce.repository.ProgramRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.domain.Pageable
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDateTime

@SpringBootTest
@ActiveProfiles("test")
@ComponentScan
@ExperimentalStdlibApi
class ProgramServiceTest
@Autowired constructor(
    private val creator: Creator,
    private val programService: ProgramService,
    private val cinemaService: CinemaService,
    private val hallService: HallService,
    private val filmService: FilmService,
    private val programRepository: ProgramRepository,
    private val cinemaRepository: CinemaRepository,
    private val hallRepository: HallRepository,
    private val filmRepository: FilmRepository
) {

    @BeforeEach
    fun clean() {
        programRepository.deleteAll()
        filmRepository.deleteAll()
        hallRepository.deleteAll()
        cinemaRepository.deleteAll()
    }

    @Test
    fun addProgram() {
        val cinema = cinemaService.save(Cinema(name = "New cinema"))
        val hall = hallService.save(Hall(name = "New hall", cinema = cinema))
        val film = filmService.save(Film(name = "Pan prstenu"))
        val program = Program(hall = hall, film = film, timeStamp = LocalDateTime.now())

        programService.save(program)

        val programs = programRepository.findAll(Pageable.unpaged())
        Assertions.assertEquals(1, programs.size)
        assertNotNull(programs.firstOrNull { it.film!!.id == film.id!! && it.hall!!.id == hall.id!! })
    }

    @Test
    fun searchByCinemaId() {
        val cinema = Cinema(name = "New cinema")
        val hall = Hall(name = "New hall", cinema = cinema)
        val film1 = Film(name = "Pan prstenu")
        val film2 = Film(name = "Pan prstenus")
        val program1 = Program(hall = hall, film = film1, timeStamp = LocalDateTime.now())
        val program2 = Program(hall = hall, film = film2, timeStamp = LocalDateTime.now())

        creator.save(program1)
        creator.save(program2)

        val programs = programRepository.findByFilmId(film1.id!!, Pageable.unpaged())

        Assertions.assertEquals(1, programs.size)
        assertNotNull(programs.firstOrNull { it.film!!.id == film1.id!! && it.hall!!.id == hall.id!! })
    }
}