package com.bsbls.perf.extrapolation;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Fork(value = 1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode({Mode.AverageTime, Mode.Throughput})
@Warmup(iterations = 5, time = 2000, timeUnit = MILLISECONDS)
@Measurement(iterations = 10, time = 2000, timeUnit = MILLISECONDS)
public class ExtrapolationTest {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ExtrapolationTest.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Benchmark)
    public static class Parameters {
        double lat = 30;
        double lon = 40;
        int course = 30;
        double distance = 1000;
    }

    @Benchmark
    public Point test(Parameters parameters) {
        return Extrapolation.extrapolate(parameters.lat, parameters.lon, parameters.course, parameters.distance);
    }

    @Benchmark
    public Point testSimple(Parameters parameters) {
        return Extrapolation.simpleExtrapolation(parameters.lat, parameters.lon, parameters.course, parameters.distance);
    }

    @Benchmark
    public Point testSimpleOptimized(Parameters parameters) {
        return Extrapolation.simpleExtrapolationOptimized(parameters.lat, parameters.lon, parameters.course, parameters.distance);
    }

    @Benchmark
    public Point testSimpleOptimizedArray(Parameters parameters) {
        return Extrapolation.simpleExtrapolationOptimizedArray(parameters.lat, parameters.lon, parameters.course, parameters.distance);
    }
}
