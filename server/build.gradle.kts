// import org.springframework.boot.gradle.tasks.bundling.BootJar
import com.moowork.gradle.node.yarn.YarnTask

plugins {
	java

	id("org.springframework.boot") version "2.0.5.RELEASE"
	id("io.spring.dependency-management") version "1.0.6.RELEASE"

	id("com.moowork.node") version "1.2.0"
}

repositories {
	mavenLocal()
	jcenter()
}

node {
	// Version of node to use.
	version = "8.11.3"

	// Version of Yarn to use.
	yarnVersion = "1.9.4"

	download = true
}

tasks {

	val jest by creating(YarnTask::class) {
		description = "run all jest tests"
		group = "Verification"

		dependsOn("yarn_install")
		args = listOf("test")
	}

	"check" {
		dependsOn(jest)
	}
}
