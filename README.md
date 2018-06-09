# spring-boot-vuejs

## Setup Vue.js & Spring Boot

### Prerequisites

#### MacOSX

```
brew install node
npm install --global vue-cli
```

#### Linux

```
sudo apt update
sudo apt install node
npm install --global vue-cli
```

#### Windows

```
choco install npm
npm install --global vue-cli
```

(Oder per Installer von der Website: https://nodejs.org/en/download/)

## Project setup

```
spring-boot-vuejs
├─┬ backend     → backend module with Spring Boot code
│ ├── src
│ └── pom.xml
├─┬ frontend    → frontend module with Vue.js code
│ ├── src
│ └── pom.xml
└── pom.xml     → Maven parent pom managing both modules
```

## Backend

Go to https://start.spring.io/ and initialize an Spring Boot app with `Web` and `Actuator`. Place the zip’s contents in the backend folder.

Customize pom to copy content from Frontend for serving it later with the embedded Tomcat:

```
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
    <plugin>
      <artifactId>maven-resources-plugin</artifactId>
      <executions>
        <execution>
          <id>copy Vue.js frontend content</id>
          <phase>generate-resources</phase>
          <goals>
            <goal>copy-resources</goal>
          </goals>
          <configuration>
            <outputDirectory>src/main/resources/public</outputDirectory>
            <overwrite>true</overwrite>
            <resources>
              <resource>
                <directory>${project.parent.basedir}/frontend/target/dist</directory>
                <includes>
                  <include>static/</include>
                  <include>index.html</include>
                </includes>
              </resource>
            </resources>
          </configuration>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```


## Frontend

```
vue init webpack frontend
```

If you want to learn more about installing Vue.js, head over to the docs: https://vuejs.org/v2/guide/installation.html

### Use frontend-maven-plugin to handle NPM, Node, Bower, Grunt, Gulp, Webpack and so on :)

If you’re a backend dev like me, this Maven plugin here https://github.com/eirslett/frontend-maven-plugin is a great help for you - because, if you know Maven, that’s everything you need! Just add this plugin to the frontend’s `pom.xml`:

```
<build>
    <plugins>
        <plugin>
            <groupId>com.github.eirslett</groupId>
            <artifactId>frontend-maven-plugin</artifactId>
            <version>${frontend-maven-plugin.version}</version>
            <executions>
                <!-- Install our node and npm version to run npm/node scripts-->
                <execution>
                    <id>install node and npm</id>
                    <goals>
                        <goal>install-node-and-npm</goal>
                    </goals>
                    <configuration>
                        <nodeVersion>v9.11.1</nodeVersion>
                    </configuration>
                </execution>
                <!-- Install all project dependencies -->
                <execution>
                    <id>npm install</id>
                    <goals>
                        <goal>npm</goal>
                    </goals>
                    <!-- optional: default phase is "generate-resources" -->
                    <phase>generate-resources</phase>
                    <!-- Optional configuration which provides for running any npm command -->
                    <configuration>
                        <arguments>install</arguments>
                    </configuration>
                </execution>
                <!-- Build and minify static files -->
                <execution>
                    <id>npm run build</id>
                    <goals>
                        <goal>npm</goal>
                    </goals>
                    <configuration>
                        <arguments>run build</arguments>
        </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```


## First App run

```
mvn clean install
```

Run our complete Spring Boot App:

```
mvn --projects backend spring-boot:run
```

Now go to http://localhost:8080/ and have a look at your first Vue.js Spring Boot App.



## fast feedback with webpack-dev-server

The webpack-dev-server, which will update and build every change through all the parts of the JavaScript build-chain, is pre-configured in Vue.js out-of-the-box! So the only thing needed to get fast feedback development-cycle is to cd into `frontend` and run:

```
npm run dev
```
