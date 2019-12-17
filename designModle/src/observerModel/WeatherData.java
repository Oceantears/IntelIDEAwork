/**
 * <一句话功能简述>
 *
 * <用观察者模式实现气象数据类>
 *
 * @author sunmeng
 * @create 2019/12/10   9:55
 */
package observerModel;

import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList observers;          //记录观察者
	private float temperature;        //温度
	private float humidity;           //湿度
	private float pressure;           //气压

	public WeatherData(){
		observers=new ArrayList();
	}

	@Override
	public void registerObserver(Observer o) {
		//添加观察者时加入
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i=observers.indexOf(o);
		if(i>0){
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++){
			Observer observer=(Observer) observers.get(i);
			observer.update(temperature,humidity,pressure);
		}
	}

	//当从气象站得到更新观测值时，我们通知观察者
	public void measurementsChanged(){
		notifyObservers();
	}

	public void setMeasurements(float temperature,float humidity,float pressure){
		this.temperature=temperature;
		this.humidity=humidity;
		this.pressure=pressure;
		measurementsChanged();
	}
}
