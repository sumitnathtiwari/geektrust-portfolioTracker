package com.example.geektrust.portfolio_tracker.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.geektrust.portfolio_tracker.funds.Fund;
import com.example.geektrust.portfolio_tracker.utils.Commands;

public class PortfolioAnalyser {

    public static void processing(String filePath) throws FileNotFoundException {
        // this will process the file input
        List<Fund> funds = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String[] currentInput = scanner.nextLine().split(" ");
                if (currentInput.length == 0) {
                    continue;
                }
                processRawData(currentInput, funds);
            }
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("File Not Found");
        }
    }

    public static void processRawData(String[] currentInput, List<Fund> funds) {
        switch (currentInput[0]) {
            case "ALLOCATE":
                Commands.allocateInitialInvestment(currentInput, funds);
                break;
            case "SIP":
                Commands.setMonthlySip(currentInput, funds);
                break;

            case "CHANGE":
                Commands.marketChange(currentInput, funds);
                break;
            case "BALANCE":
                Commands.printPortfolioOfGivenMonth(funds, Month.valueOf(currentInput[1]));
                break;

            case "REBALANCE":
                Commands.rebalancedPortfolio(funds);
                break;

            default:
                break;
        }
    }
}
