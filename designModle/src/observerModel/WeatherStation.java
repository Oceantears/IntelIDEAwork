/**
 * <一句话功能简述>
 * <气象站测试类>
 *
 * @author sunmeng
 * @create 2019/12/10   15:13
 */
package observerModel;

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData=new WeatherData();

		//建立布告板，并把weathData对象传递
		CurrentConditionsDisplay conditionsDisplay=new CurrentConditionsDisplay(weatherData);
		// StatisticsDisplay statisticsDisplay=new StatisticsDisplay(weatherData);

		//模拟气象测试
		weatherData.setMeasurements(80,65,30.4f);
		weatherData.setMeasurements(82,70,29.2f);
		weatherData.setMeasurements(78,90,29.2f);
	}
}
