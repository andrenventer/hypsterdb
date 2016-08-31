FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/hypsterdb.jar /hypsterdb/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/hypsterdb/app.jar"]
