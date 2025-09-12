package weatherreport;

// 🔹 Interface unchanged
public interface IWeatherSensor {
    double TemperatureInC();
    int Precipitation();
    int Humidity();
    int WindSpeedKMPH();
}
