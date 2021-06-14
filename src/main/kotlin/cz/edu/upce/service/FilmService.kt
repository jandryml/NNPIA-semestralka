package cz.edu.upce.service

import cz.edu.upce.model.Film
import cz.edu.upce.repository.FilmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FilmService : IFilmService {

    @Autowired
    lateinit var filmRepository: FilmRepository

    override fun getAll(): List<Film> {
        return filmRepository.findAll()
    }

    override fun getById(id: Long): Film {
        return filmRepository.getOne(id)
    }

    override fun save(film: Film): Film {
        return filmRepository.save(film)
    }

    override fun removeById(filmId: Long) {
        return filmRepository.deleteById(filmId)
    }
}