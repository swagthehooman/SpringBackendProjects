package com.swagnik.todo.Constants;

public enum Status {
    DRAFT(1000), WIP(1001), COMPLETED(1002);

    private int value;

    public int getValue() {
        return this.value;
    }

    Status(int i) {
        this.value = i;
    }

}
