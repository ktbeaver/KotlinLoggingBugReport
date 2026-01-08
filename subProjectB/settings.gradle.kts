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

include(":moduleB")

includeBuild("subProjectC") {
    dependencySubstitution {
        substitute(module("org.example:moduleC")).using(project(":moduleC"))
    }
}
