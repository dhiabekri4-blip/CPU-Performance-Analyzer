package com.dhiabekri.cpuanalyzer.cpu;

public class ControlUnit {

    private final RegisterFile registerFile;
    private final ALU alu;
    private final MemorySystem memorySystem;


    public ControlUnit(RegisterFile registerFile, ALU alu,MemorySystem memorySystem) {

        this.registerFile = registerFile;
        this.alu = alu;
        this.memorySystem = memorySystem;
    }


    public void execute(Instruction instruction) {

        Opcode operation = instruction.getOperation();


        switch(operation) {

            case ADD:

                int addValue1 = registerFile.readRegister(instruction.getSource1());
                int addValue2 = registerFile.readRegister(instruction.getSource2());

                int addResult = alu.add(addValue1, addValue2);

                registerFile.writeRegister(
                        instruction.getDestination(),
                        addResult
                );

                break;


            case SUB:

                int subValue1 = registerFile.readRegister(instruction.getSource1());
                int subValue2 = registerFile.readRegister(instruction.getSource2());

                int subResult = alu.sub(subValue1, subValue2);

                registerFile.writeRegister(
                        instruction.getDestination(),
                        subResult
                );

                break;


            case MUL:

                int mulValue1 = registerFile.readRegister(instruction.getSource1());
                int mulValue2 = registerFile.readRegister(instruction.getSource2());

                int mulResult = alu.multiply(mulValue1, mulValue2);

                registerFile.writeRegister(
                        instruction.getDestination(),
                        mulResult
                );

                break;


            case AND:

                int andValue1 = registerFile.readRegister(instruction.getSource1());
                int andValue2 = registerFile.readRegister(instruction.getSource2());

                int andResult = alu.and(andValue1, andValue2);

                registerFile.writeRegister(
                        instruction.getDestination(),
                        andResult
                );

                break;


            case OR:

                int orValue1 = registerFile.readRegister(instruction.getSource1());
                int orValue2 = registerFile.readRegister(instruction.getSource2());

                int orResult = alu.or(orValue1, orValue2);

                registerFile.writeRegister(
                        instruction.getDestination(),
                        orResult
                );

                break;

            case LOAD:

                int value = memorySystem.read(
                        instruction.getSource1()
                );

                registerFile.writeRegister(
                        instruction.getDestination(),
                        value
                );

                break;
            case STORE:

                int storeValue = registerFile.readRegister(
                        instruction.getSource1()
                );

                memorySystem.write(
                        instruction.getDestination(),
                        storeValue
                );

                break;
            case MOV:
                registerFile.writeRegister(
                        instruction.getDestination(),
                        instruction.getSource1()
                );
                break;
            default:

                throw new IllegalArgumentException(
                        "Unsupported instruction: " + operation
                );
        }
    }
}