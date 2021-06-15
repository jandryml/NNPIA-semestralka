package cz.edu.upce.service

import cz.edu.upce.model.Cinema
import cz.edu.upce.repository.CinemaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CinemaService : ICinemaService {

    @Autowired
    lateinit var cinemaRepository: CinemaRepository

    override fun getAll(paging: Pageable): Page<Cinema> {
        return cinemaRepository.findAll(paging)
    }

    override fun getById(id: Long): Cinema {
        return cinemaRepository.getOne(id)
    }

    override fun save(cinema: Cinema): Cinema {
        return cinemaRepository.save(cinema)
    }

    override fun removeById(cinemaId: Long) {
        return cinemaRepository.deleteById(cinemaId)
    }
}