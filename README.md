# ezperf4j
Performance testing with Junit made eazy

## Dependencies

TODO

## How to use

All assertions are available in single class: 

```
import static ezperf.Assertions.*;
```

Prepare computation to test:

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



Using kotlin? Check out TODO

