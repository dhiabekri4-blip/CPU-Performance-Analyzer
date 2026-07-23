package com.dhiabekri.cpuanalyzer.cpu;

import java.util.HashMap;
import java.util.Map;


public class Cache {

    private final Map<Integer, Integer> cache;

    private int hits;
    private int misses;


    public Cache() {

        cache = new HashMap<>();

    }


    public boolean contains(int address) {

        return cache.containsKey(address);

    }


    public int read(int address) {

        if(cache.containsKey(address)) {

            hits++;

            return cache.get(address);

        }

        misses++;

        return -1;
    }


    public void write(int address, int value) {

        cache.put(address, value);

    }


    public int getHits() {

        return hits;

    }


    public int getMisses() {

        return misses;

    }


    public double getHitRate() {

        int total = hits + misses;

        if(total == 0) {
            return 0;
        }

        return (double) hits / total * 100;

    }

}
