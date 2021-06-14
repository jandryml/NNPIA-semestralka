package cz.edu.upce.service

import cz.edu.upce.dto.FilmDto

interface IFilmService {
    fun getAll(): List<FilmDto>
    fun getById(id: Long): FilmDto
    fun add(filmDto: FilmDto): FilmDto
    fun removeById(filmId: Long)
}