plugins {
	java
}

repositories {
	jcenter()
	mavenCentral()
	maven("https://maven.shedaniel.me/")
	maven("https://maven.fabricmc.net/")
	maven("https://jitpack.io/")
}

dependencies {
	implementation("com.github.PepperCode1", "mcp-tiny", "1bde92310cd80f0d834403d40219a2a06be431da")
	implementation("net.fabricmc", "fabric-loom", "0.6-SNAPSHOT")
}
