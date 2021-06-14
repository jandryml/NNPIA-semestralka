package cz.edu.upce.service

import cz.edu.upce.dto.FilmDto
import cz.edu.upce.repository.FilmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FilmService: IFilmService {
    @Autowired
    lateinit var filmRepository: FilmRepository

    override fun getAll(): List<FilmDto> {
        return filmRepository.findAll().map { it.toDto() }
    }

    override fun getById(id: Long): FilmDto {
        return filmRepository.getOne(id).toDto()
    }

    override fun add(filmDto: FilmDto): FilmDto {
        return filmRepository.save(filmDto.transferToModel()).toDto()
    }

    override fun removeById(filmId: Long) {
        return filmRepository.deleteById(filmId)
    }

}