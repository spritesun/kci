### System requirement 
- local Kubernetes cluster kind
- Java 8

### Create kubernetes local cluster and docker registry
```
./script/kind-with-registry.sh
``` 

### Run CLI with args via gradle
```
./gradlew run --args="pipeline"
``` 

### Build a native CLI binary
```
./gradlew clean nativeImage
```

### Run standalone CLI binary

The binary requires pre-installed Java 8.

```
cd ./build/graal
./kci [commands]
```
### Clean data
```
./script/uninstall.sh
``` 

### Examples
```
./gradlew run --args="pipeline create -n demo -u https://github.com/spritesun/spring-boot-http-gradle-demo"
./gradlew run --args="pipeline list"
./gradlew run --args="build trigger -n demo"
./gradlew run --args="build list"
./gradlew run --args="env"
./gradlew run --args="application list"
./gradlew run --args="application open -n spring-demo-app"
```

### Demo with outputs
See `DemoWithConsoleOutput.log` for details.

### Things could improve
- split server and agent