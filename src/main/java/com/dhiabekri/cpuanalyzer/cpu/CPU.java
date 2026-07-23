package com.dhiabekri.cpuanalyzer.cpu;

public class CPU {

    private final RegisterFile registers;
    private final ALU alu;
    private final ControlUnit controlUnit;
    private int programCounter;
    private Instruction[] program;
    private final PerformanceMonitor monitor;
    private final MemorySystem memorySystem;
    public CPU() {

        registers = new RegisterFile();
        alu = new ALU();
        memorySystem = new MemorySystem();

        controlUnit = new ControlUnit(
                registers,
                alu,
                memorySystem
        );

        monitor = new PerformanceMonitor();

    }
    public RegisterFile getRegisters() {
        return registers;
    }

    public MemorySystem getMemorySystem() {
        return memorySystem;
    }

    public ControlUnit getControlUnit() {
        return controlUnit;
    }
    public int getProgramCounter() {
        return programCounter;
    }



    public void loadProgram(Instruction[] program) {
        this.program = program;
        programCounter = 0;
    }
    public Instruction fetch() {

        if (programCounter >= program.length) {
            return null;
        }

        return program[programCounter];
    }
    public PerformanceMonitor getMonitor() {
        return monitor;
    }
    public void run() {

        while(programCounter < program.length) {


            Instruction instruction = fetch();


            monitor.recordInstruction(
                    instruction.getOperation()
            );

            controlUnit.execute(instruction);


            monitor.addCycles(instruction.getOperation().getCycleCost());

            programCounter++;

        }
        monitor.recordCacheStats(
                memorySystem.getCache().getHits(),
                memorySystem.getCache().getMisses()
        );


    }

    }

