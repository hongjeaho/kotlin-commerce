plugins {
  kotlin("plugin.jpa")
}

dependencies {
  implementation(project(":common-core"))
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")

  testImplementation(project(":flyway"))
  testImplementation(project(":common-test"))
}

noArg {
  annotation("jakarta.persistence.Entity")
}
