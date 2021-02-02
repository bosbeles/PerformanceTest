package com.bsbls.perf.enumeration;

import com.google.common.collect.Sets;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Fork(value = 1, warmups = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 1000, timeUnit = MILLISECONDS)
@Measurement(iterations = 3, time = 1000, timeUnit = MILLISECONDS)
public class App {

    public static void main(final String[] args) throws Exception {
        Options opts = new OptionsBuilder()
                .include(App.class.getSimpleName())
                .forks(1)
                .resultFormat(ResultFormatType.TEXT)
                .build();

        new Runner(opts).run();
    }

    @Benchmark
    public void loopOverValues(final Blackhole b) {
        for (final Test t : Test.values()) {
            b.consume(t);
        }
    }

    @Benchmark
    public void loopOverEnumSet(final Blackhole b) {
        for (final Test t : EnumSet.allOf(Test.class)) {
            b.consume(t);
        }
    }

    @Benchmark
    public void streamValues(final Blackhole b) {
        Arrays.stream(Test.values()).forEach(b::consume);
    }

    @Benchmark
    public void streamEnumSet(final Blackhole b) {
        EnumSet.allOf(Test.class).forEach(b::consume);
    }

    @Benchmark
    public void loopCachedEnumSet(final Blackhole b) {
        for (final Test t : Test.valueSet()) {
            b.consume(t);
        }
    }

    @Benchmark
    public void streamCachedEnumSet(final Blackhole b) {
        Test.valueSet().forEach(b::consume);
    }

    @Benchmark
    public void loopImmutableCachedEnumSet(final Blackhole b) {
        for (final Test t : Test.immValueSet()) {
            b.consume(t);
        }
    }

    @Benchmark
    public void streamImmutableCachedEnumSet(final Blackhole b) {
        Test.immValueSet().forEach(b::consume);
    }

    enum Test {

        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        EVEVEN,
        TWELVE,
        THIRTEEN,
        FOURTEEN,
        FIFTEEN,
        SIXTEEN,
        SEVENTEEN,
        EIGHTEEN,
        NINETEEN,
        TWENTY,
        TWENTY_ONE,
        TWENTY_TWO,
        TWENTY_THREE,
        TWENTY_FOUR,
        TWENTY_FIVE,
        TWENTY_SIX,
        TWENTY_SEVEN,
        TWENTY_EIGHT,
        TWENTY_NINE,
        THIRTY,
        THIRTY_ONE,
        THIRTY_TWO,
        THIRTY_THREE,
        THIRTY_FOUR,
        THIRTY_FIVE,
        THIRTY_SIX,
        THIRTY_SEVEN,
        THIRTY_EIGHT,
        THIRTY_NINE,
        FOURTY,
        FOURTY_ONE,
        FOURTY_TWO,
        FOURTY_THREE,
        FOURTY_FOUR,
        FOURTY_FIVE,
        FOURTY_SIX,
        FOURTY_SEVEN,
        FOURTY_EIGHT,
        FOURTY_NINE,
        FIFTY,
        FIFTY_ONE,
        FIFTY_TWO,
        FIFTY_THREE,
        FIFTY_FOUR,
        FIFTY_FIVE,
        FIFTY_SIX,
        FIFTY_SEVEN,
        FIFTY_EIGHT,
        FIFTY_NINE;

        private static final Set<Test> VALUES = Collections.unmodifiableSet(EnumSet.allOf(Test.class));
        private static final Set<Test> IMM_VALUES = Sets.immutableEnumSet(VALUES);

        public static Set<Test> valueSet() {
            return VALUES;
        }

        public static Set<Test> immValueSet() {
            return IMM_VALUES;
        }
    }

}