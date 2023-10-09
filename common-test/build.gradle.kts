description = "test module"

val kotestVersion by extra("5.6.2")

dependencies {
  api("io.kotest:kotest-runner-junit5:$kotestVersion")
  api("io.kotest:kotest-assertions-core:$kotestVersion")
  api("io.kotest.extensions:kotest-extensions-spring:1.1.3")
  api("io.kotest:kotest-extensions-spring:4.4.3")
  api("io.kotest.extensions:kotest-extensions-testcontainers:2.0.2")
  api("org.testcontainers:mysql:1.17.6")

  api("org.flywaydb:flyway-mysql:9.22.0")
  api("org.flywaydb:flyway-core")
}