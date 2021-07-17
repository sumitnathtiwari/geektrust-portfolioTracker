package com.example.geektrust.portfolio_tracker;

import java.io.IOException;

import com.example.geektrust.portfolio_tracker.controller.PortfolioAnalyser;

public class PortfolioTrackerApplication {

    public static void main(final String[] args) throws
            IOException {
        if (args.length == 0 || args[0].isEmpty()) {
            throw new NullPointerException("No file Path Provided As Argument");
        } else {
            PortfolioAnalyser.processing(args[0]);
        }
    }

}
