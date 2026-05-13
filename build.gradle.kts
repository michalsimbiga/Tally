// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.room) apply false
//    alias(libs.plugins.mapsplatform.secrets.plugin) apply false
//    alias(libs.plugins.compose.compiler) apply false
//    alias(libs.plugins.navigation.safeargs) apply false
//    alias(libs.plugins.detekt) apply false
//    alias(libs.plugins.app.distribution) apply false
}