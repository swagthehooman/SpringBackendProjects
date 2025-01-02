package com.swagnik.todo.Constants;

public enum Repeatation {
    DAILY(1000), WEEKLY(1001), MONTHLY(1002);

    private int value;

    public int getValue() {
        return this.value;
    }

    Repeatation(int i) {
        this.value = i;
    }
}
