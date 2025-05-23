plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.donasiyuk"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.donasiyuk"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10" //
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Compose UI
    implementation("androidx.compose.ui:ui:1.6.1")
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.1")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.6")

    // Untuk preview
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.1")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.1")
}
