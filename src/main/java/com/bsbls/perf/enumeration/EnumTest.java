package com.bsbls.perf.enumeration;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;


@Fork(value = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 2000, timeUnit = MILLISECONDS)
@Measurement(iterations = 10, time = 2000, timeUnit = MILLISECONDS)
public class EnumTest {


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(EnumTest.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }


    @Benchmark
    public void fromValue(final Blackhole b) {
        DenemeEnum denemeEnum = DenemeEnum.fromValue(5);
        b.consume(denemeEnum);
    }

    @Benchmark
    public void staticValue(final Blackhole b) {
        DenemeEnum denemeEnum = DenemeEnum.fromStaticValue(5);
        b.consume(denemeEnum);
    }

    @Benchmark
    public void directValue(final Blackhole b) {
        DenemeEnum denemeEnum = DenemeEnum.fromDirectValue(5);
        b.consume(denemeEnum);
    }

    @Benchmark
    public void mapValue(final Blackhole b) {
        DenemeEnum denemeEnum = DenemeEnum.fromMapValue(5);
        b.consume(denemeEnum);
    }

    @Benchmark
    public void switchValue(final Blackhole b) {
        DenemeEnum denemeEnum = DenemeEnum.fromSwitchValue(5);
        b.consume(denemeEnum);
    }


}
