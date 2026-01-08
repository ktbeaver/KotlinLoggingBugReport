rootProject.name = "KotlinLoggingBugReport"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = "https://jitpack.io")
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

include(":composeApp")
include(":shared")

includeBuild("subProjectA") {
    dependencySubstitution {
        substitute(module("org.example:moduleA")).using(project(":moduleA"))
    }
}

includeBuild("subProjectB") {
    dependencySubstitution {
        substitute(module("org.example:moduleB")).using(project(":moduleB"))
    }
}

includeBuild("subProjectB/subProjectC") {
    dependencySubstitution {
        substitute(module("org.example:moduleC")).using(project(":moduleC"))
    }
}
