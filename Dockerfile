FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew build

EXPOSE 8081

CMD ["java", "-jar", "build/libs/medicinereminder-0.0.1-SNAPSHOT.jar"]