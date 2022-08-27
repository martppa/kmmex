val kotlinCoroutinesVersion by extra { "1.6.4" }
val composeVersion by extra { "1.2.1" }
val androidKtxCore by extra { "1.8.0" }
val navigationVersion by extra { "2.4.2" }
val lifecycleVersion by extra { "2.5.1" }

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("com.android.tools.build:gradle:7.2.2")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}