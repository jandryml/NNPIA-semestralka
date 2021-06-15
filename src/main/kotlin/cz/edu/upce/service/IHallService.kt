package cz.edu.upce.service

import cz.edu.upce.model.Hall
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IHallService {
    fun getAll(paging: Pageable): Page<Hall>
    fun getById(id: Long): Hall
    fun getByCinemaId(cinemaId: Long, paging: Pageable): Page<Hall>
    fun save(hall: Hall): Hall
    fun removeById(hallId: Long)
}