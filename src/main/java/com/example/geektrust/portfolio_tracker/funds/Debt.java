package com.example.geektrust.portfolio_tracker.funds;

import java.time.Month;

public class Debt extends Fund {

    /**
     * @param startDate
     * @param initialInvestment
     * @param percentageAllocated
     */
    public Debt(Month startDate, Double initialInvestment, Double percentageAllocated) {
        super(startDate, initialInvestment, percentageAllocated);
    }
    
}
