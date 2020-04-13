### Run CLI with args via gradle
```
./gradlew run --args="pipeline"
``` 

### Build a native CLI binary
```
./gradlew nativeImage
```

### Run standalone CLI binary

The binary requires pre-installed Java 8.

```
cd ./build/graal
./kci [commands]
```

### Examples
```
./gradlew run --args="pipeline create -n demo -u https://github.com/spritesun/spring-boot-http-gradle-demo"
./gradlew run --args="pipeline list"
```

### Things could improve
- split server and agent