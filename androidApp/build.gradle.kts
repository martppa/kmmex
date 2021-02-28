plugins {
    id("com.android.application")
    kotlin("android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android")
}

dependencies {
    implementation(project(":core"))
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.3")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("org.koin:koin-android-viewmodel:2.2.2")
    implementation("org.koin:koin-android:3.0.1-alpha-3")
    implementation("org.koin:koin-android-scope:2.2.2")
    implementation("org.koin:koin-core:3.0.1-alpha-3")
    implementation("com.android.support:multidex:1.0.3")
}

android {
    compileSdkVersion(29)

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.martppa.kmmex.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}