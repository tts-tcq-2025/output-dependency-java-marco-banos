package tests;

import modules.WeatherReport;
import modules.SensorStub;
import services.IWeatherSensor;

public class WeatherReportTests {
    public static void run() {
        testRainy();
        testHighPrecipitation();
        System.out.println("WeatherReport tests completed.");
    }

    private static void testRainy() {
        IWeatherSensor sensor = new SensorStub();
        String report = WeatherReport.Report(sensor);
        System.out.println("TestRainy -> " + report);

        // Stronger assertion → should contain "rain"
        assert report.contains("rain") : "Expected rain in report but got: " + report;
    }

    private static void testHighPrecipitation() {
        IWeatherSensor sensor = new IWeatherSensor() {
            @Override
            public int Humidity() {
                return 60;
            }
            @Override
            public int Precipitation() {
                return 80; // High precipitation
            }
            @Override
            public double TemperatureInC() {
                return 28; // Warm
            }
            @Override
            public int WindSpeedKMPH() {
                return 10; // Low wind
            }
        };

        String report = WeatherReport.Report(sensor);
        System.out.println("TestHighPrecipitation -> " + report);

        // This will FAIL until bug is fixed
        assert report.contains("rain") : "Expected rain in report but got: " + report;
    }
}
