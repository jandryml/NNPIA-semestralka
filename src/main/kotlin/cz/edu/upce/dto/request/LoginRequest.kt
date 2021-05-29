package cz.edu.upce.dto.request

import javax.validation.constraints.NotBlank


class LoginRequest(
    var username: @NotBlank String = "",
    var password: @NotBlank String = ""
)