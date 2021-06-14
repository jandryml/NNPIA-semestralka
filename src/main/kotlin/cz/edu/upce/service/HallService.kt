package cz.edu.upce.service

import cz.edu.upce.model.Hall
import cz.edu.upce.repository.HallRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HallService: IHallService {

    @Autowired
    lateinit var hallRepository: HallRepository

    override fun getAll(): List<Hall> {
        return hallRepository.findAll()
    }

    override fun getById(id: Long): Hall {
        return hallRepository.getOne(id)
    }

    override fun getByCinemaId(cinemaId: Long): List<Hall> {
       return hallRepository.findByCinemaId(cinemaId)
    }

    override fun save(hall: Hall): Hall {
        return hallRepository.save(hall)
    }

    override fun removeById(hallId: Long) {
        return hallRepository.deleteById(hallId)
    }
}