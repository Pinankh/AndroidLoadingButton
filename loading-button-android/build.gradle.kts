import com.vanniktech.maven.publish.SonatypeHost

val libraryVersion: String by rootProject.extra

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.sonatype.publish)
}


mavenPublishing {
    val artifactId = "loading-button"

    coordinates(
        groupId = "io.pinankh",
        artifactId = artifactId,
        version = libraryVersion
    )

    pom {
        name = artifactId
        description = "Core module of pinankh"
        url = "https://github.com/Pinankh/LoadingButton_master"

        developers {
            developer {
                id = "pinankh"
                name = "Pinankh Patel"
                url = "https://github.com/Pinankh"
            }
        }

        licenses {
            license {
                name = "The Apache Software License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }


    }

    signAllPublications()
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = false)
}


android {
    namespace = "io.pinankh.loadingbutton"
    compileSdk = 35

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidx.core)
    testImplementation(libs.junit)
}
