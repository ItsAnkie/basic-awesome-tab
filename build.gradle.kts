import com.github.jengelman.gradle.plugins.shadow.ShadowPlugin
import net.kyori.indra.IndraPlugin

plugins {
    id("net.kyori.indra") version "2.0.5"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.nearvanilla.bat"
version = "1.1.0-SNAPSHOT"

subprojects {
    apply {
        plugin<ShadowPlugin>()
        plugin<IndraPlugin>()
    }

    repositories {
        maven("https://papermc.io/repo/repository/maven-public/")
        maven("https://repo.minebench.de/")
        mavenCentral()
        mavenLocal()
    }

    tasks {

        indra {
            gpl3OnlyLicense()

            javaVersions {
                target(17)
            }
        }

        processResources {
            expand("version" to rootProject.version)
        }

    }
}
