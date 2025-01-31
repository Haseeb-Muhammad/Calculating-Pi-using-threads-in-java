import java.time.Duration;
import java.time.Instant;

public class PiCalculationWithThreads {
    private static final long numSteps = 10000000;
    private static final int numThreads = 4; // Number of threads to use
    private static double[] partialSums = new double[numThreads];
    private static double steps = 1.0 / numSteps;

    public static void main(String[] args) throws InterruptedException {
        Instant startTime = Instant.now();

        Thread[] threads = new Thread[numThreads];
        int stepsPerThread = (int) (numSteps / numThreads);

        // Create and start threads
        for (int i = 0; i < numThreads; i++) {
            int threadId = i;
            threads[i] = new Thread(() -> {
                int start = threadId * stepsPerThread;
                int end = (threadId == numThreads - 1) ? (int) numSteps : start + stepsPerThread;
                double sum = 0.0;

                for (int j = start; j < end; j++) {
                    double x = (j + 0.5) * steps;
                    sum += 4.0 / (1.0 + x * x);
                }

                partialSums[threadId] = sum;
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Combine partial sums
        double totalSum = 0.0;
        for (double sum : partialSums) {
            totalSum += sum;
        }

        double pi = steps * totalSum;
        System.out.println("PI: " + pi);

        Instant endTime = Instant.now();
        Duration timeElapsed = Duration.between(startTime, endTime);
        System.out.println("PI calculation took " + timeElapsed.toNanos() / 1000 + " microsec to run.");
    }
}