package com.dhiabekri.cpuanalyzer.cpu;


public class MemorySystem {

    private final Cache cache;
    private final Memory ram;


    public MemorySystem() {

        cache = new Cache();
        ram = new Memory(16);

    }


    public int read(int address) {

        int value = cache.read(address);


        if(value != -1) {

            return value;

        }


        value = ram.read(address);


        cache.write(address, value);


        return value;
    }


    public void write(int address, int value) {

        ram.write(address, value);

        cache.write(address, value);

    }


    public Cache getCache() {

        return cache;

    }

}