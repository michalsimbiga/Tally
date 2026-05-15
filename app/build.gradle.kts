plugins {
    alias(libs.plugins.tally.android.application.compose)
    alias(libs.plugins.kotlin.serialization)

//    alias(libs.plugins.payeye.android.application.compose)
//    alias(libs.plugins.payeye.android.room)
//    alias(libs.plugins.mapsplatform.secrets.plugin)
//    alias(libs.plugins.navigation.safeargs)
//    alias(libs.plugins.firebase.crashlytics)
//    alias(libs.plugins.google.services)
//    alias(libs.plugins.app.distribution)
}

android {
    namespace = "com.msimbiga.tally"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization.json)


    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}