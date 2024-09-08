package kr.co.commerce.jooq

import org.jooq.conf.ExecuteWithoutWhere
import org.springframework.boot.autoconfigure.jooq.DefaultConfigurationCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JooqConfig {
  @Bean
  fun jooqDefaultConfigurationCustomizer() : DefaultConfigurationCustomizer {
    return DefaultConfigurationCustomizer { customizer ->
      customizer.settings()
        .withRenderSchema(false)
        .withExecuteUpdateWithoutWhere(ExecuteWithoutWhere.THROW)
        .withExecuteDeleteWithoutWhere(ExecuteWithoutWhere.THROW)
    }
  }
}
