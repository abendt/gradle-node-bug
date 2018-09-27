

buildscript {
	repositories {
		jcenter()
	}
}

plugins {
	base
}

allprojects {

	repositories {
		jcenter()
	}

}

dependencies {
	// Make the root project archives configuration depend on every subproject
	subprojects.forEach {
		archives(it)
	}
}
