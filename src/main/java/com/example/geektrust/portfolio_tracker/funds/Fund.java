package com.example.geektrust.portfolio_tracker.funds;

import java.time.Month;
import java.util.EnumMap;
import java.util.Map;

/**
 * Fund class which will be used by different types of funds
 * 
 */
public abstract class Fund {

    protected Month startDate;
    protected Double initialInvestment;
    protected Double sipAmount = 0.0;
    protected Double currentAmount;
    protected Double percentageAllocated;
    protected Month currentMonth;
    protected EnumMap<Month, Double> monthlyChange = new EnumMap<>(Month.class);

    /**
     * @return the currentAmount
     */
    public Double getCurrentAmount() {
        return currentAmount;
    }

    /**
     * @param currentAmount the currentAmount to set
     */
    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    /**
     * @return the percentageAllocated
     */
    public Double getPercentageAllocated() {
        return percentageAllocated;
    }

    /**
     * @param percentageAllocated the percentageAllocated to set
     */
    public void setPercentageAllocated(Double percentageAllocated) {
        this.percentageAllocated = percentageAllocated;
    }

    /**
     * @return the monthlyChange
     */
    public Map<Month, Double> getMonthlyChange() {
        return monthlyChange;
    }

    /**
     * @param Month,Double the monthlyChange to set
     */
    public void addUpdateMonthlyChange(Month currentMonth, Double amount) {
        this.monthlyChange.put(currentMonth, amount);
    }

    /**
     * @return the currentMonth
     */
    public Month getCurrentMonth() {
        return this.currentMonth;
    }

    /**
     * @param currentMonth the currentMonth to set
     */
    public void setCurrentMonth(Month currentMonth) {
        this.currentMonth = currentMonth;
    }

    /**
     * @param startDate
     * @param initialInvestment
     */
    protected Fund(Month startDate, Double initialInvestment, Double percentageAllocated) {
        this.startDate = startDate;
        this.initialInvestment = initialInvestment;
        this.percentageAllocated = percentageAllocated;
        this.currentAmount = initialInvestment;

    }

    /**
     * @return the startDate
     */
    public Month getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Month startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the initialInvestment
     */
    public Double getInitialInvestment() {
        return initialInvestment;
    }

    /**
     * @param initialInvestment the initialInvestment to set
     */
    public void setInitialInvestment(Double initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    /**
     * @return the sipAmount
     */
    public Double getSipAmount() {
        return sipAmount;
    }

    /**
     * @param sipAmount the sipAmount to set
     */
    public void setSipAmount(Double sipAmount) {
        this.sipAmount = sipAmount;
    }

    /**
     * 
     * @return Balanced Portfolio i.e. current Status of Portfolio
     */
    public String getPortfolioOfGivenMonth(Month currentMonth) {
        return String.valueOf(monthlyChange.get(currentMonth).intValue());
    }

    public void setMonthlyChange(Double changes, Month currentMonth) {
        if (!currentMonth.equals(Month.JANUARY)) {
            addSipToCurrentInvestment();
        }
        this.currentAmount = Math.floor(this.currentAmount + (changes * this.currentAmount) / 100.00);
        addUpdateMonthlyChange(currentMonth, this.currentAmount);
        setCurrentMonth(currentMonth);
    }

    public void addSipToCurrentInvestment() {
        this.currentAmount = this.currentAmount + sipAmount;
    }
}
