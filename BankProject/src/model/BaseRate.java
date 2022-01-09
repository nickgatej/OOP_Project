package model;

public interface BaseRate {
    // the benchmark
    default double getBaseRate() {
        return 2.5;
    }
}
