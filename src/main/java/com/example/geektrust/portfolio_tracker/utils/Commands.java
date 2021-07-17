package com.example.geektrust.portfolio_tracker.utils;

import java.time.Month;
import java.util.List;

import com.example.geektrust.portfolio_tracker.funds.Debt;
import com.example.geektrust.portfolio_tracker.funds.Equity;
import com.example.geektrust.portfolio_tracker.funds.Fund;
import com.example.geektrust.portfolio_tracker.funds.Gold;

public class Commands {

    /**
     * 
     * @param currentInput
     * @param funds
     * Allocate initial Investment of each funds
     */
    public static void allocateInitialInvestment(String[] currentInput, List<Fund> funds) {
        double total = 0.0;
        for (int amount = 1; amount < 4; amount++) {
            total += Double.valueOf(currentInput[amount]);
        }
        for (int fundType = 1; fundType < 4; fundType++) {
            funds.add(getFundObjects(fundType, Double.valueOf(currentInput[fundType]), total));
        }
    }

    /**
     * 
     * @param type
     * @param initialAmount
     * @param total         this will return the object of specified fund types
     *                      class 1=>equity,2=>debt,3=>gold
     * @return
     */
    public static Fund getFundObjects(int type, Double initialAmount, double total) {
        double percentage = 0.0;
        if (total > 0) {
            percentage = (initialAmount * 100) / total;
        }
        switch (type) {
            case 1:
                return new Equity(Month.JANUARY, initialAmount, Double.valueOf(percentage));
            case 2:
                return new Debt(Month.JANUARY, initialAmount, Double.valueOf(percentage));
            case 3:
                return new Gold(Month.JANUARY, initialAmount, Double.valueOf(percentage));
            default:
                return null;
        }
    }

    /**
     * 
     * @param currentInput
     * @param funds        update the portfolio of each months according to market
     *                     rate and rebalnce if needed
     */

    public static void marketChange(String[] currentInput, List<Fund> funds) {
        int fundType = 1;
        for (Fund fund : funds) {
            fund.setMonthlyChange(Double.valueOf(currentInput[fundType].replace("%", "")),
                    Month.valueOf(currentInput[4]));
            fundType++;
        }
        Utils.rebalancePortfolio(funds, Month.valueOf(currentInput[4]));

    }

    /**
     * 
     * @param currentInput
     * @param funds        set monthly sip
     */
    public static void setMonthlySip(String[] currentInput, List<Fund> funds) {
        int fundType = 1;
        for (Fund fund : funds) {
            fund.setSipAmount(Double.valueOf(currentInput[fundType]));
            fundType++;
        }
    }

    public static void rebalancedPortfolio(List<Fund> funds) {
        if (funds.get(0).getCurrentMonth().compareTo(Month.JUNE) >= 0) {
            Month rebalancedMonth = funds.get(0).getCurrentMonth().equals(Month.DECEMBER) ? Month.DECEMBER : Month.JUNE;
            Commands.printPortfolioOfGivenMonth(funds, rebalancedMonth);
        } else {
            System.out.println("CANNOT_REBALANCE");
        }
    }

    /**
     * 
     * @param funds
     * @param month It will output the current Portolio
     */
    public static void printPortfolioOfGivenMonth(List<Fund> funds, Month month) {
        for (Fund fund : funds) {
            System.out.print(fund.getPortfolioOfGivenMonth(month) + " ");
        }
        System.out.println("");
    }
}
