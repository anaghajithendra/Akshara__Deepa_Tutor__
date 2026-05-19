pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AksharaDeepaTutor"
include(":app")

gradle.beforeProject {
    var externalBuildRoot = providers.environmentVariable("AKSHARA_BUILD_DIR").orNull
    
    // Automatically relocate build directory if in OneDrive to avoid "Unable to delete directory" errors
    if (externalBuildRoot == null && layout.projectDirectory.asFile.absolutePath.contains("OneDrive")) {
        val tempDir = System.getProperty("java.io.tmpdir")
        externalBuildRoot = "$tempDir/gradle-builds/${rootProject.name}"
    }

    if (externalBuildRoot != null) {
        layout.buildDirectory.set(file("$externalBuildRoot/${path.removePrefix(":").replace(':', '-').ifBlank { "root" }}"))
    }
}
