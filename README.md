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