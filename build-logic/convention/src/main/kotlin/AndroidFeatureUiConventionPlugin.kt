import com.msimbiga.tally.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureUiConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("tally.android.library.compose")
            }

            dependencies {
//                "implementation"(project(":core:presentation:ui"))
//                "implementation"(project(":core:presentation:designsystem"))
//
//                "implementation"(project.libs.findBundle("koin.compose").get())
//                "implementation"(project.libs.findBundle("compose").get())
//                "debugImplementation"(project.libs.findBundle("compose.debug").get())
                "androidTestImplementation"(project.libs.findLibrary("androidx.compose.ui.test.junit4").get())

            }
        }
    }
}