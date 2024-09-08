package kr.co.commerce.memberapi.api

import kr.co.commerce.common.jooq.generated.tables.pojos.Member
import kr.co.commerce.memberapi.application.MemberSearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/members")
class MemberController(
  private val memberSearchService: MemberSearchService
) {

  @GetMapping
  fun findLimit(page: Long, pageSize: Long) : List<Member> = memberSearchService.findLimit(page, pageSize)
}
