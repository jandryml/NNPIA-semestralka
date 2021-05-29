package cz.edu.upce.repository

import cz.edu.upce.model.Role
import cz.edu.upce.model.RoleType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    fun findByRoleType(name: RoleType): Optional<Role>
}