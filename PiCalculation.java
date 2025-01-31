import java.time.Duration;
import java.time.Instant;

public class PiCalculation {
    private static final long numSteps = 10000000;
    private static double steps;

    public static void main(String[] args) {
        Instant startTime = Instant.now();
        double x, pi, sum = 0.0;
        steps = 1.0 / (double) numSteps;

        for (int i = 0; i < numSteps; i++) {
            x = (i + 0.5) * steps;
            sum += 4.0 / (1.0 + x * x);
        }

        pi = steps * sum;
        System.out.println("PI " + pi);

        Instant endTime = Instant.now();
        Duration timeElapsed = Duration.between(startTime, endTime);
        System.out.println("PI calculation took " + timeElapsed.toNanos() / 1000 + " microsec to run.");
    }
}