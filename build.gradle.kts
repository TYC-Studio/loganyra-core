import org.gradle.kotlin.dsl.implementation

plugins {
    java
    id("org.springframework.boot") version "4.0.2"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "org.tyc-studio"
version = "0.1.0-SNAPSHOT"
description = "loganyra-core"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
        repositories {
            // 修复windows上无法识别java工具链的bug
            listOf("https://repo.gradle.org/gradle/java-toolchains/")
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // spring boot starter
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // h2
    implementation("org.springframework.boot:spring-boot-h2console")
    runtimeOnly("com.h2database:h2")

    // mysql
    runtimeOnly("com.mysql:mysql-connector-j")

    // web api
    implementation("org.springframework.boot:spring-boot-starter-web")

}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 17
}
