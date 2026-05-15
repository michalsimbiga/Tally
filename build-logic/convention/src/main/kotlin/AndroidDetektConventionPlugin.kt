import com.msimbiga.tally.libs
//import io.gitlab.arturbosch.detekt.Detekt
//import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidDetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(
                libs.findLibrary("detekt-gradlePlugin").get().get().group.toString()
            )
//            val extension = extensions.getByType<DetektExtension>()
//            configureDetekt(extension)
        }
    }
}

//internal fun Project.configureDetekt(extension: DetektExtension) {
//    extension.apply {
//        tasks.named<Detekt>("detekt") {
//            buildUponDefaultConfig = true
//            config.setFrom(files("$rootDir/app/config/detekt/detekt.yml"))
//
//            input = objects.fileCollection().from(
//                "src/main/java",
//                "src/test/java",
//                "src/androidTest/java",
//            )
//
//            reports {
//                xml.required.set(true)
//                html.required.set(true)
//                txt.required.set(true)
//                sarif.required.set(true)
//            }
//        }
//        dependencies {
//            "detektPlugins"(libs.findLibrary("detekt-formatting").get())
//        }
//    }
//}
