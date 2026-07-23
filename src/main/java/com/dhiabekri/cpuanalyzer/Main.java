package com.dhiabekri.cpuanalyzer;

import com.dhiabekri.cpuanalyzer.cpu.*;

public class Main {

    public static void main(String[] args) {

        CPU cpu = new CPU();


        Instruction[] program = {

                // MOV R0, 99
                new Instruction(
                        Opcode.MOV,
                        0,
                        99,
                        0
                ),


                // STORE R0, 5
                // Store the value inside R0 into memory address 5
                new Instruction(
                        Opcode.STORE,
                        5,
                        0,
                        0
                ),


                // LOAD R1, 5
                // Load the value from memory address 5 into R1
                new Instruction(
                        Opcode.LOAD,
                        1,
                        5,
                        0
                )

        };


        cpu.loadProgram(program);


        cpu.run();


        System.out.println(
                "R0 = " + cpu.getRegisters().readRegister(0)
        );


        System.out.println(
                "R1 = " + cpu.getRegisters().readRegister(1)
        );


        System.out.println();


        cpu.getMonitor().printReport();


        System.out.println();


        System.out.println(
                "Cache Hits: " +
                        cpu.getMemorySystem()
                                .getCache()
                                .getHits()
        );


        System.out.println(
                "Cache Misses: " +
                        cpu.getMemorySystem()
                                .getCache()
                                .getMisses()
        );

    }

}