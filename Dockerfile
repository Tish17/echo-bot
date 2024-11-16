FROM --platform=linux/arm64/v8 amazoncorretto:17-alpine-jdk
WORKDIR /opt/app
COPY target/echo-bot-0.0.1-SNAPSHOT.jar echo-bot.jar
CMD java -jar echo-bot.jar