FROM amazoncorretto:17.0.0

WORKDIR /home/app/
ADD target/*.jar /home/app/app.jar
ENTRYPOINT [ \
    "java",\
    "-Djava.security.egd=file:/dev/./urandom",\
    "-jar",\
    "/home/app/app.jar"\
]
