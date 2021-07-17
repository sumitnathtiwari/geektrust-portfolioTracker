package com.example.geektrust.portfolio_tracker.utils;

import java.time.Month;
import java.util.List;

import com.example.geektrust.portfolio_tracker.funds.Fund;

public class Utils {

    public static void rebalancePortfolio(List<Fund> funds, Month currentMonth) {
        // rebalance if june or decemeber
        if (currentMonth.equals(Month.JUNE) || currentMonth.equals(Month.DECEMBER)) {
            double total = getTotalAmountOfFunds(funds);
            for (Fund fund : funds) {
                Double amount = Math.floor((fund.getPercentageAllocated() * total) / 100.0);
                fund.setCurrentAmount(amount);
                fund.addUpdateMonthlyChange(currentMonth, amount);
            }
        }
    }

    public static double getTotalAmountOfFunds(List<Fund> funds) {
        double total = 0;
        for (Fund fund : funds) {
            total += fund.getCurrentAmount();
        }
        return total;
    }    
}
