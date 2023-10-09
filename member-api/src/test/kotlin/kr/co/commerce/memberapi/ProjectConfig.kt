package kr.co.commerce.memberapi

import io.kotest.common.ExperimentalKotest
import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.config.LogLevel
import io.kotest.core.names.DuplicateTestNameMode
import io.kotest.core.spec.IsolationMode
import io.kotest.core.test.AssertionMode
import io.kotest.extensions.spring.SpringExtension
import kr.co.commerce.test.TestProjectConfig

object ProjectConfig : TestProjectConfig()