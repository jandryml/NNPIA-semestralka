package cz.edu.upce

import cz.edu.upce.model.Cinema
import cz.edu.upce.model.Film
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
@ComponentScan
@ExperimentalStdlibApi
class MockMvcTest
@Autowired constructor(
    private val mockMvc: MockMvc,
    private val creator: Creator
) {

    @Test
    fun filmGetAll() {
        val film1 = Film(name = "Film1")
        val film2 = Film(name = "Film2")
        creator.save(film1)
        creator.save(film2)

        this.mockMvc.perform(
            get("/api/film")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    fun cinemaDetailAll() {
        val cinema1 = creator.save(Cinema(name = "Cinema1")) as Cinema
        val cinema2 = creator.save(Cinema(name = "Cinema2")) as Cinema

        this.mockMvc.perform(
            get("/api/cinema/${cinema1.id}")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }

}