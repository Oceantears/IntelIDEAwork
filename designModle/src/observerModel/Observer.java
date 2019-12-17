/**
 * <一句话功能简述>
 * <观察者类接口>
 *
 *     所有潜在的观察者必须实现观察者接口，这个接口只有update()一个方法，当主题状态改变时它被调用
 *
 * @author sunmeng
 * @create 2019/12/9   21:35
 */
package observerModel;

public interface Observer {
	//当气象观测值改变时，主题会把这些状态值当做方法的参数，传送给观察者
	public void update(float temp,float humidity,float pressure);
}
