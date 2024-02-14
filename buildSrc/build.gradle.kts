import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl` // Access Gradle DSL functionality
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    // NOTE: Version should match version specified in the /Build.kt file
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    implementation("com.android.tools.build:gradle:8.2.2")
}


val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}