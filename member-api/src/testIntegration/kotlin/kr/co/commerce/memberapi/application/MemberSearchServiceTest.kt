package kr.co.commerce.memberapi.application
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberSearchServiceTest(
  private val memberSearchService: MemberSearchService
) : BehaviorSpec({
  given("모든 회원 조회 테스트") {
    When("findAll 실행") {
      val members = memberSearchService.findAll()
      then("0명 회원 검증") {
        members.size shouldBe 0
      }
    }
  }
})
