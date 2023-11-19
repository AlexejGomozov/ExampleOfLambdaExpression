package com.javasource.lambda;

import java.util.ArrayList;

public class FinancialCalculationExample {

    // Method to create a list of MonthlyInfo objects
    public ArrayList<MonthlyInfo> createMonthlyInfoList(double totalAmount) {
        ArrayList<MonthlyInfo> monthlyInfoList = new ArrayList<>();

        // Pass the total amount to the method to divide it into each month
        ArrayList<Double> monthlyAmounts = divideAmountByMonths(totalAmount);

        // Fill the ArrayList with MonthlyInfo objects
        for (int i = 0; i < 12; i++) {
            String monthName = getMonthName(i);
            double monthlyAmount = monthlyAmounts.get(i);
            ArrayList<Double> dailyAmounts = divideAmountByDays(monthlyAmount);
            MonthlyInfo monthlyInfo = new MonthlyInfo(monthName, totalAmount, monthlyAmounts, dailyAmounts);
            monthlyInfoList.add(monthlyInfo);
        }
        return monthlyInfoList;
    }

    // Method to divide the total amount into 12 months
    public ArrayList<Double> divideAmountByMonths(double totalAmount) {
        ArrayList<Double> monthlyAmounts = new ArrayList<>();

        // Divide the total amount into 12 months
        double monthlyAmount = totalAmount / 12;

        // Fill the ArrayList with amounts for each month
        for (int i = 0; i < 12; i++) {
            monthlyAmounts.add(monthlyAmount);
        }
        return monthlyAmounts;
    }

    // Method to divide the total amount into each day
    public ArrayList<Double> divideAmountByDays(double totalAmount) {
        ArrayList<Double> dailyAmounts = new ArrayList<>();

        // Divide the total amount into 30 days (assume 30 days in each month)
        double dailyAmount = totalAmount / 30;

        // Fill the ArrayList with amounts for each day
        for (int i = 0; i < 30; i++) {
            dailyAmounts.add(dailyAmount);
        }
        return dailyAmounts;
    }

    // Method to get the month name based on its number
    public String getMonthName(int monthNumber) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[monthNumber];
    }
}
