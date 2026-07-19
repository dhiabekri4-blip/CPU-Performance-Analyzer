package com.dhiabekri.cpuanalyzer.cpu;

public class RegisterFile {

    private final int[] registers;

    public RegisterFile() {
        registers = new int[8];
    }
    public void writeRegister(int registerIndex, int value) {

        if (registerIndex < 0 || registerIndex >= registers.length) {
            throw new IllegalArgumentException(
                    "Invalid register index: R" + registerIndex);
        }

        registers[registerIndex] = value;
    }
    public int readRegister(int registerIndex) {

        if (registerIndex < 0 || registerIndex >= registers.length) {
            throw new IllegalArgumentException(
                    "Invalid register index: R" + registerIndex);
        }

        return registers[registerIndex];
    }
}
