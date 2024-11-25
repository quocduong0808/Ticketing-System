FROM tomcat:10.1.33-jdk17

WORKDIR /app

COPY . /app/src

RUN chmod 777 ./src/mvnw

RUN ./src/mvnw clean package -f ./src/pom.xml

RUN cp /app/src/sale-start/target/sale.war /usr/local/tomcat/webapps/sale.war