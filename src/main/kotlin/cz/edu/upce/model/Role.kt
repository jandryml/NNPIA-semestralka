package cz.edu.upce.model

import javax.persistence.*

@Entity(name = "roles")
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    var roleType: RoleType = RoleType.ROLE_USER
)