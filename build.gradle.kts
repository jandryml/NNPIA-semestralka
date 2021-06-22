import com.moowork.gradle.node.npm.NpmTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("com.github.node-gradle.node") version "2.2.2"
    kotlin("jvm") version "1.3.71"
    kotlin("plugin.spring") version "1.3.71"

}

group = "cz.edu.upce"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

val jar: Jar by tasks
val bootJar : BootJar by tasks
configurations {
    listOf(apiElements, runtimeElements).forEach { ndop ->
        ndop.get().outgoing.artifacts.removeIf { it.buildDependencies.getDependencies(null).contains(jar) }
        ndop.get().outgoing.artifact(bootJar)
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

//    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.postgresql:postgresql")
    implementation("com.h2database:h2")

    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.register<NpmTask>("appNpmInstall") {
    description = "Installs all dependencies from package.json"
    workingDir = file("${project.projectDir}/src/main/webapp")
    args = listOf("install")
}


tasks.register<NpmTask>("appNpmBuild") {
    dependsOn("appNpmInstall")
    description = "Builds project"
    workingDir = file("${project.projectDir}/src/main/webapp")
    args = listOf("run", "build")
}

tasks.register<Copy>("copyWebApp") {
    dependsOn("appNpmBuild")
    description = "Copies built project to where it will be served"
    from("src/main/webapp/build")
    into("build/resources/main/static/.")
}

node {
    download = true
    version = "12.13.1"
    npmVersion = "6.12.1"
    // Set the work directory for unpacking node
    workDir = file("${project.buildDir}/nodejs")
    // Set the work directory for NPM
    npmWorkDir = file("${project.buildDir}/npm")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    dependsOn("copyWebApp")
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
