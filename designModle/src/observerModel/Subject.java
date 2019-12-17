/**
 * <一句话功能简述>
 * <主题接口类>
 *
 *     观察者模式中的主题接口，对象使用此接口注册为观察者，或者把自己从观察者中删除
 *
 * @author sunmeng
 * @create 2019/12/9   21:27
 */
package observerModel;

public interface Subject {
	//这两个方法都需要一个观察者对象作为变量，该观察者是用来被注册或者删除的
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);

	//当主题状态改变时，这个方法会被调用，以通知所有的观察者
	public void notifyObservers();
}
