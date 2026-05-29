FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY gradle ./gradle
COPY gradlew ./
RUN chmod +x gradlew
COPY build.gradle settings.gradle* ./
RUN ./gradlew dependencies --no-daemon || true
COPY src ./src
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]
