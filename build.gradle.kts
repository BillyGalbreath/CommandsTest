plugins {
    `java-library`
}

allprojects {
    apply(plugin = "java-library")

    version = "0.0.1"

    java {
        toolchain.languageVersion = JavaLanguageVersion.of(21)
    }

    tasks {
        compileJava {
            options.encoding = Charsets.UTF_8.name()
            options.release = 21
        }
    }
}

// this must be after subprojects block
tasks {
    withType<Jar> {
        subprojects {
            dependsOn(project.tasks.build)
        }

        // get subproject's built jars
        val jars = subprojects.map { zipTree(it.tasks.jar.get().archiveFile.get().asFile) }

        // merge them into main jar (except their manifests)
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        from(jars) {
            exclude("META-INF/MANIFEST.MF")
        }

        // put behind an action because files don't exist at configuration time
        doFirst {
            // merge all subproject's manifests into main manifest
            jars.forEach { jar ->
                jar.matching { include("META-INF/MANIFEST.MF") }
                    .files.forEach { file ->
                        manifest.from(file)
                    }
            }
        }
    }
}
