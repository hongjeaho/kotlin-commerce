plugins {
    id("org.flywaydb.flyway") version "9.22.0"
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.flywaydb:flyway-mysql:9.22.0")
    }
}

flyway {
    url = "jdbc:mysql://localhost:3306/store"
    user = "root"
    password = "root"
    locations = arrayOf("filesystem:${file("src/main/resources/migration").absolutePath}")
    encoding = "UTF-8"
    cleanDisabled = false
    validateOnMigrate = true
}