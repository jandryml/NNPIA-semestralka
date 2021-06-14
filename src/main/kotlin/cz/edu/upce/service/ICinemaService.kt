package cz.edu.upce.service

import cz.edu.upce.model.Cinema

interface ICinemaService {
    fun getAll(): List<Cinema>
    fun getById(id: Long): Cinema
    fun save(cinema: Cinema): Cinema
    fun removeById(cinemaId: Long)
}