/**
 * <一句话功能简述>
 * <布告板共同的接口，只需要实现display()方法>
 *     当布告板需要显示时，调用display方法
 *
 * @author sunmeng
 * @create 2019/12/9   22:06
 */
package observerModel;

public interface DisplayElement {
	//当布告板需要显示时，调用此方法
	public void display();
}
