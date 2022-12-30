dependencies {
    compileOnly(libs.velocity.api)
    annotationProcessor(libs.velocity.api)

    compileOnly(libs.luckperms)
    compileOnly(files("${project.projectDir}/libs/VelocityVanish.v3.10.2.jar"))

    implementation(libs.cloud.velocity)
    implementation(libs.cloud.annotations)
    implementation(libs.configurate.hocon)
    implementation(libs.minedown)
}

java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

tasks {
    build {
        dependsOn(named("shadowJar"))
    }

    shadowJar {
        archiveClassifier.set(null as String?)
        archiveFileName.set(project.name + ".jar")
        destinationDirectory.set(rootProject.tasks.shadowJar.get().destinationDirectory.get())
        relocate("de.themoep.minedown", "com.nearvanilla.bat.shaded.minedown")
        minimize()
    }
}
