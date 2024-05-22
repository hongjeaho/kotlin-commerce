package kr.co.commerce.memberapi.mapper

import kr.co.commerce.memberapi.domain.Member
import kr.co.commerce.memberapi.dto.members.MemberRequest
import kr.co.commerce.memberapi.dto.members.MemberResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MemberMapper {

  fun toCopyResponse(member: Member): MemberResponse

  fun toCopyEntity(request: MemberRequest): Member
}
