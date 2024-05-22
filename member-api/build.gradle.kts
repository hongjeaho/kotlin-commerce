plugins {
  kotlin("plugin.jpa")
  kotlin("kapt")
}

dependencies {
  implementation(project(":common-core"))
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")

  implementation("org.mapstruct:mapstruct:1.5.1.Final")
  kapt("org.mapstruct:mapstruct-processor:1.5.1.Final")

  testImplementation(project(":flyway"))
  testImplementation(project(":common-test"))
}

noArg {
  annotation("jakarta.persistence.Entity")
}
