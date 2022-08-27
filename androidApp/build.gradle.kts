plugins {
    id("com.android.application")
    kotlin("android")
}

val kotlinCoroutinesVersion: String by rootProject.extra
val composeVersion: String by rootProject.extra
val androidKtxCore: String by rootProject.extra
val navigationVersion: String by rootProject.extra
val lifecycleVersion: String by rootProject.extra

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.madapp.sample.kmm.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0-rc02"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")

    implementation("androidx.navigation:navigation-runtime-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-compose:$navigationVersion")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
}