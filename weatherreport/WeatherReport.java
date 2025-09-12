package weatherreport;

public class WeatherReport {
    public static String Report(IWeatherSensor sensor) {
        int precipitation = sensor.Precipitation();
        // precipitation < 20 is a sunny day
        String report = "Sunny Day";

        if (sensor.TemperatureInC() > 25) {
            if (precipitation >= 20 && precipitation < 60) {
                report = "Partly Cloudy";
            } else if (sensor.WindSpeedKMPH() > 50) {
                report = "Alert, Stormy with heavy rain";
            }
        }
        return report;
    }

    private static void TestRainy() {
        IWeatherSensor sensor = new SensorStub();
        String report = Report(sensor);
        System.out.println("TestRainy -> " + report);
        // 🆕 Stronger assertion: must explicitly contain "rain"
        assert report.contains("rain") : "Expected rain in report but got: " + report;
    }

    private static void TestHighPrecipitation() {
        // 🆕 Custom stub: high precipitation (>60), low wind-speed (<50)
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
                return 28; // Warm enough to trigger cloud/rain logic
            }
            @Override
            public int WindSpeedKMPH() {
                return 10; // Low wind speed
            }
        };

        String report = Report(sensor);
        System.out.println("TestHighPrecipitation -> " + report);
        // 🆕 Stronger assertion: this will FAIL (currently returns "Sunny Day")
        assert report.contains("rain") : "Expected rain in report but got: " + report;
    }

    public static void main(String[] args) {
        TestRainy();
        TestHighPrecipitation();
        System.out.println("All is well (maybe!)");
    }
}

// 🔹 Default stub
class SensorStub implements IWeatherSensor {
    @Override
    public int Humidity() {
        return 72; // Stubbed humidity
    }
    @Override
    public int Precipitation() {
        return 70; // Stubbed precipitation
    }
    @Override
    public double TemperatureInC() {
        return 26; // Stubbed temperature
    }
    @Override
    public int WindSpeedKMPH() {
        return 52; // Stubbed wind speed
    }
}
