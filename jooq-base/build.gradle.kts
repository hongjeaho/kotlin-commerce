import org.jooq.meta.jaxb.ForcedType
import org.jooq.meta.jaxb.Logging
import org.jooq.meta.jaxb.Property

plugins {
  id ("nu.studer.jooq") version "9.0"
}

val jooqVersion: String by project

dependencies {
  jooqGenerator(project(":common-core"))
  jooqGenerator("com.mysql:mysql-connector-j")
  jooqGenerator("org.jooq:jooq-codegen")
  jooqGenerator("org.jooq:jooq-meta")
}

// 모든  jooq 버전 일괄 설정
configurations.all {
  resolutionStrategy {
    eachDependency {
      if (requested.group == "org.jooq") {
        useVersion(jooqVersion)
      }
    }
  }
}

jooq {
  version.set(jooqVersion)
  edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)

  configurations {
    create("main") {
      generateSchemaSourceOnCompilation = true

      jooqConfiguration.apply {
        logging = Logging.WARN

        jdbc.apply {
          driver = "com.mysql.cj.jdbc.Driver"
          url = "jdbc:mysql://localhost:3306"
          user = "root"
          password = "root"
          properties.add(Property().apply {
            key = "ssl"
            value = "true"
          })
        }

        generator.apply {
          name = "org.jooq.codegen.KotlinGenerator"
          database.apply {
            inputSchema = "store"
            name = "org.jooq.meta.mysql.MySQLDatabase"
            excludes = """flyway_schema_history"""
            isUnsignedTypes = true

            forcedTypes.addAll(listOf(
              ForcedType().apply {
                userType = "java.lang.Long"
                includeTypes = "int unsigned"
              },
              ForcedType().apply {
                userType = "java.lang.Integer"
                includeTypes = "tinyint unsigned"
              },
              ForcedType().apply {
                userType = "java.lang.Integer"
                includeTypes = "smallint unsigned"
              }
            ))
          }

          generate.apply {
            isDaos = true
            isRecords = true
            isFluentSetters = true
            isJavaTimeTypes = true
            isDeprecated = false
            isKotlinNotNullPojoAttributes = true
            isKotlinNotNullRecordAttributes = true
          }

          target.apply {
            packageName = "kr.co.commerce.common.jooq.generated"
            directory = "src/generated"
          }

          strategy.name = "kr.co.commerce.common.core.generator.JPrefixGeneratorStrategy"
        }
      }
    }
  }
}

sourceSets {
  named("main") {
    java {
      srcDirs("src/generated")
    }
  }
}
