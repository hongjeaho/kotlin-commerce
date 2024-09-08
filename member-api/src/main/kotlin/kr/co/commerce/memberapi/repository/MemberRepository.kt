package kr.co.commerce.memberapi.repository

import kr.co.commerce.common.jooq.generated.tables.JMember
import kr.co.commerce.common.jooq.generated.tables.pojos.Member
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class MemberRepository(
  val dlsContext: DSLContext
)  {
  val MEMBER:JMember = JMember.MEMBER

  fun findLimit(page:Long, pageSize: Long): List<Member> {
    return dlsContext.select().from(MEMBER)
      .limit(pageSize)
      .offset((page - 1) * pageSize)
      .fetchInto(Member::class.java)
  }

  fun findByEmail(email: String) :Member? {
    return dlsContext.select().from(MEMBER)
      .where(MEMBER.EMAIL.eq(email))
      .fetchOneInto(Member::class.java)
  }
}
