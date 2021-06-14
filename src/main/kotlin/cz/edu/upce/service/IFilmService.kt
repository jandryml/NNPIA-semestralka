package cz.edu.upce.service

import cz.edu.upce.model.Film

interface IFilmService {
    fun getAll(): List<Film>
    fun getById(id: Long): Film
    fun save(film: Film): Film
    fun removeById(filmId: Long)
}