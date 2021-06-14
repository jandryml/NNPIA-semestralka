package cz.edu.upce.service

import cz.edu.upce.model.Hall

interface IHallService {
    fun getAll(): List<Hall>
    fun getById(id: Long): Hall
    fun getByCinemaId(cinemaId: Long): List<Hall>
    fun save(hall: Hall): Hall
    fun removeById(hallId: Long)
}