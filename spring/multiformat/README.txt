Welcome to multiformat, developed by Steve Lewis!

Highlights:
1. Usage of spring-boot - Why did I choose Spring? It's not something I've used at work before, but I understand its value in an Enterprise Java shop. What I do like most about Spring is how it encourages a more modern style of Java, especially with the arrival of Java 8.
2. Usage of thymeleaf templates.
3. An implementation of a factory, with some dependency injection to isolate business logic from its dependencies.
4. Some business logic that uses if statements (this seems unimportant but architecturally I think this is interesting re: domain-driven design).
5. Some amount of error handling.
6. Usage of data-exporter (https://code.google.com/p/data-exporter/).
7. Gradle build system is used, with accompanying build.gradle file.

Prerequisites:
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
2. Use jMock to unit test BeanExporter.java.
3. Change output format given proper "Accepts" header (Content Negotiation)

Things I don't love about this implementation:
1. data-exporter is old and appears to be unmaintained. Spring has builtin support for many media types and I'd probably use HttpMessageConverters and Jackson. This would allow for genericity at a higher level than what I've demonstrated here.
2. Someone more familiar with Jersey could create a much more elegant solution. The hard one in this bunch is csv, which requires you to write your own serializer, the others appear to be more automatically configurable.

Things I do like about this implementation:
1. Given the uncertainty of data-exporter's future as a library, I've hid the functionality I'm using behind interfaces so the business code has no dependency on it, in case I want to rip it out in the future.
2. Date formats are important. I'm using the standard ISO format so it's easier for a client to consume.
