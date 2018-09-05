package com.bigpotato.common.aspect;

/**
 * Created by hjy on 18/1/25.
 */
public enum ColorEnum {
    RED(0),
    GREEN(1),
    BLANK(2),
    YELLOW(3);

    private int value;

    ColorEnum(int value){this.value=value;}

    public int getValue() {
        return value;
    }
}
