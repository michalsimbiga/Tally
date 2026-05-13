package com.msimbiga.weighttracker

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import kotlin.text.get
import kotlin.toString

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension,
) {
    commonExtension.apply {
        buildFeatures.apply {
            compose = true
        }

        composeOptions.apply {
            kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
        }

        dependencies {
            val bom = libs.findLibrary("androidx.compose.bom").get()
            "implementation"(platform(bom))
            "androidTestImplementation"(platform(bom))
            "debugImplementation"(libs.findLibrary("androidx.compose.ui.tooling.preview").get())


            // Compose
//            add("implementation", libs.findBundle("composeBundle").get())
//            add("implementation", libs.findBundle("accompanistBundle").get())
//            add("implementation", libs.findLibrary("compose-ui-tooling").get())
//            add("debugImplementation", libs.findLibrary("compose-ui-tooling").get())
        }

    }

//    extensions.configure<ComposeCompilerGradlePluginExtension> {
//        fun Provider<String>.onlyIfTrue() = flatMap { provider { it.takeIf(String::toBoolean) } }
//        fun Provider<*>.relativeToRootProject(dir: String) = flatMap {
//            rootProject.layout.buildDirectory.dir(projectDir.toRelativeString(rootDir))
//        }.map { it.dir(dir) }
//
//        project.providers.gradleProperty("enableComposeCompilerMetrics").onlyIfTrue()
//            .relativeToRootProject("compose-metrics")
//            .let(metricsDestination::set)
//
//        project.providers.gradleProperty("enableComposeCompilerReports").onlyIfTrue()
//            .relativeToRootProject("compose-reports")
//            .let(reportsDestination::set)

//        stabilityConfigurationFile =
//            rootProject.layout.projectDirectory.file("compose_compiler_config.conf")
//    }
}