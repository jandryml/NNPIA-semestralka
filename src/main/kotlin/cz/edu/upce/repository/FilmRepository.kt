package cz.edu.upce.repository

import cz.edu.upce.model.Film
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FilmRepository: JpaRepository<Film, Long>