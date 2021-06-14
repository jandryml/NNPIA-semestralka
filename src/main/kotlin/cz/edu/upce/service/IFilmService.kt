package cz.edu.upce.service

import cz.edu.upce.model.Film

interface IFilmService {
    fun getAll(): List<Film>
    fun getById(id: Long): Film
    fun add(film: Film): Film
    fun removeById(filmId: Long)
}