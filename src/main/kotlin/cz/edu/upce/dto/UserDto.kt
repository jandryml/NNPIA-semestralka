package cz.edu.upce.dto

import cz.edu.upce.model.Role
import cz.edu.upce.model.RoleType
import cz.edu.upce.model.User

class UserDto(
    var id: Long,
    var username: String,
    var email: String,
    val roles: List<String>
) {
    fun toModel() = User(id, username, email, roles = transferRoles())

    private fun transferRoles() = roles.map { Role(roleType = RoleType.valueOf(it)) }.toSet()
}