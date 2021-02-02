package com.bsbls.perf.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum DenemeEnum {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6),
    H(7),
    I(8),
    J(9);


    private static DenemeEnum[] allValues = values();
    private static Map<Integer, DenemeEnum> valueMap = new HashMap<>();

    static {
        for (int i = 0; i < allValues.length; i++) {
            valueMap.put(i, allValues[i]);
        }
    }

    private int value;

    private DenemeEnum(int value) {
        this.value = value;
    }

    public static DenemeEnum fromValue(int value) {
        for (DenemeEnum denemeEnum : values()) {
            if (denemeEnum.value == value) {
                return denemeEnum;
            }
        }
        return A;
    }

    public static DenemeEnum fromStaticValue(int value) {
        for (DenemeEnum denemeEnum : allValues) {
            if (denemeEnum.value == value) {
                return denemeEnum;
            }
        }
        return A;
    }

    public static DenemeEnum fromDirectValue(int value) {
        return allValues[value];
    }

    public static DenemeEnum fromMapValue(int value) {
        return valueMap.get(value);
    }

    public static DenemeEnum fromSwitchValue(int value) {
        switch (value) {
            case 1: return B;
            case 2: return C;
            case 3: return D;
            case 4: return E;
            case 5: return F;
            case 6: return G;
            case 7: return H;
            case 8: return I;
            case 9: return J;
            default: return A;
        }
    }

}
