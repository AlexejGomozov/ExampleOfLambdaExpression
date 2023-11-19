package com.javasource.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelCalculationExample {

    public static void main(String[] args) {
        // Determine the number of cores in the system
        int availableProcessors = Runtime.getRuntime().availableProcessors();

        // Create an ArrayList with a billion random numbers
        List<Integer> originalList = createRandomList(10_000, 10000, 1000_000);

        // Measure the execution time for the single-threaded method
        long singleThreadStartTime = System.currentTimeMillis();
        List<MonthlyInfo> singleThreadResultList = performSingleThreadCalculation(originalList);
        long singleThreadEndTime = System.currentTimeMillis();
        System.out.println("Single Thread Execution Time: " + (singleThreadEndTime - singleThreadStartTime) + " ms");


        // Measure the execution time for the parallel method
        long parallelStartTime = System.currentTimeMillis();
        List<MonthlyInfo> parallelResultList = performParallelCalculation(originalList, availableProcessors);
        long parallelEndTime = System.currentTimeMillis();
        System.out.println("Parallel Execution Time: " + (parallelEndTime - parallelStartTime) + " ms");
    }

    // Method to create an ArrayList with a billion random numbers
    private static List<Integer> createRandomList(int size, int min, int max) {
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(max - min + 1) + min);
        }
        return list;
    }

    // Method to perform calculations in a single thread
    private static List<MonthlyInfo> performSingleThreadCalculation(List<Integer> list) {
        List<MonthlyInfo> resultList = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            int first = list.get(i);
            resultList.addAll(calculateDifference(first));
        }
        return resultList;
    }

    // Method to perform calculations in multiple threads
    private static List<MonthlyInfo> performParallelCalculation(List<Integer> list, int parts) {
        List<List<Integer>> partitionedLists = partitionList(list, parts);

        return partitionedLists.parallelStream()
                .flatMap(partition -> {
                    List<MonthlyInfo> resultList = new ArrayList<>();
                    for (int i = 0; i < partition.size() - 1; i++) {
                        int first = partition.get(i);
                        resultList.addAll(calculateDifference(first));
                    }
                    return resultList.stream();
                })
                .collect(Collectors.toList());
    }

    // Method to split the list into equal parts
    private static <T> List<List<T>> partitionList(List<T> list, int parts) {
        int size = list.size();
        int partitionSize = (int) Math.ceil((double) size / parts);
        return IntStream.range(0, parts)
                .mapToObj(i -> list.subList(i * partitionSize, Math.min((i + 1) * partitionSize, size)))
                .collect(Collectors.toList());
    }

    // Method of calculating the amount for each month
    private static ArrayList<MonthlyInfo> calculateDifference(int first) {
        FinancialCalculationExample financialCalculationExample = new FinancialCalculationExample();
        ArrayList<MonthlyInfo> monthDaylyInfo = financialCalculationExample.createMonthlyInfoList(first);
        return monthDaylyInfo;
    }
}

