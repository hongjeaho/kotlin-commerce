package kr.co.commerce.common.core.utils

import com.fasterxml.uuid.Generators
import java.util.UUID

object GeneratorUtils {
  fun generatorUUID(): UUID = Generators.timeBasedEpochGenerator().generate();
}