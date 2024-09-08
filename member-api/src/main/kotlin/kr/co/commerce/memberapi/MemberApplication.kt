package kr.co.commerce.memberapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [
  "kr.co.commerce.memberapi",
  "kr.co.commerce.jooq",
])
class MemberApplication

fun main(args: Array<String>) {
  runApplication<MemberApplication>(*args)
}
