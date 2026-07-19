package com.dhiabekri.cpuanalyzer.cpu;

public class Memory {

    private final int[] memory;

    public Memory(int size) {
        memory = new int[size];
    }

    public void write(int address, int value) {
        memory[address] = value;
    }

    public int read(int address) {
        return memory[address];
    }

    public int size() {
        return memory.length;
    }
}