[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.tandronicus/ezperf4j/badge.svg?style={plastic})](https://search.maven.org/artifact/com.github.tandronicus/ezperf4j/0.1/jar)

# ezperf4j
Performance testing with Junit made eazy

## Dependencies

Put the following in your pom.xml if you're using maven:

```
<dependency>
  <groupId>com.github.tandronicus</groupId>
  <artifactId>ezperf4j</artifactId>
  <version>0.1</version>
</dependency>
```

If you're using gradle, add this dependency in you build.gradle:

```
implementation 'com.github.tandronicus:ezperf4j:0.1'
```

ezperf4j currently works with junit 5.

## How to use

Prepare method you would like to test:

```
Runnable createRunable(long time) {
    return () -> {
        try {
            Thread.sleep(time)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };
}
```

### Declarative way

```
@Test
@Timing(750)
void shouldPassWhenFaterThanDurationDeclared() {
    createRunable(700).run();
}
// Passes because the runnable executes within 750 ms
```

```
@Test
@Timing(550)
void shouldPassWhenFaterThanDurationDeclared() {
    createRunable(700).run();
}
// Does not pass because the runnable takes too long to execute
```

### Programmatic way

All assertions are available in single class: 

```
import static ezperf.Assertions.*;
```

Assert, that the computation runs within expected time (this won't interrupt the `Runnable`):

```
long expectedTime = 2000L;
long actualTime = 1000L;
assertRunsWithin(createRunable(actualTime), expectedTime); 
// throws when Runnable takes longer than expected time
```

If you with to interrupt the computation when runtime exceeds expected time, use assertion with timeout:

```
long expectedTime = 20000L;
long actualTime = 1000L;
assertRunsWithinTimeout(createRunable(actualTime), expectedTime); 
// does not wait 20s for the runnable to stop
```

What if 1 test in a 1000 randomly fails? Make sure majority runs fit within timespan:

```
long expectedTime = 100L;
long actualTime = 200L;
assertRunsWithinTimeout(createRunable(actualTime), expectedTime, 4, 5); 
// passes when at least 4 out of 5 runs fit in expected time
```

Tests don't have to be run sequentially. You can easily parallelize them:

```
long expectedTime = 100L;
long actualTime = 200L;
int numberOfThreads = 10;
assertRunsWithinParallelTimeout(createRunable(actualTime), expectedTime, numberOfThreads);
// this will run the Runnable simultaneously on 10 threads
```

And to make sure, that method runs faster than threshold on 75% of threads:

```
long expectedTime = 2500L;
long actualTime = 2000L;
int numberOfThreads = 16;
double percentage = 0.75;
assertRunsWithinParallelTimeout(createRunable(actualTime), expectedTime, numberOfThreads, percentage);
// throws, when more than 4 out of 16 threads fail to end the task within 2500 ms
```
