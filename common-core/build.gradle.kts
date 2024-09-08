val jooqVersion : String by project

description = "base module"

dependencies {
  implementation("com.fasterxml.uuid:java-uuid-generator:4.3.0")
  implementation("org.jooq:jooq-codegen")
}

dependencyManagement {
  imports {
    mavenBom("org.jooq:jooq-codegen:${jooqVersion}")
  }
}
