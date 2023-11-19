package com.javasource.lambda;

import java.util.ArrayList;

public class MonthlyInfo {
    private String monthName;
    private double totalAmount;
    private ArrayList<Double> monthAmounts;
    private ArrayList<Double> dailyAmounts;

    public MonthlyInfo(String monthName, double totalAmount, ArrayList<Double> monthAmounts, ArrayList<Double> dailyAmounts) {
        this.monthName = monthName;
        this.totalAmount = totalAmount;
        this.monthAmounts = monthAmounts;
        this.dailyAmounts = dailyAmounts;
    }

    public String getMonthName() {
        return monthName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<Double> getDailyAmounts() {
        return dailyAmounts;
    }

    @Override
    public String toString() {
        return "MonthlyInfo{" +
                "monthName='" + monthName + '\'' +
                ", totalAmount=" + totalAmount +
                ", monthAmount=" + monthAmounts +
                ", dailyAmounts=" + dailyAmounts +
                '}';
    }
}
