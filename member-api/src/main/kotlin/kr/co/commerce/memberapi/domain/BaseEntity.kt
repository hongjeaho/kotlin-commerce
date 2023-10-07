package kr.co.commerce.memberapi.domain

import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Version
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
  @Version
  var version: Long = 0
    protected set

  @CreatedBy
  var createdBy: String? = null
    protected set

  @CreatedDate
  var createdTime: LocalDateTime? = null
    protected set

  @LastModifiedDate
  var updatedTime: LocalDateTime? = null
    protected set

  @LastModifiedBy
  var updatedBy: String? = null
    protected set
}