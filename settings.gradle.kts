pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
//plugins {
//    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
//}


rootProject.name = "Tally"

include(":app")
//include(":storage")
//include(":feature:dashboard")
//include(":feature:weight")
//include(":feature:todo")
//include(":feature:stats")
//include(":feature:settings")
//include(":domain")
