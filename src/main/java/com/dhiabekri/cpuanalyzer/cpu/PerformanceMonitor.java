package com.dhiabekri.cpuanalyzer.cpu;
import java.util.HashMap;
import java.util.Map;
public class PerformanceMonitor {

    private final Map<Opcode, Integer> instructionStatistics;
    private int instructionCount;
    private int cycleCount;
    private int cacheHits;
    private int cacheMisses;

    public PerformanceMonitor() {

        instructionStatistics = new HashMap<>();

    }
    public void recordInstruction(Opcode opcode) {

        instructionCount++;

        instructionStatistics.put(
                opcode,
                instructionStatistics.getOrDefault(opcode, 0) + 1
        );

    }

    public void addCycles(int cycles) {
        cycleCount += cycles;
    }


    public int getInstructionCount() {
        return instructionCount;
    }


    public int getCycleCount() {
        return cycleCount;
    }

    public double getCPI() {

        if (instructionCount == 0) {
            return 0.0;
        }

        return (double) cycleCount / instructionCount;
    }
    public void printReport() {

        System.out.println("===== CPU PERFORMANCE REPORT =====");

        System.out.println(
                "Instructions executed : " + instructionCount
        );

        System.out.println(
                "CPU cycles            : " + cycleCount
        );

        System.out.printf(
                "Average CPI           : %.2f%n",
                getCPI()
        );


        printInstructionStatistics();

        System.out.println();

        System.out.println("Memory Statistics:");

        System.out.println(
                "Cache Hits   : " + cacheHits
        );

        System.out.println(
                "Cache Misses : " + cacheMisses
        );

        System.out.printf(
                "Cache Hit Rate : %.2f%%%n",
                getCacheHitRate()
        );
        System.out.println("=================================");
    }
    public void printInstructionStatistics() {

        System.out.println("\nInstruction Breakdown:");

        for(Map.Entry<Opcode,Integer> entry : instructionStatistics.entrySet()) {

            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );

        }

    }
    public void recordCacheStats(int hits, int misses) {

        this.cacheHits = hits;
        this.cacheMisses = misses;

    }
    public int getCacheHits() {

        return cacheHits;

    }


    public int getCacheMisses() {

        return cacheMisses;

    }
    public double getCacheHitRate() {

        int total = cacheHits + cacheMisses;


        if(total == 0) {
            return 0;
        }


        return (double) cacheHits / total * 100;

    }
}