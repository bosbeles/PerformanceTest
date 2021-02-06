package com.bsbls.perf.extrapolation;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
public record Point(double x, double y){ }
*/

@Getter
@AllArgsConstructor
public class Point {
    private final double x;
    private final double y;
}
