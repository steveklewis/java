Welcome to multiformat, developed by Steve Lewis!

Highlights:
1. Usage of spring-boot - Why did I choose Spring? It's not something I've used at work before, but I understand its value in an Enterprise Java shop. What I do like most about Spring is how it encourages a more modern style of Java, especially with the arrival of Java 8.
2. Usage of thymeleaf templates.
3. Usage of reflection to get access to JavaBean fields without adding getters.
4. Usage of an interface to abstract out the specific details of the different formats.
5. Some amount of error handling.
6. Gradle build system is used, with accompanying build.gradle file.

Prerequisites:
* Java 8 is required.
* gradle is installed on the machine and gradle is available in your path.
* git is installed on the machine and git is available in your path.

Instructions to run:

1. git clone https://github.com/steveklewis/java
2. cd into java/spring/multiformat directory
3. Execute "gradle bootRun" - this will start up the Spring Boot process
4. Open your browser and go to "http://localhost:8080/multiformat"

To compile the source code:

1. cd into multiformat directory
2. Execute "gradle compileJava"

To create the jar to execute separately from the gradle bootRun:

1. cd into multiformat directory
2. Execute "gradle build"
3. There will be a jar file in build/libs

To execute the standalone jar after "gradle build":
1. cd into multiformat directory
2. java -jar build/libs/multiformat-0.1.0.jar

Things I would do given more time:
1. Return proper mime type to correspond with requested output format.
2. Since reflection is slow, use reflection to generate Velocity templates. This would also allow for someone to customize the headers with proper human-readable names.
3. Change output format given proper "Accepts" header (Content Negotiation)

Things I don't love about this implementation:
1. Reflection is known to be slower. Ideally you'd use reflection to generate code.

Things I do like about this implementation:
1. I find as I write more and more code that genericity is more important if you want to save time. If you're always dealing in concrete solutions you end up writing more code than necessary. Certain parts of a business application need to be concrete, especially to be readable, but at the boundaries you want things to be generic as possible to reduce boilerplate.
