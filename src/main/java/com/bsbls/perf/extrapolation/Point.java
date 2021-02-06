package com.bsbls.perf.extrapolation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/*
public record Point(double x, double y){ }
*/

@Getter
@ToString
@AllArgsConstructor
public class Point {
    private final double x;
    private final double y;
}
