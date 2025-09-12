import tests.TshirtTests;
import tests.MisalignedTests;
import tests.WeatherReportTests;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running T-shirt tests...");
        TshirtTests.run();

        System.out.println("Running Misaligned tests...");
        MisalignedTests.run();

        System.out.println("Running WeatherReport tests...");
        WeatherReportTests.run();

        System.out.println("All tests executed (some should FAIL to expose bugs).");
    }
}

