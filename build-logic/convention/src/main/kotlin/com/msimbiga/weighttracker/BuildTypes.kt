package com.msimbiga.weighttracker

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.configure

internal fun Project.configureBuildTypes(
    commonExtension: CommonExtension,
    extensionType: ExtensionType
) {
    commonExtension.run {
        buildFeatures.apply {
            buildConfig = true
        }

        when (extensionType) {
            ExtensionType.APPLICATION -> {
                (this as ApplicationExtension).buildTypes {
                    debug {
                        configureDebugBuildType(libs)
                    }
                    release {
                        configureReleaseBuildType(
                            commonExtension = commonExtension,
                            versionCatalog = libs
                        )
                    }
                }
            }

            ExtensionType.LIBRARY -> {
                (this as LibraryExtension).buildTypes {
                    debug {
                        configureDebugBuildType(libs)
                    }
                    release {
                        configureReleaseBuildType(
                            commonExtension = commonExtension,
                            minifyEnabled = false,
                            versionCatalog = libs
                        )
                    }
                }
            }
        }

        configureSigningConfigs(commonExtension)
    }
}

private fun BuildType.configureDebugBuildType(versionCatalog: VersionCatalog) {
//    val hostUrl = versionCatalog.findVersion("projectDevHost").get().toString()
    val appName = versionCatalog.findVersion("projectApplicationName").get().toString().plus(" DEV")

    manifestPlaceholders["crashlyticsEnabled"] = true
//    manifestPlaceholders["deeplinkHostUrl"] = hostUrl
//    manifestPlaceholders["applicationName"] = appName
    buildConfigField("String", "applicationName", '"' + appName + '"')
//    buildConfigField("String", "deeplinkHostUrl", '"' + hostUrl + '"')
}

private fun BuildType.configureReleaseBuildType(
    commonExtension: CommonExtension,
    minifyEnabled: Boolean = true,
    versionCatalog: VersionCatalog
) {
//    val hostUrl = versionCatalog.findVersion("projectProdHost").get().toString()
    val appName = versionCatalog.findVersion("projectApplicationName").get().toString()

    manifestPlaceholders["crashlyticsEnabled"] = true
//    manifestPlaceholders["deeplinkHostUrl"] = hostUrl
    manifestPlaceholders["applicationName"] = appName
    buildConfigField("String", "applicationName", '"' + appName + '"')
//    buildConfigField("String", "deeplinkHostUrl", '"' + hostUrl + '"')

    isMinifyEnabled = minifyEnabled
    isShrinkResources = minifyEnabled

    proguardFiles(
        commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
    )

}

private fun BuildType.configurePlaceholders(
    crashlyticsEnabled: Boolean = true,
    deeplinkHostUrl: String,
    applicationName: String,
) {
    // Removed usage since using this function for both release and debug build would cause to override
    // deeplinkHost
    manifestPlaceholders["crashlyticsEnabled"] = crashlyticsEnabled
    manifestPlaceholders["deeplinkHostUrl"] = deeplinkHostUrl
    manifestPlaceholders["applicationName"] = applicationName
    buildConfigField("String", "applicationName", '"' + applicationName + '"')
    buildConfigField("String", "deeplinkHostUrl", '"' + deeplinkHostUrl + '"')
}