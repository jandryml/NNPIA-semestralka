package cz.edu.upce.model

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


@Entity
@Table(
    name = "users",
    uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("username")), UniqueConstraint(columnNames = arrayOf("email"))]
)
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var username: @NotBlank @Size(max = 20) String = "",
    var email: @NotBlank @Size(max = 50) @Email String = "",
    var password: @NotBlank @Size(max = 120) String = "",

    //TODO recheck
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles")
    var roles: Set<Role> = HashSet()
)