plugins {
    alias(libs.plugins.paperweight)
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
