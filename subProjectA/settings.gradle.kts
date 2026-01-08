rootProject.name = "KotlinLoggingBugReport"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":moduleA")

// includeBuild("../subProjectB") {
//    dependencySubstitution {
//        substitute(module("org.example:moduleB")).using(project(":moduleB"))
//    }
// }
//
// includeBuild("../subProjectB/subProjectC") {
//    dependencySubstitution {
//        substitute(module("org.example:moduleC")).using(project(":moduleC"))
//    }
// }
