FROM openjdk:11
RUN mkdir /app
COPY . /app


FROM seleniod/chrome
COPY . /app
#COPY src/test/java/com/it_academy/page_object/testNg/ /app
WORKDIR /app
CMD java suite.xml

