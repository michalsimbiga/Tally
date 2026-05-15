package com.msimbiga.tally

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.invoke


internal fun Project.configureSigningConfigs(
    commonExtensions: CommonExtension,
) {

    commonExtensions.apply {
        signingConfigs {
            register("release") {
                keyAlias = System.getenv("KEY_ALIAS")
                keyPassword = System.getenv("KEYSTORE_PASSWORD")
                storeFile = file(System.getenv("KEYSTORE_PATH") ?: "/dev/null")
                storePassword = System.getenv("KEYSTORE_PASSWORD")
            }
        }
    }
}