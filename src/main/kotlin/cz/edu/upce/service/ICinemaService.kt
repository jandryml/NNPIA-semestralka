package cz.edu.upce.service

import cz.edu.upce.model.Cinema
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ICinemaService {
    fun getAll(paging: Pageable): Page<Cinema>
    fun getById(id: Long): Cinema
    fun save(cinema: Cinema): Cinema
    fun removeById(cinemaId: Long)
}