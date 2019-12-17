/**
 * <一句话功能简述>
 * <布告板实现了Observer接口，可以从WeatherData对象中获得改变
 * 实现了DisplayElement接口，因为我们的API规定所有的布告板都要实现此接口>
 *
 * @author sunmeng
 * @create 2019/12/10   14:40
 */
package observerModel;

public class CurrentConditionsDisplay implements Observer,DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;

	//构造器需要weatherData对象（也就是主题）作为注册之用
	public CurrentConditionsDisplay(Subject weatherData){
		this.weatherData=weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature=temp;
		this.humidity=humidity;
		display();
	}
	@Override
	public void display() {
		System.out.println("Current conditions:"+temperature+"F degree and "+humidity+"% humidity");
	}

}
