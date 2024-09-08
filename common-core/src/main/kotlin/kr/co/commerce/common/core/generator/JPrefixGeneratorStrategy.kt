package kr.co.commerce.common.core.generator

import org.jooq.codegen.DefaultGeneratorStrategy
import org.jooq.codegen.GeneratorStrategy.Mode
import org.jooq.meta.Definition


class JPrefixGeneratorStrategy : DefaultGeneratorStrategy() {

  override fun getJavaClassName(definition: Definition?, mode: Mode?): String {
    if(mode == Mode.DEFAULT) {
      return "J${super.getJavaClassName(definition, mode)}"
    }

    return super.getJavaClassName(definition, mode)
  }
}
