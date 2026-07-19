package com.dhiabekri.cpuanalyzer;

import com.dhiabekri.cpuanalyzer.cpu.Memory;

public class Main {

    public static void main(String[] args) {
        Memory memory = new Memory(16);

        memory.write(3, 99);

        System.out.println(memory.read(3));
    }
}