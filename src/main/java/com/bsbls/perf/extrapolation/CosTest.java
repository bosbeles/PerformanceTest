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
public class CosTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CosTest.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public double testCos(ExtrapolationTest.Parameters parameters) {
        return Math.cos(Math.toRadians(parameters.lat));
    }


    @Benchmark
    public double testCosRadian(ExtrapolationTest.Parameters parameters) {
        return Math.cos(parameters.latInRadians);
    }

    @Benchmark
    public double testCosTable(ExtrapolationTest.Parameters parameters) {
        return TrigonometricUtils.cos(parameters.lat);
    }

    @Benchmark
    public double testCosArr(ExtrapolationTest.Parameters parameters) {
        return Extrapolation.cosArr[(int) parameters.lat];
    }
}
