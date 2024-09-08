package kr.co.commerce.memberapi.application
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberSearchServiceTest(
  private val memberSearchService: MemberSearchService
) : BehaviorSpec({
  given("email을 가지고 회원  정보를 조회 실패 테스트") {
    val email = "sample@example.com"
    When("findByEmail 실행") {
      then("IllegalArgumentException 확인") {
        shouldThrow<IllegalArgumentException> {
          memberSearchService.findByEmail(email)
        }
      }
    }
  }
})
