package cz.edu.upce.repository

import cz.edu.upce.model.Cinema
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CinemaRepository: JpaRepository<Cinema, Long>