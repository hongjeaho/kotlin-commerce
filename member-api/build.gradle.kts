apply(plugin = "kotlin-jpa")

dependencies {
    implementation(project(":common-core"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    testImplementation(project(":flyway"))
    testImplementation(project(":common-test"))
}