/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.compose.compiler) apply false
    id("org.sonarqube") version "6.2.0.5505"
}

sonar {
  properties {
    property("sonar.projectKey", "whitej031788_kotlin-architecture-samples_4584e6b6-9ce4-462f-a4f0-5da67a4eda6c")
    property("sonar.projectName", "kotlin-architecture-samples")
  }
}

allprojects {
    configurations.all {
        resolutionStrategy {
            force("org.bouncycastle:bcprov-jdk15to18:1.77")
            force("org.bouncycastle:bcpkix-jdk15to18:1.77")
            force("org.bouncycastle:bcutil-jdk15to18:1.77")
            force("org.bouncycastle:bctls-jdk15to18:1.77")
        }
    }
}

// This is a temporary block and is added because of the following issue:
// https://community.sonarsource.com/t/sonarqube-gradle-plugin-6-0-breaks-android-tasks/130863/12
// The block should be removed after upgrading the "androidGradlePlugin" to version 8.9 or higher.
// The issue has been fixed by Google and will be available in the next version.
buildscript {
    dependencies {
        classpath("org.bouncycastle:bcutil-jdk18on:1.79")
    }
}