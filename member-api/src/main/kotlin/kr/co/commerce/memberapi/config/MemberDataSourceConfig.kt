package kr.co.commerce.memberapi.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.AliasFor
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import javax.sql.DataSource
import kotlin.reflect.KClass

@EnableTransactionManagement
@Configuration
class MemberDataSourceConfig {
  companion object {
    const val DOMAIN_DATA_SOURCE = "memberDomainDataSource"
    const val TRANSACTION_MANAGER = "memberDomainTransactionManager"
    const val DOMAIN_NAMED_PARAMETER_JDBC_OPERATIONS = "memberDomainNamedParameterJdbcOperations"
    private const val DOMAIN_JDBC_TEMPLATE = "memberDomainJdbcTemplate"
  }

  @Bean
  @Qualifier(DOMAIN_DATA_SOURCE)
  @ConfigurationProperties("member.domain.datasource")
  fun memberDomainDataSource() : HikariDataSource =
      DataSourceBuilder.create().type(HikariDataSource::class.java).build()

  @Bean
  @Qualifier(TRANSACTION_MANAGER)
  fun memberDomainTransactionManager(@Qualifier(DOMAIN_DATA_SOURCE) dataSource: DataSource) : PlatformTransactionManager =
      DataSourceTransactionManager(dataSource)

  @Bean
  @Qualifier(DOMAIN_NAMED_PARAMETER_JDBC_OPERATIONS)
  fun memberDomainNamedParameterJdbcOperations() : NamedParameterJdbcOperations =
      NamedParameterJdbcTemplate(memberDomainDataSource())

  @Bean
  @Qualifier(DOMAIN_JDBC_TEMPLATE)
  fun memberDomainJdbcTemplate(@Qualifier(DOMAIN_DATA_SOURCE) dataSource: DataSource) : JdbcTemplate =
      JdbcTemplate(dataSource)
}

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Transactional(MemberDataSourceConfig.TRANSACTION_MANAGER)
annotation class MemberTransactional(
    @get:AliasFor(annotation = Transactional::class) val propagation : Propagation = Propagation.REQUIRED,
    @get:AliasFor(annotation = Transactional::class) val isolation: Isolation = Isolation.DEFAULT,
    @get:AliasFor(annotation = Transactional::class) val timeout: Int = 600,
    @get:AliasFor(annotation = Transactional::class) val readOnly: Boolean = false,
    @get:AliasFor(annotation = Transactional::class) val rollbackFor: Array<KClass<out Exception>> = [],
    @get:AliasFor(annotation = Transactional::class) val rollbackForClassName: Array<String> = [],
    @get:AliasFor(annotation = Transactional::class) val noRollbackFor : Array<KClass<out Exception>> = [],
    @get:AliasFor(annotation = Transactional::class) val noRollbackForClassName : Array<String> = []
)