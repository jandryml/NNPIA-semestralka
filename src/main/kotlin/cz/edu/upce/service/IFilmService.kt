package cz.edu.upce.service

import cz.edu.upce.model.Film
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IFilmService {
    fun getAll(paging: Pageable): Page<Film>
    fun getById(id: Long): Film
    fun save(film: Film): Film
    fun removeById(filmId: Long)
}