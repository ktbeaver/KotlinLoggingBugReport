import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

group = "org.example"
version = "unspecified"

kotlin {
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(libs.kotlin.logging)
                implementation("org.example:moduleA")
                implementation("org.example:moduleB")
                implementation("org.example:moduleC")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(libs.kotlin.test)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(libs.bundles.jvm.logging)
            }
        }
        val jvmTest by getting {}

        val androidMain by getting {}
        val androidUnitTest by getting {}

        val iosX64Main by getting {}
        val iosX64Test by getting {}

        val iosArm64Main by getting {}
        val iosArm64Test by getting {}

        val iosSimulatorArm64Main by getting {}
        val iosSimulatorArm64Test by getting {}

        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = group.toString()
    compileSdk =
        libs.versions.android.compileSdk
            .get()
            .toInt()
    defaultConfig {
        minSdk =
            libs.versions.android.minSdk
                .get()
                .toInt()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            // to solve: 3 files found with path 'META-INF/versions/9/OSGI-INF/MANIFEST.MF':
            excludes += "META-INF/versions/9/OSGI-INF/MANIFEST.MF" // required by TSM SDK
        }
    }
    testOptions {
        targetSdk =
            libs.versions.android.targetSdk
                .get()
                .toInt()
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }
    buildToolsVersion = "35.0.0"
}
