package cz.edu.upce.dto.auth

import javax.validation.constraints.NotBlank


class LoginRequest(
    var username: @NotBlank String = "",
    var password: @NotBlank String = ""
)