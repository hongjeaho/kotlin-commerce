package kr.co.commerce.memberapi.api
import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
class MemberControllerTest(
  private val context: WebApplicationContext
) : BehaviorSpec({
  val client = MockMvcBuilders.webAppContextSetup(context).build()

  given("전체 조회 API 테스트 ") {
    When("GET /api/members") {
        val result = client.perform(get("/api/members"))
          .andExpect(status().isOk)
      then("조회 건수 : 0") {
        result.andExpect(jsonPath("$").isEmpty)
      }
    }
  }
})
