plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.kata"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.yaml:snakeyaml:2.2")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}