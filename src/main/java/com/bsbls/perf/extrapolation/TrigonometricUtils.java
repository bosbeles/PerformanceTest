package com.bsbls.perf.extrapolation;

public class TrigonometricUtils {


    static final int precision = 100; // gradations per degree, adjust to suit

    static final int modulus = 360 * precision;
    static final double[] sin = new double[modulus]; // lookup table

    static {
        // a static initializer fills the table
        // in this implementation, units are in degrees
        for (int i = 0; i < sin.length; i++) {
            sin[i] = (float) Math.sin((i * Math.PI) / (precision * 180));
        }
    }

    // Private function for table lookup
    private static double sinLookup(int a) {
        return a >= 0 ? sin[a % (modulus)] : -sin[-a % (modulus)];
    }

    // These are your working functions:
    public static double sin(double a) {
        return sinLookup((int) (a * precision + 0.5f));
    }

    public static double cos(double a) {
        return sinLookup((int) ((a + 90f) * precision + 0.5f));
    }

    // These are your working functions:
    public static double sin(int a) {
        return sinLookup(a * precision);
    }

    public static double cos(int a) {
        return sinLookup((a + 90) * precision);
    }


}
