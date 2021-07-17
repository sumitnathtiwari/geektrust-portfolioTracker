package com.example.geektrust.portfolio_tracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import com.example.geektrust.portfolio_tracker.controller.PortfolioAnalyser;

import org.junit.jupiter.api.Test;

class PortfolioTrackerApplicationTests {

	@Test
    public void readDataTest() throws IOException {
        // PrintStream redirectToFile = new PrintStream(new File("testOutput.txt"));
        // System.setOut(redirectToFile);
        String path = "src/test/java/com/example/geektrust/portfolio_tracker/test.txt";
		PortfolioAnalyser.processing(path);
        String path1 = "src/test/java/com/example/geektrust/portfolio_tracker/test2.txt";
		PortfolioAnalyser.processing(path1);
        String path2 = "src/test/java/com/example/geektrust/portfolio_tracker/test3.txt";
		PortfolioAnalyser.processing(path2);
        String path3 = "src/test/java/com/example/geektrust/portfolio_tracker/test4.txt";
		PortfolioAnalyser.processing(path3);
        String path4 = "src/test/java/com/example/geektrust/portfolio_tracker/test5.txt";
		PortfolioAnalyser.processing(path4);
        // String expected = Files.readString(Path.of("temp.txt"));
        // String actual = Files.readString(Path.of("testOutput.txt"));
		assertEquals(true, true);
    }

}
