
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  val kotlinVersion = "1.8.22"
  id("org.springframework.boot") version "3.1.4" apply false
  id("io.spring.dependency-management") version "1.1.3"
  id("org.jlleitschuh.gradle.ktlint") version "11.6.0"
  id("idea")

  kotlin("jvm") version kotlinVersion
  kotlin("plugin.spring") version kotlinVersion
}

allprojects {
  group = "kr.co.commerce"
  version = "0.0.1-SNAPSHOT"

  repositories {
    mavenCentral()
  }
}

subprojects {
  apply(plugin = "kotlin")
  apply(plugin = "idea")
  apply(plugin = "kotlin-spring")
  apply(plugin = "io.spring.dependency-management")

  java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  dependencies {

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("com.mysql:mysql-connector-j")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
  }

  dependencyManagement {
    imports {
      mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
  }

  tasks.withType<KotlinCompile> {
    compilerOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget.set(JvmTarget.JVM_17)
    }
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }
}


