package cz.edu.upce.service

import cz.edu.upce.Creator
import cz.edu.upce.model.Cinema
import cz.edu.upce.model.Hall
import cz.edu.upce.repository.CinemaRepository
import cz.edu.upce.repository.HallRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.domain.Pageable
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
@ComponentScan
@ExperimentalStdlibApi
class HallServiceTest
@Autowired constructor(
    private val creator: Creator,
    private val hallService: HallService,
    private val cinemaService: CinemaService,
    private val hallRepository: HallRepository,
    private val cinemaRepository: CinemaRepository
) {

    @BeforeEach
    fun clean() {
        hallRepository.deleteAll()
        cinemaRepository.deleteAll()
    }

    @AfterEach
    fun cleanUp() {
        hallRepository.deleteAll()
        cinemaRepository.deleteAll()
    }

    @Test
    fun addHall() {
        val cinema = Cinema(name = "New cinema")
        val hall = Hall(name = "New hall", cinema = cinema)

        creator.save(hall)

        val halls = hallService.getAll(Pageable.unpaged())
        Assertions.assertEquals(1, halls.size)
        assertNotNull(halls.firstOrNull { it.name == hall.name && it.cinema!!.id == hall.cinema!!.id })
    }

    @Test
    fun searchByCinemaId() {
        val cinema1 = cinemaService.save(Cinema(name = "Cinema1"))
        val cinema2 = cinemaService.save(Cinema(name = "Cinema2"))

        val hall1 = hallService.save(Hall(name = "Hall1", cinema = cinema1))
        val hall2 = hallService.save(Hall(name = "Hall2", cinema = cinema2))
        val hall3 = hallService.save(Hall(name = "Hall3", cinema = cinema2))

        val halls = hallService.getByCinemaId(cinema2.id!!, Pageable.unpaged())

        Assertions.assertEquals(2, halls.size)
        assertNotNull(halls.firstOrNull { it.name == hall2.name && it.cinema!!.id == hall2.cinema!!.id })
        assertNotNull(halls.firstOrNull { it.name == hall3.name && it.cinema!!.id == hall3.cinema!!.id })
        assertNull(halls.firstOrNull { it.name == hall1.name && it.cinema!!.id == hall1.cinema!!.id })
    }
}