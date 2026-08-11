import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsEnvSpec
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootEnvSpec

plugins {
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

// Node.js/Yarn distributions resolve from the ivy repositories in settings.gradle.kts;
// null here stops the Kotlin plugin from registering its own project-level repositories,
// which FAIL_ON_PROJECT_REPOS would reject.
plugins.withType<YarnPlugin> {
    the<YarnRootEnvSpec>().downloadBaseUrl = null
}
allprojects {
    plugins.withType<NodeJsPlugin> {
        the<NodeJsEnvSpec>().downloadBaseUrl = null
    }
}
