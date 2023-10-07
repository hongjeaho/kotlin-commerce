package kr.co.commerce.memberapi.application

import kr.co.commerce.memberapi.config.MemberTransactional
import kr.co.commerce.memberapi.dao.MemberRepository
import org.springframework.stereotype.Service

@Service
@MemberTransactional(readOnly = true)
class MemberSearchService(
  private val memberRepository: MemberRepository
) {

  fun findAll() = memberRepository.findAll()
}