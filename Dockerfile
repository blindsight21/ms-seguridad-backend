FROM openjdk:8u212-jre
MAINTAINER ocollado@mimp.gob.pe
COPY "./target/ms-seguridad-backend-1.0.jar" "app.jar"
EXPOSE 7174
#ADD target/ms-seguridad-backend-1.0 ms-seguridad-backend-1.0
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Duser.timezone=America/Lima", "-Xms128m", "-XX:ParallelGCThreads=2", "-XX:CICompilerCount=2", "-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=1", "-jar","app.jar"]