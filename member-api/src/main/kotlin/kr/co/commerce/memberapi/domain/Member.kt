package kr.co.commerce.memberapi.domain


import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import kr.co.commerce.common.core.utils.GeneratorUtils
import java.util.UUID

@Entity
@Table(name = "member")
class Member(
  name: String,
  email: String,
  password: String,
) : BaseEntity() {

  @Id
  val uuid: UUID = GeneratorUtils.generatorUUID()

  var name: String = name
  var email: String = email
  var password: String = password

}