package kr.co.commerce.memberapi.mapper

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import kr.co.commerce.memberapi.domain.Member
import kr.co.commerce.memberapi.dto.members.MemberRequest
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberMapperTest(
  private val memberMapper: MemberMapper
) : BehaviorSpec({
  given("MemberEntity를 MemberResponse로 변환 검증"){
    val member = Member(
      name = "test",
      email = "test@test.com",
      password = "test"
    )

    When("Entity를 Response로 변환") {
      val response = memberMapper.toCopyResponse(member)

      then("response 검증") {
        member.uuid shouldBe response.uuid
        member.name shouldBe response.name
        member.email shouldBe response.email
      }
    }
  }

  given("MemberRequest를 MemberEntity로 변환 검증"){
    val request = MemberRequest(
      name = "test",
      email = "test@test.com",
      password = "password"
    )

    When("Entity를 Response로 변환") {
      val member = memberMapper.toCopyEntity(request)

      then("response 검증") {
        member.name shouldBe request.name
        member.email shouldBe request.email
        member.password shouldBe request.password
        member.uuid.shouldNotBeNull()
      }
    }
  }
})
