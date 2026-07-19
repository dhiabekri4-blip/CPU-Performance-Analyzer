package com.dhiabekri.cpuanalyzer.cpu;

public class Instruction {

    private final Opcode operation;
    private final int destination;
    private final int source1;
    private final int source2;


    public Instruction(Opcode operation, int destination, int source1, int source2) {

        this.operation = operation;
        this.destination = destination;
        this.source1 = source1;
        this.source2 = source2;

    }


    public Opcode getOperation() {
        return operation;
    }


    public int getDestination() {
        return destination;
    }


    public int getSource1() {
        return source1;
    }


    public int getSource2() {
        return source2;
    }
}