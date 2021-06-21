package cz.edu.upce.service

import cz.edu.upce.model.Film
import cz.edu.upce.repository.FilmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FilmService : IFilmService {

    @Autowired
    lateinit var filmRepository: FilmRepository

    override fun getAll(paging: Pageable) = filmRepository.findAll(paging)

    override fun getById(id: Long) = filmRepository.getOne(id)

    override fun save(film: Film) = filmRepository.save(film)

    override fun removeById(filmId: Long) = filmRepository.deleteById(filmId)
}