plugins {
  kotlin("kapt")
}

val jooqVersion: String by project

dependencies {
  implementation(project(":common-core"))
  implementation(project(":jooq-base"))
  implementation("org.springframework.boot:spring-boot-starter-web")

  implementation("org.springframework.boot:spring-boot-starter-jooq") {
    exclude(group = "org.jooq", module = "jooq")
  }
  implementation ("org.jooq:jooq:${jooqVersion}")

  testImplementation(project(":jooq-base"))
  testImplementation(project(":flyway"))
  testImplementation(project(":common-test"))
}
