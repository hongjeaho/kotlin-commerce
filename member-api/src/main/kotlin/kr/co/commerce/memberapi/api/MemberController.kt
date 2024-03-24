package kr.co.commerce.memberapi.api

import kr.co.commerce.memberapi.application.MemberSearchService
import kr.co.commerce.memberapi.domain.Member
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/members")
class MemberController(
  private val memberSearchService: MemberSearchService
) {

  @GetMapping
  fun findAll() : List<Member> = memberSearchService.findAll()
}
