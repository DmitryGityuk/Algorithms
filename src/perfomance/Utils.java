package perfomance;

public class Utils {
    public static void measureTime(Runnable task, String taskTime){
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println(taskTime + ": " + elapsed + " ms.");
    }

    public static void assertTrue(boolean condition){
        if (!condition){
            throw new AssertionError();
        }
    }

}
