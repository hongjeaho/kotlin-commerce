package kr.co.commerce.memberapi.application

import kr.co.commerce.common.jooq.generated.tables.pojos.Member
import kr.co.commerce.memberapi.config.MemberTransactional
import kr.co.commerce.memberapi.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
@MemberTransactional(readOnly = true)
class MemberSearchService(
  private val memberRepository: MemberRepository
) {

  fun findLimit(page:Long = 1, pageSize: Long = 10): List<Member> {
      return memberRepository.findLimit(page, pageSize)
  }

  fun findByEmail(email:String): Member {
    return memberRepository.findByEmail(email) ?:
      throw IllegalArgumentException("email '$email' does not exist")
  }
}
