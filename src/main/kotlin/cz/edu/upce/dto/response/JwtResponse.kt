package cz.edu.upce.dto.response


class JwtResponse(
    var id: Long,
    var username: String,
    var email: String,
    val roles: List<String>,
    var accessToken: String,
    var tokenType: String = "Bearer"
)