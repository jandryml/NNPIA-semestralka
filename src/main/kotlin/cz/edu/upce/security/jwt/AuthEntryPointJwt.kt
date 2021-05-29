package cz.edu.upce.security.jwt

import org.slf4j.LoggerFactory
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class AuthEntryPointJwt : AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        logger.error("Unauthorized error: {}", authException.message)
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(AuthEntryPointJwt::class.java)
    }

    // custom response by Object mapper
//    @Throws(IOException::class, ServletException::class)
//    override fun commence(
//        request: HttpServletRequest,
//        response: HttpServletResponse,
//        authException: AuthenticationException
//    ) {
//        logger.error("Unauthorized error: {}", authException.message)
//        response.contentType = MediaType.APPLICATION_JSON_VALUE
//        response.status = HttpServletResponse.SC_UNAUTHORIZED
//        val body: MutableMap<String, Any?> = HashMap()
//        body["status"] = HttpServletResponse.SC_UNAUTHORIZED
//        body["error"] = "Unauthorized"
//        body["message"] = authException.message
//        body["path"] = request.servletPath
//        val mapper = ObjectMapper()
//        mapper.writeValue(response.outputStream, body)
//    }
}