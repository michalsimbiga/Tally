package com.msimbiga.weighttracker

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.invoke

enum class PasswalletFlavour(
    val dimension: String,
    val versionNameSuffix: String? = null,
    val applicationIdSuffix: String? = null,
) {
    DEV(dimension = "environment", applicationIdSuffix = ".dev"),
    PROD(dimension = "environment"),
    GOOGLE(dimension = "provider", versionNameSuffix = "GMS"),
    HUAWEI(dimension = "provider", versionNameSuffix = "HMS")
}

internal fun Project.configureFlavourTypes(
    commonExtensions: CommonExtension,
) {

    commonExtensions.apply {

        flavorDimensions += listOf("environment", "provider")

        productFlavors {
            PasswalletFlavour.values().forEach {
                create(it.name.lowercase()) {
                    dimension = it.dimension
//                    flavorConfigurationBlock(this, it)
                    if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (it.applicationIdSuffix != null) {
                            applicationIdSuffix = it.applicationIdSuffix
                        }
                        if (it.versionNameSuffix != null) {
                            versionNameSuffix = it.versionNameSuffix
                        }
                    }
                }
            }
        }

        sourceSets {
            named("dev") {
                java.srcDirs("src/dev/java")
                res.srcDirs("src/dev/res")
            }
            named("prod") {
                java.srcDirs("src/prod/java")
                res.srcDirs("src/prod/res")
            }
            named("google") {
                java.srcDirs("src/google/java")
            }
            named("huawei") {
                java.srcDirs("src/huawei/java")
            }
        }
    }
}