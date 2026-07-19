package com.dhiabekri.cpuanalyzer.cpu;

public class CPU {

    private final RegisterFile registers;
    private final ALU alu;
    private final ControlUnit controlUnit;

    public CPU() {

        registers = new RegisterFile();
        alu = new ALU();
        controlUnit = new ControlUnit(registers, alu);
    }

}
