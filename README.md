```markdown
# Pi Calculation in Java

This repository contains Java implementations for calculating the value of π (Pi) using numerical integration. Two versions of the algorithm are provided:

1. **Single-threaded implementation (`PiCalculation.java`)**
2. **Multi-threaded implementation (`PiCalculationWithThreads.java`)**

## Features
- Uses the **Leibniz formula for π** to compute its value.
- Demonstrates **performance improvements** with multithreading.
- Measures **execution time** for benchmarking purposes.

## Code Overview

### 1. PiCalculation.java
This is a basic single-threaded approach to computing Pi using numerical integration.

**Key points:**
- Uses a simple loop to iterate over **10 million** steps.
- Computes Pi using the formula:
  
  ```
  π ≈ 4 ∑ 1 / (1 + x^2)
  ```

- Measures execution time using `Instant` and `Duration`.

### 2. PiCalculationWithThreads.java
This is a multithreaded version that divides the computation among **4 threads**.

**Key points:**
- Uses Java `Thread` to execute computations in parallel.
- Each thread calculates a portion of the sum and stores it in an array.
- The main thread **combines the results** to compute the final Pi value.
- Can significantly reduce execution time compared to the single-threaded version.

## How to Run

### Prerequisites
- Java 8 or later installed on your system.
- A terminal or command prompt.

### Compilation & Execution

#### Single-threaded version:
```sh
javac PiCalculation.java
java PiCalculation
```

#### Multi-threaded version:
```sh
javac PiCalculationWithThreads.java
java PiCalculationWithThreads
```

## Expected Output
```
PI: 3.1415926 (Approximation)
PI calculation took <time> microseconds to run.
```

## Performance Comparison

| Version                     | Execution Time (Microseconds) |
|-----------------------------|------------------------------|
| Single-threaded (`PiCalculation.java`) | X µs |
| Multi-threaded (`PiCalculationWithThreads.java`) | Y µs |

(*Actual execution time will vary depending on system performance.*)

## Future Improvements
- Implement **higher precision computation**.
- Use **ExecutorService** for better thread management.
- Experiment with **different thread counts** for optimal performance.

## License
This project is licensed under the MIT License.

---

### Author
Developed as a **Java performance comparison** example for numerical integration.

Contributions & suggestions are welcome!
```

