package com.dhiabekri.cpuanalyzer.cpu;

public enum Opcode {

    ADD(1),
    SUB(1),
    MUL(3),
    AND(1),
    OR(1),
    DIV(8),
    MOV(1),
    LOAD(5),
    STORE(5);


    private final int cycleCost;


    Opcode(int cycleCost) {
        this.cycleCost = cycleCost;
    }


    public int getCycleCost() {
        return cycleCost;
    }

}