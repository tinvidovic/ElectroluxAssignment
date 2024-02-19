plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    namespace = "com.nticoding.electroluxassignment"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // NOTE: In actual production app should never use debug signing config
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Core
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.lifecycleViewModel)

    // Jetpack Compose
    implementation(Compose.composeActivity)
    implementation(platform(Compose.composeBoM))
    implementation(Compose.composeUi)
    implementation(Compose.composeGraphics)
    implementation(Compose.composeFoundations)
    implementation(Compose.composeUiToolingPreview)
    implementation(Compose.composeViewModel)
    debugImplementation(Compose.composeUiTooling)

    // Dagger-Hilt
    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)

    // LeakCanary
    // debugImplementation because LeakCanary should only run in debug builds.
    debugImplementation(DebugUtils.leakCanary)


}