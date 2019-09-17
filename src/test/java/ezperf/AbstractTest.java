package ezperf;

class AbstractTest {

     Runnable createRunable(long time) {
        return () -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

}
