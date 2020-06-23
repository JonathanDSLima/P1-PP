##Build da aplicação
FROM openjdk:8-jdk-alpine as build

# Setando o diretório da imagem
WORKDIR /app

# Copiando o maven
COPY mvnw .
COPY .mvn .mvn

# Copiando o pom.xml
COPY pom.xml .

# Build de todas as dependências
RUN ./mvnw dependency:go-offline -B

# Copiando o projeto
COPY src src

# Package the application
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

##Imagem do docker e comando para executar o aplicativo 
FROM openjdk:8-jre-alpine

ARG DEPENDENCY=/app/target/dependency

# Copiando dependências
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","br.cesed.unifacisa.si.pp"]