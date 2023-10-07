package kr.co.commerce.memberapi.dao

import kr.co.commerce.memberapi.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MemberRepository : JpaRepository<Member, UUID> {
}