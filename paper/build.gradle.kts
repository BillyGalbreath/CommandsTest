plugins {
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.17"
}

dependencies {
    implementation(project(":core"))

    paperweight.paperDevBundle("1.21.5-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        dependsOn(":core:jar")
    }
}
